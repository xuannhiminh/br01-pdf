package free.pdf.documents.pdfreader.pdfviewer.pdfeditor.di

import free.pdf.documents.pdfreader.pdfviewer.pdfeditor.database.AppDatabase
import free.pdf.documents.pdfreader.pdfviewer.pdfeditor.database.repository.FileModelRepository
import free.pdf.documents.pdfreader.pdfviewer.pdfeditor.database.repository.FileModelRepositoryImpl
import free.pdf.documents.pdfreader.pdfviewer.pdfeditor.screen.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single { FileModelRepositoryImpl(get()) as FileModelRepository}
    single { MainViewModel(androidApplication(), get()) }
}