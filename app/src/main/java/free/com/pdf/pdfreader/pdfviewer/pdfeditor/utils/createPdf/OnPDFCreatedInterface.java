package free.pdf.documents.pdfreader.pdfviewer.pdfeditor.utils.createPdf;

public interface OnPDFCreatedInterface {
    void onPDFCreationStarted();
    void onPDFCreated(boolean success, String path);
}
