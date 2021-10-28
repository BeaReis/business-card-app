package bootcamp.inter.businesscard.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Essa data class possui os tipos de dados que serão usados no app, além de conter uma tabela SQLite
mapeável em seu banco de dados. A persistência dos dados será feita no armazenamento local.
 */

//TODO -> Adicionar propriedade 'corDoCartao' à entidade.

@Entity
data class BusinessCard (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val email: String,
    val telefone: String,
    val empresa: String,
    )