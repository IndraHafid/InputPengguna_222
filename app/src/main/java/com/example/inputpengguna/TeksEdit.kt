package com.example.inputpengguna

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun FormDataDIri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }

    var Nama by remember { mutableStateOf(value = "") }
    var Alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = Modifier.padding(top = 50.dp),

    )
    }
}