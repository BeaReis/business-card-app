package bootcamp.inter.businesscard.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bootcamp.inter.businesscard.data.BusinessCardRepository
import bootcamp.inter.businesscard.databinding.ItemBusinessCardBinding
import bootcamp.inter.businesscard.model.BusinessCard

/*
    A classe adapter providencia acesso aos itens dos dados, além de criar uma view para cada
    item no conjunto de dados.
 */

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listener: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemBusinessCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //TODO -- Verificar como enxugar o código 'checkVisibility'

        /*
            Essa função garante que os botões 'compartilhar', 'editar' e 'deletar' vão ficar
            visíveis ou não conforme a interação do usuário com o cartão.
        */
        private fun checkVisibility(item: BusinessCard): BusinessCard {
            if (binding.btnCompartilhar.visibility == View.VISIBLE
                && binding.btnEditar.visibility == View.VISIBLE
                && binding.btnDeletar.visibility == View.VISIBLE
            ) {
                binding.btnCompartilhar.visibility = View.GONE
                binding.btnEditar.visibility = View.GONE
                binding.btnDeletar.visibility = View.GONE
            } else {
                binding.btnCompartilhar.visibility = View.VISIBLE
                binding.btnEditar.visibility = View.VISIBLE
                binding.btnDeletar.visibility = View.VISIBLE
            }
            return item
        }

        /*
            Essa função mostra os dados do BusinessCard em uma view e define algumas ações de
            acordo com a interação do usuário com o 'card' e os botões de operações.
         */

        fun bind(item: BusinessCard) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.mcvContent.setOnClickListener {
                checkVisibility(item)
            }
            binding.btnCompartilhar.setOnClickListener {
                listener(binding.mcvContent)
            }
            //TODO -- Implementar botões de edição e remoção do card selecionado
            //binding.btnEditar.setOnClickListener {  }
            //binding.btnDeletar.setOnClickListener {  }
        }

    }
}


/*
    Essa classe implementa a interface DiffUtil.ItemCallback, usada para verificar a diferença
    entre duas listas.
 */
class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}
