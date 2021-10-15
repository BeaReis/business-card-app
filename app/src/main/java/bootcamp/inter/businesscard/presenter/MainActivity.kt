package bootcamp.inter.businesscard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bootcamp.inter.businesscard.databinding.ActivityMainBinding

/*
Essa classe é responsável por inflar o layout activity_main, o qual contém a recycle view com os
cartões, bem como o campo para pesquisa e o fab para adicionar novos cartões. Ou seja, a tela
primária do App.
 */


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}