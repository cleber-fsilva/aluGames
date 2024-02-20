package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Aluguel
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): DAO<Aluguel, AlugueEntity>(manager, AlugueEntity::class.java) {

    override fun toEntity(objeto: Aluguel): AlugueEntity {
        return AlugueEntity(objeto.gamer.toEntity(), objeto.jogo.toEntity(), objeto.periodo)
            .apply {
                valorDoAluguel = objeto.valorDoAluguel
                id = objeto.id
            }
    }
    override fun toModel(entity: AlugueEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply { id = entity.id }
    }
}