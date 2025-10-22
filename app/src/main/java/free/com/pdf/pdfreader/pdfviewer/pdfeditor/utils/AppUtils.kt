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
         const val PUBLIC_LICENSE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzq/OUwnpxXby2YRcs/7A2lxFxtigB0wpKfHQQgCKYpjreLqraN+6QFDBGIjingEOMI3nOZZ3Wq7BFtjHcVG6K0NjlQ1oR61O+p093SxJF9vcGkoFqzwTwDkSoKz4RlPYD8LPt8inqsBk2g7g1fQozkxHyLB/GdgFck7guxlvuuOss10u9MNFZz3t1OjOM10rOx8/qV7SZjl6WA72EpZD38lPcqN4AsVf/8A7xRK8+z4k4ORJ3uIPZ81kINnms6JHBzCWpGeilefeWDQDMHxHtBqtePcwuyBcxxk05vvhdk6hBNus+I3AWycTuig8q/auExMjNCXdNhHfjxLs17IMgQIDAQAB"
     }
 }