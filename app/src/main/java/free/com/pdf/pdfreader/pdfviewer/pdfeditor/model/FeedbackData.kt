package free.pdf.documents.pdfreader.pdfviewer.pdfeditor.model

import android.os.Build
import androidx.annotation.Keep
import com.ezteam.baseproject.utils.IAPUtils
import com.ezteam.baseproject.utils.PreferencesUtils
import free.pdf.documents.pdfreader.pdfviewer.pdfeditor.BuildConfig
import free.pdf.documents.pdfreader.pdfviewer.pdfeditor.common.PresKey
import free.pdf.documents.pdfreader.pdfviewer.pdfeditor.screen.language.PreferencesHelper
import java.util.Locale

@Keep
data class FeedbackData(
    val versionCode: Int = BuildConfig.VERSION_CODE,
    val message: String = "",
    val problem: String = "",

    val osApiLevel: Int = Build.VERSION.SDK_INT,
    val deviceModel: String = Build.MODEL,
    val locale: String = Locale.getDefault().toString(),

    val timestamp: Long = System.currentTimeMillis(),

    val isPremium: Boolean = IAPUtils.isPremium(),
    val type: String = "feedback",

    val installTime: Long? = -1L,
    val hasNotificationGranted: Boolean = false,
    val timeEnterApp: Int = PreferencesHelper.getInt(PresKey.TIME_ENTER_APP, 1),
    val timeShowNotification: Int = PreferencesUtils.getInteger("time_notification_show", 0),
    val timeClickedNotification: Int = PreferencesUtils.getInteger("time_notification_clicked", 0)
)