package bootcamp.inter.businesscard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bootcamp.inter.businesscard.data.BusinessCardRepository

/*
    Essa classe é uma implementação obrigatória para a criação da val 'mainViewModel' na
    'MainActivity'.
 */

class MainViewModelFactory(private val repository: BusinessCardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}