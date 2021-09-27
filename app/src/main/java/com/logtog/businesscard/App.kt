package com.logtog.businesscard

import android.app.Application
import com.logtog.businesscard.data.AppDatabase
import com.logtog.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}