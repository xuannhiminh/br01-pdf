const express = require('express');
const admin = require('firebase-admin');
const serviceAccount = require('./gb26---pdf-7e0f77f56b76.json');

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
});

const app = express();
app.use(express.json());

const fs = require('fs');
const LOG_FILE = 'cron-fcm.log';

function log(message) {
  const timestamped = `[${new Date().toISOString()}] ${message}`;
  console.log(timestamped);
  fs.appendFileSync(LOG_FILE, timestamped + '\n');
}

function errorLog(message) {
  const timestamped = `[${new Date().toISOString()}] ERROR: ${message}`;
  console.error(timestamped);
  fs.appendFileSync(LOG_FILE, timestamped + '\n');
}


/**
 * Sends an FCM notification using the provided full message object.
 *
 * @param {object} fullMessage - The complete message body, e.g.:
 *   {
 *     "condition": "'utc11' in topics || 'utc10' in topics || 'utc9' in topics",
 *     "android": { "priority": "high" },
 *     "notification": { "title": "...", "body": "..." },
 *     "data": { ... },
 *   }
 * Must include one of: token, topic, or condition.
 *
 * @returns {Promise<string>} - Resolves to the FCM message ID.
 */
async function sendFCMMessage(fullMessage) {
  // Basic validation: ensure there's a target
  const hasTarget = fullMessage.token || fullMessage.topic || fullMessage.condition;
  if (!hasTarget) {
    throw new Error("Message must include a 'token', 'topic', or 'condition' field.");
  }

  // Send via Admin SDK
  return admin.messaging().send(fullMessage);
}



// (async () => {
//   try {
//     const message = {
//       topic: "'utc1'",
//       android: { priority: "high" },
//     };

//     const messageId = await sendFCMMessage(message);
//     log("Sent successfully, message ID:", messageId);
//   } catch (err) {
//     log("Error sending FCM message:", err);
//   }
// })();

// Schedule notifications at 9:00 for each UTC-based topic
const cron = require('node-cron');
const SERVER_OFFSET = 0; // server is at UTC+7
const SEND_HOUR    = 9;       // target local hour
const SEND_MINUTE  = 0;       // target local minute

function scheduleNotificationsAtLocal9() {
  for (let tz = -12; tz <= 14; tz++) {
    const localHour   = (SEND_HOUR   + (SERVER_OFFSET - tz) + 24) % 24;
    const localMinute = SEND_MINUTE;
    const topicName = `utc${tz}`; // topic names like 'utc-5', 'utc0', 'utc7', etc.
    const cronExpr    = `${localMinute} ${localHour} * * *`;   // “min hour …”
    cron.schedule(cronExpr, async () => {
      try {
        const message = {
          condition: `'${topicName}' in topics`,
          // condition: `'debug_device' in topics`,
          android: { priority: 'high' },
          // notification: { title: 'Hello!', body: `Scheduled notification for ${topicName}` },
        };
        const messageId = await sendFCMMessage(message);
        log(`Sent notification for ${topicName}, messageId: ${messageId}`);
      } catch (err) {
        errorLog(`Error sending for ${topicName}: ${err.stack || err}`);
      }
    });
    log(`Scheduled notification for ${topicName} at server ${localHour}:${localMinute.toString().padStart(2,'0')} (=> local ${SEND_HOUR}:${SEND_MINUTE})`);
  }
}

// initialize all schedules
// …existing code…

// Log server timezone, UTC offset and current time on startup
const tzName = Intl.DateTimeFormat().resolvedOptions().timeZone;
const utcOffset = -new Date().getTimezoneOffset() / 60;  // in hours
log(`Server timezone: ${tzName}, UTC${utcOffset >= 0 ? '+' : ''}${utcOffset}`);
log(`Server current time: ${new Date().toString()}`);

scheduleNotificationsAtLocal9();


