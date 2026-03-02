package com.example.treinamento_trabalho_final.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CaixaDeTexto(
    valor: String,
    onValorMudanca: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = valor,
        onValueChange = onValorMudanca,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        label = { Text(label) }
    )
}
