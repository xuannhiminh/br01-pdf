package free.pdf.documents.pdfreader.pdfviewer.pdfeditor.screen.base

import com.google.android.gms.ads.nativead.NativeAd

interface IAdsControl {
    fun onNativeAdLoaded(nativeAd: NativeAd?)

    fun onAdFailedToLoad()
}