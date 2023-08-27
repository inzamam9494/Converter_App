package com.example.converter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.converter.ui.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun converterScreen(
    vm: MyViewModel = viewModel()
) {

    val uiState = vm.uiState.collectAsState()

    Spacer(modifier = Modifier.padding(100.dp))

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Convert Temperature")

        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(value = uiState.value.userData,
            onValueChange = { vm.onTextChange(it) })
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Switch(checked = uiState.value.isFahrenhiet,
                onCheckedChange = { vm.updateSwitchState(it) })

            Spacer(modifier = Modifier.padding(5.dp))

            Text(text = if (uiState.value.isFahrenhiet) "Fahrenhiet" else "Celsius")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {vm.onUserSubmit()}) {
                Text(text = "Converter")
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Text(text = uiState.value.result)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun converterScreenPreview() {
//    ConverterTheme {
//        conveterScreen()
//    }
//}