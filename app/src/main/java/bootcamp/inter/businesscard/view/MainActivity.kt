package bootcamp.inter.businesscard.view

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import bootcamp.inter.businesscard.App
import bootcamp.inter.businesscard.databinding.ActivityMainBinding
import bootcamp.inter.businesscard.util.Image
import bootcamp.inter.businesscard.viewmodel.MainViewModel
import bootcamp.inter.businesscard.viewmodel.MainViewModelFactory

/*
Essa classe é responsável por inflar o layout activity_main, o qual contém a recycle view com os
cartões, bem como o campo para pesquisa e o fab para adicionar novos cartões. Ou seja, a tela
primária do App.
 */


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpPermissions()
        binding.rvCards.adapter = adapter
        insertListeners()
        getAllBusinessCard()
    }

    // Essa função trabalha as permissões para gravar e ler o armazenamento do dispositivo

    private fun setUpPermissions() {

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
    }

    //  Essa função
    private fun insertListeners() {

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }

        adapter.listener = { card ->
            Image.share(this@MainActivity, card)
        }

        /* TODO -- Adicionar ação de filtrar card pelo atributo (nome, nome da empresa, cargo)
          binding.mbFilter.setOnClickListener {
            val filterText = binding.etFilter.editText.toString()
        }
         */
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this, { businessCards ->
            adapter.submitList(businessCards)
        })
    }

}