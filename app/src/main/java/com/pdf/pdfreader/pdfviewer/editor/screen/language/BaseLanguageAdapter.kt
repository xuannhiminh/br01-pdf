package pdf.documents.pdfreader.pdfviewer.editor.screen.language

interface BaseLanguageAdapter {
    fun filter(query: String)
    fun getDisplayList(): List<ItemSelected>
    val selected: String
}