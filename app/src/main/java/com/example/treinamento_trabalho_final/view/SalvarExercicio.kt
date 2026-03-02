package com.example.treinamento_trabalho_final.view

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.treinamento_trabalho_final.componentes.CaixaDeTexto
import com.example.treinamento_trabalho_final.datasource.ExerciciosDataSource
import com.example.treinamento_trabalho_final.model.Exercicio

@Composable
fun SalvarExercicio(exerciciosDataSource: ExerciciosDataSource, navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var cargaOuVelocidade by remember { mutableStateOf("") }
    var repeticoesOuDistancia by remember { mutableStateOf("") }
    val context = LocalContext.current // Obtém o contexto atual

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Card(
            Modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(16.dp)) {
                CaixaDeTexto(
                    valor = nome,
                    onValorMudanca = { nome = it },
                    label = "Exercício",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )
                CaixaDeTexto(
                    valor = cargaOuVelocidade,
                    onValorMudanca = { cargaOuVelocidade = it },
                    label = "Carga/Velocidade",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )
                CaixaDeTexto(
                    valor = repeticoesOuDistancia,
                    onValorMudanca = { repeticoesOuDistancia = it },
                    label = "Repetições/Distância",
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )
            }
        }
        Button(
            onClick = {
                val novoExercicio = Exercicio(
                    exercicio = nome,
                    cargaOuVelocidade = cargaOuVelocidade,
                    repeticoesOuDistancia = repeticoesOuDistancia
                )
                exerciciosDataSource.salvarExercicio(novoExercicio)

                // Exibe a mensagem com Toast após salvar
                Toast.makeText(
                    context,
                    "Exercício '${novoExercicio.exercicio}' salvo com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                navController.popBackStack() // Retorna à tela anterior
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Salvar")
        }
    }
}
