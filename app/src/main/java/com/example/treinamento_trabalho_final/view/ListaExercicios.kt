package com.example.treinamento_trabalho_final.view

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.treinamento_trabalho_final.datasource.ExerciciosDataSource
import com.example.treinamento_trabalho_final.model.Exercicio
import com.example.treinamento_trabalho_final.R

@Composable
fun ListaExercicios(exerciciosDataSource: ExerciciosDataSource, navController: NavController) {
    val exercicios: List<Exercicio> by exerciciosDataSource.exercicios.collectAsState()
    val context = LocalContext.current // Obtém o contexto atual

    Box(Modifier.padding(16.dp)) {
        LazyColumn(Modifier.padding(bottom = 16.dp)) {
            items(exercicios) { exercicio ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(
                            text = "Exercício: ${exercicio.exercicio}",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Carga/Velocidade: ${exercicio.cargaOuVelocidade}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Repetições/Distância: ${exercicio.repeticoesOuDistancia}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        // Botão de deletar com ícone
                        val isPressed = remember { mutableStateOf(false) }
                        IconButton(
                            onClick = {
                                isPressed.value = !isPressed.value
                                exerciciosDataSource.deletarExercicio(exercicio.id)
                                Toast.makeText(
                                    context,
                                    "Exercício '${exercicio.exercicio}' deletado com sucesso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete_foreground),
                                contentDescription = "Deletar",
                                tint = if (isPressed.value) Color.Blue else Color.Red,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = { navController.navigate("salvarExercicio") },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
