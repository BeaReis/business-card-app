package bootcamp.inter.businesscard.data

import androidx.lifecycle.LiveData
import bootcamp.inter.businesscard.domain.BusinessCard

/*
    Essa classe é um repositório que faz o acesso à database por meio da interface Dao.
 */

class BusinessCardRepository(private val dao: BusinessCardDao) {

    /*
        Usar o LiveData com o Room possibilita que os dados exibidos na UI estejam sincronizados
        com os dados armazenados no banco de dados. O LiveData é uma data holder class que pode ser
        observada dentro de uma lifecycle.
     */

    val listBusinessCard: LiveData<List<BusinessCard>>
        get() = dao.getAll()

    /*
    Aqui foram criadas funções suspensas para trabalhar os métodos da interface Dao através de
    corrotinas.
     */

    suspend fun insert(businessCard: BusinessCard){
        dao.insert(businessCard)
    }

    suspend fun update(businessCard: BusinessCard) {
        dao.update(businessCard)
    }

    suspend fun delete(businessCard: BusinessCard) {
        dao.delete(businessCard)
    }

}