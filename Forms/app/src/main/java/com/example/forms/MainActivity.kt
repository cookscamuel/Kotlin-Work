package com.example.forms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.forms.ui.theme.FormsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    SimpleRadioButtonGroup()

                }
            }
        }
    }
}

@Composable
fun CheckboxExample() {
    var isChecked by remember { mutableStateOf(false) }

    Column {

        Checkbox (
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )

        Text(text = if (isChecked) "Checkbox is Checked." else "Checkbox is not checked.")
    }
}

@Composable
fun DesignMyPage() {
    Column(
        modifier = Modifier.padding(16.dp)) {
        CheckboxExample()
    }
}

@Composable
fun SimpleRadioButtonGroup() {
    var selectedOption by remember { mutableStateOf("Option A") }

    Column {

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selectedOption == "Option A", onClick = { selectedOption = "Option A" }
            )
            Text(text = "Option A")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selectedOption == "Option B", onClick = { selectedOption = "Option B" }
            )
            Text(text = "Option B")
        }

        Text(text = "Selected Option: $selectedOption")
    }

}

@Composable
fun ExtendedRadioButtonGroup() {
    val options = listOf("option 1", "option 2", "option 3", "option 4", "option 5")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column {
        options.forEach { option -> // using a forEach loop to create options[i] amount of radio buttons
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = selectedOption == option, onClick = { selectedOption = option }
                )
                Text(text = option)
            }
        }

        Text(text = "Selected Option: $selectedOption") // simply display the selected option
    }
}

@Composable
fun SwitchDemo() {
    var switchState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {

        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it }
        )

        Text(text = if (switchState) "ON" else "OFF")
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayPreview() {
    ExtendedRadioButtonGroup()
}