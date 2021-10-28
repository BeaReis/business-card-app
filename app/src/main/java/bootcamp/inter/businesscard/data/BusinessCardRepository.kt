package bootcamp.inter.businesscard.data

import androidx.lifecycle.LiveData
import bootcamp.inter.businesscard.model.BusinessCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Essa classe é um repositório que faz o acesso à database por meio da interface Dao.
 */

class BusinessCardRepository(private val dao: BusinessCardDao) {

    /*
    TODO -> Implementar LiveData
        Usar o LiveData com o Room possibilita que os dados exibidos na UI estejam sincronizados
        com os dados armazenados no banco de dados. O LiveData é uma data holder class que pode ser
        observada dentro de uma lifecycle.
    */

    fun insert(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(businessCard)
        }
    }

    fun getAll() = dao.getAll()

    fun update(businessCard: BusinessCard) {
        dao.update(businessCard)
    }

    fun delete(businessCard: BusinessCard) {
        dao.delete(businessCard)
    }

}