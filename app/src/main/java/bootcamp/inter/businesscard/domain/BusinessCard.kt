package bootcamp.inter.businesscard.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Essa data class possui os tipos de dados que serão usados no app, além de conter uma tabela SQLite
mapeável em seu banco de dados. A persistência dos dados será feita no armazenamento local.
 */

@Entity
data class BusinessCard (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val cargo: String,
    val email: String,
    val telefone: String,
    val empresa: String,
    val corDoCard: String
    )