package free.pdf.documents.pdfreader.pdfviewer.pdfeditor.screen.language

interface BaseLanguageAdapter {
    fun filter(query: String)
    fun getDisplayList(): List<ItemSelected>
    val selected: String
}