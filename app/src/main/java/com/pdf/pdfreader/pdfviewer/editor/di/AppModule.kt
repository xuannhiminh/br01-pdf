package pdf.documents.pdfreader.pdfviewer.editor.di

import pdf.documents.pdfreader.pdfviewer.editor.database.AppDatabase
import pdf.documents.pdfreader.pdfviewer.editor.database.repository.FileModelRepository
import pdf.documents.pdfreader.pdfviewer.editor.database.repository.FileModelRepositoryImpl
import pdf.documents.pdfreader.pdfviewer.editor.screen.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single { FileModelRepositoryImpl(get()) as FileModelRepository}
    single { MainViewModel(androidApplication(), get()) }
}