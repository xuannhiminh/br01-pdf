package pdf.documents.pdfreader.pdfviewer.editor.utils

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import java.util.Currency
import java.util.Locale

class AppUtils {

     companion object {
         fun getCurrencySymbol(currencyCode: String, locale: Locale = Locale.getDefault()): String {
             return Currency.getInstance(currencyCode)
                 .getSymbol(locale)
         }
        fun isWidgetNotAdded(context: Context, widgetClass: Class<*>): Boolean {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(ComponentName(context, widgetClass))
            return appWidgetIds.isEmpty()
        }
         const val PDF_DETAIL_EZLIB = 0L // 0 mean use EZ lib pdf detail, 1 mean use SoLib PDF detail
         const val FOLDER_EXTERNAL_IN_DOWNLOADS = "AllPDFReaderTripSoft"
         const val PUBLIC_LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9ZFkLTOTc0ZAe7R+5OdcVaR0ELfdQPzJdD5XZ30aF9Q9unJbLP5uQ0Bp1OT3z9hhWcPaq13gH62Q+fArayD5Jxcv/jm8WJmy9b36I4CvhvPXyuMmey0LcwmIKIDdn3ixn+r+ZEt3WdrTFG2+4cnzUB2fI+59mLc+9XhWa+TDyYc+dpSrzTF3vPzV3UYg655b5uLsS8ruS2/wHpSIwL/u1Ax2NbMKTUr7BPT2SYXiuQee/9KexIxDEc+nLjNMaSNBU8nEMOT3bO1nz40nDTvEbE8OsPEbAzhPRifA/10nJLLYBRDoNjq7ZIkK7LfQBjrG0YpD4tUR5VntQrJRGjcjewIDAQAB"
     }
 }