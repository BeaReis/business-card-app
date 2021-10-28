package bootcamp.inter.businesscard.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import bootcamp.inter.businesscard.App
import bootcamp.inter.businesscard.R
import bootcamp.inter.businesscard.databinding.ActivityAddBusinessCardBinding
import bootcamp.inter.businesscard.model.BusinessCard
import bootcamp.inter.businesscard.viewmodel.MainViewModel
import bootcamp.inter.businesscard.viewmodel.MainViewModelFactory

/*

 */

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
       MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {

        binding.mbSalvar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tiNome.editText?.text.toString(),
                empresa = binding.tiEmpresa.editText?.text.toString(),
                telefone = binding.tiTelefone.editText?.text.toString(),
                email = binding.tiEmail.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.ibCancel.setOnClickListener {
            finish()
        }
    }
}

