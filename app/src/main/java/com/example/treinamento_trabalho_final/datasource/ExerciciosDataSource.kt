package com.example.treinamento_trabalho_final.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.example.treinamento_trabalho_final.model.Exercicio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExerciciosDataSource {
    private val db = FirebaseFirestore.getInstance()
    private val _exercicios = MutableStateFlow<List<Exercicio>>(emptyList())
    val exercicios: StateFlow<List<Exercicio>> = _exercicios

    // Função para salvar um novo exercício
    fun salvarExercicio(exercicio: Exercicio) {
        db.collection("exercicios")
            .get()
            .addOnSuccessListener { result ->
                // Gera um novo ID baseado no número de documentos existentes
                val id = "exerc${result.size() + 1}"
                val exercicioMap = mapOf(
                    "exercicio" to exercicio.exercicio,
                    "cargaOuVelocidade" to exercicio.cargaOuVelocidade,
                    "repeticoesOuDistancia" to exercicio.repeticoesOuDistancia
                )

                db.collection("exercicios")
                    .document(id) // Usa o ID gerado
                    .set(exercicioMap)
                    .addOnSuccessListener {
                        listarExercicios() // Atualiza a lista após salvar
                    }
                    .addOnFailureListener { exception ->
                        println("Erro ao salvar exercício: ${exception.message}")
                    }
            }
            .addOnFailureListener { exception ->
                println("Erro ao obter exercícios: ${exception.message}")
            }
    }


    fun listarExercicios() {
        db.collection("exercicios")
            .get()
            .addOnSuccessListener { result ->
                val lista = result.map { doc ->
                    Exercicio(
                        id = doc.id, // Adicionado para capturar o ID do documento
                        exercicio = doc.getString("exercicio") ?: "",
                        cargaOuVelocidade = doc.getString("cargaOuVelocidade") ?: "",
                        repeticoesOuDistancia = doc.getString("repeticoesOuDistancia") ?: ""
                    )
                }
                _exercicios.value = lista
            }
            .addOnFailureListener { exception ->
                println("Erro ao listar exercícios: ${exception.message}")
            }
    }



    fun deletarExercicio(id: String) {
        db.collection("exercicios")
            .document(id)
            .delete()
            .addOnSuccessListener {
                listarExercicios() // Atualiza a lista após deletar
            }
            .addOnFailureListener { exception ->
                println("Erro ao deletar exercício: ${exception.message}")
            }
    }
}
