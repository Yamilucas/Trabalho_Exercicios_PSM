package com.example.treinamento_trabalho_final

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.treinamento_trabalho_final.datasource.ExerciciosDataSource
import com.example.treinamento_trabalho_final.ui.theme.Treinamento_trabalho_finalTheme
import com.example.treinamento_trabalho_final.view.ListaExercicios
import com.example.treinamento_trabalho_final.view.SalvarExercicio
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializando o Firebase
        FirebaseApp.initializeApp(this)

        // Configuração do conteúdo usando Jetpack Compose
        setContent {
            Treinamento_trabalho_finalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}
@Composable
fun MainContent() {
    val navController: NavHostController = rememberNavController()
    val exerciciosDataSource = ExerciciosDataSource()

    // Chamar listarExercicios ao iniciar
    LaunchedEffect(Unit) {
        exerciciosDataSource.listarExercicios()
    }

    NavHost(navController = navController, startDestination = "listaExercicios") {
        composable("listaExercicios") {
            ListaExercicios(exerciciosDataSource, navController)
        }
        composable("salvarExercicio") {
            SalvarExercicio(exerciciosDataSource, navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Treinamento_trabalho_finalTheme {
        MainContent()
    }
}
