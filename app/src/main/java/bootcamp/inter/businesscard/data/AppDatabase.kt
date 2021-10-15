package bootcamp.inter.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import bootcamp.inter.businesscard.domain.BusinessCard

/*
    Essa classe gerencia o banco de dados.
    @Database é uma notação do Room, o projeto possui apenas 1 entidade: BusinessCard e a versão
    é '1' porque é um novo db.
 */

@Database(entities = [BusinessCard::class], version = 1)

//A classe não possui implementações, por isso 'abstract'
abstract class AppDatabase : RoomDatabase() {

    abstract fun businessDao(): BusinessCardDao

    companion object {

        //  Esse companion object funciona como um Singleton (retorna 1 única instância).
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /*
            Essa função cria uma instancia da database caso ela não exista,
            ou retorna uma instância caso ela exista.
        */
        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}