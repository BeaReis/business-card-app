package bootcamp.inter.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.*
import bootcamp.inter.businesscard.model.BusinessCard

/*
    Essa inteface oferece métodos abstratos de acesso ao banco de dados do app através
    do DAO (Data Access Object).
 */

@Dao
interface BusinessCardDao {

    //@Query busca os dados no banco de dados.
    @Query("SELECT * FROM BusinessCard")
    fun getAll(): LiveData<List<BusinessCard>>

    //@Insert gera uma implementação que insere todos os parâmetros no db
    //Caso haja conflito durante o processo, 'IGNORE' mantém as colunas existentes.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (businessCard: BusinessCard)

    //@Update modifica no banco de dados um conjunto de entidades fornecidas como parâmetros.
    @Update
    fun update (businessCard: BusinessCard)

    //@Delete remove do banco de dados um conjunto de entidades fornecidas como parâmetros.
    @Delete
    fun delete (businessCard: BusinessCard)


}