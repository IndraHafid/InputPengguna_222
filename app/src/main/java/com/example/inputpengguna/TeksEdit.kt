package com.example.inputpengguna

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.selection.selectable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(
            value = textNama,
            onValueChange = { textNama = it },
            label = { Text(text = "Nama Lengkap") },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (textJK == item),
                            onClick = { textJK = item }
                        )
                        .padding(horizontal = 8.dp)
                ) {
                    RadioButton(
                        selected = (textJK == item),
                        onClick = { textJK = item }
                    )
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(width = 250.dp),
            label = {Text(text = "Alamat Lengkap")},
            onValueChange = {
                textAlamat = it
            }
        )
        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(
                    id = R.dimen.padding_medium
                )),
            thickness = dimensionResource(id = R.dimen.divider_tipis ),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(1f),
            // the button is enabled when the user makes a selection
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                Nama = textNama
                jenis=textJK
                Alamat = textAlamat
            }
        ) {
            Text(stringResource(R.string.Submit))
        }
        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            Column (modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),){

                Text(text = "Nama   : "+Nama, color = Color.White )
                Text(text = "Gender : "+jenis, color = Color.White )

                Text(text = "Alamat : "+Alamat, color = Color.White)
            }
        }
    }
}