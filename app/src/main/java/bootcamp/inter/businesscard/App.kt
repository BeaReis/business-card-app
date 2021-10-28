package bootcamp.inter.businesscard

import android.app.Application
import bootcamp.inter.businesscard.data.AppDatabase
import bootcamp.inter.businesscard.data.BusinessCardRepository

/*
    Essa classe inicia as instâncias da database e do repositor. Ela é executada antes da
    MainActivity.
 */

class App : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}