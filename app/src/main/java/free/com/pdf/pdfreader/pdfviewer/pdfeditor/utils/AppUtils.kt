package free.pdf.documents.pdfreader.pdfviewer.pdfeditor.utils

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
         const val PUBLIC_LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1dQLxMwBEqpaXzkN+0fD9Pllgrx4VdM28l1kL0kooXF9A2rWG1UyjZLRVQIrAbTDIriKNi1P8aC5D4DHWan9MrDPXs9LA35TQth6PBfg9wZV8YhnXuzhp2bOizjgFaOd5BWIpUAvq5zB9CMQQM0inNpB87sUVPwpaICFY+1XghVcWEcZkcP9BnSMlG22iYcSUoicEAJmpvxBW2kttNmefU6gr9v/Oy7dSQdSfQydmuX8KWtoxfT2bqin0BQ1yEDfGaVmtMzsBZB3uESYXkfnpsYXgRjCmMv5FwSvCSgV4hKnDS1TcEdPUlpE38YHd4lJg66ECKlbMZNWPi+aLm2O2QIDAQAB"
     }
 }