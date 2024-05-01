package com.example.finalproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Button
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString

@Composable
fun Writing(navController: NavHostController) {

    var inputText by remember { mutableStateOf("") }
    var correctedText by remember { mutableStateOf("") }
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val maxWordCount = 200
    val wordCount = inputText.split("\\s+".toRegex()).count { it.isNotEmpty() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Button(
            onClick = { navController.navigate("HomePage") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x6F2197F7),
            ),
        ) {
            Text(stringResource(R.string.BACK), fontSize = 15.sp, color = Color.DarkGray)
        }

        OutlinedTextField(
            value = inputText,
            onValueChange = { if (wordCount <= maxWordCount) inputText = it },
            label = { Text("Enter text for correction") },
            placeholder = { Text("Type here...") },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xE9E6EFF7))
                .weight(1f),
            maxLines = 30,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                // Simulate AI processing and set corrected text
                correctedText = " $inputText"
            })
        )

        Text("Remaining Words: ${maxWordCount - wordCount}")

        Button(
            onClick = {
                // Simulate AI processing and set corrected text
                correctedText = " $inputText"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x6F2197F7)
            ),
            modifier = Modifier.align(Alignment.End),
        ) {
            Text(stringResource(R.string.Submit), color = Color.DarkGray)
        }

        Spacer(modifier = Modifier.height(16.dp) )

        OutlinedTextField(
            value = correctedText,
            onValueChange = { correctedText = it },
            label = { Text("Corrected text by AI") },
            readOnly = true, // Make this field read-only
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xE9E6EFF7))
                .weight(1f),
            maxLines = 10
        )

        Spacer(modifier = Modifier.height(8.dp) )

        Button(
            onClick = {
                clipboardManager.setText(AnnotatedString(correctedText))
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x6F2197F7)
            ),
            modifier = Modifier.align(Alignment.End),
        ) {
            Text(stringResource(R.string.Copy), color = Color.DarkGray)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WritingPreview(){
    val navController = rememberNavController()
    Writing(navController)
}