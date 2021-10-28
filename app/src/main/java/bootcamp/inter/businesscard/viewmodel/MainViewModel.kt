package bootcamp.inter.businesscard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bootcamp.inter.businesscard.data.BusinessCardRepository
import bootcamp.inter.businesscard.model.BusinessCard
import bootcamp.inter.businesscard.view.MainActivity

/*

 */

class MainViewModel(private val businessCardRepository: BusinessCardRepository): ViewModel() {



    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }

    fun getAll(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }

    //TODO -- Implementar o uso do 'update' e do 'delete'

    fun update(businessCard: BusinessCard) {
        businessCardRepository.update(businessCard)
    }

    fun delete(businessCard: BusinessCard) {
        businessCardRepository.delete(businessCard)
    }

}


