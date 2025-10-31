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
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun FormDataDIri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var selectedStatus by remember { mutableStateOf("") }

    var Nama by remember { mutableStateOf(value = "") }
    var Status by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }


    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF9C27B0), Color.White)
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 40.dp)
        ) {
            Text(
                text = "Formulir Pendaftaran",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Card(
                modifier = Modifier.width(320.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "NAMA LENGKAP",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium
                    )

                    OutlinedTextField(
                        value = textNama,
                        onValueChange = { textNama = it },
                        label = { Text(text = "Nama Lengkap") },
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.width(250.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "JENIS KELAMIN",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    gender.forEach { item ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .selectable(
                                        selected = (textJK == item),
                                        onClick = { textJK = item }
                                    )
                                    .padding(start = 8.dp)
                            ) {
                                RadioButton(
                                    selected = (textJK == item),
                                    onClick = { textJK = item }
                                )
                                Text(text = item)
                            }
                        }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "STATUS PERKAWINAN",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    statusList.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (selectedStatus == item),
                                    onClick = { selectedStatus = item }
                                )
                                .padding(start = 8.dp)
                        ) {
                            RadioButton(
                                selected = (selectedStatus == item),
                                onClick = { selectedStatus = item }
                            )
                            Text(text = item)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // ALAMAT
                    Text(
                        text = "ALAMAT",
                        color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium
                    )

                    OutlinedTextField(
                        value = textAlamat,
                        singleLine = true,
                        modifier = Modifier.width(width = 250.dp),
                        label = { Text(text = "Alamat Lengkap") },
                        onValueChange = {
                            textAlamat = it
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    HorizontalDivider(
                        modifier = Modifier.padding(
                            bottom = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(
                                id = R.dimen.padding_medium
                            )
                        ),
                        thickness = dimensionResource(id = R.dimen.divider_tipis),
                        color = Color.DarkGray
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),

                        // the button is enabled when the user makes a selection
                        enabled = textAlamat.isNotEmpty(),
                        onClick = {
                            Nama = textNama
                            jenis = textJK
                            Alamat = textAlamat
                            Status = selectedStatus

                        }
                    ) {
                        Text(stringResource(R.string.Submit))
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Black),
                        modifier = Modifier
                            .wrapContentHeight()
                            .width(300.dp)
                    ) {
                        Column(modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),) {

                            Text(text = "Nama   : " + Nama, color = Color.White)
                            Text(text = "Gender : " + jenis, color = Color.White)
                            Text(text = "Status : " + Status, color = Color.White)
                            Text(text = "Alamat : " + Alamat, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}