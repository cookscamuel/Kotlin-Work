import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.errordetecting.ui.theme.ErrorDetectingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ErrorDetectingTheme {
                // Set the content to display the composable functions
                Column(modifier = Modifier.fillMaxSize()) {
                    WelcomeMessage()
                    FarewellMessage()
                }
            }
        }
    }
}

@Composable
fun WelcomeMessage() {
    Text(
        text = "Welcome to Jetpack Compose!",
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun FarewellMessage() {
    Text(
        text = "Goodbye and see you soon!",
        style = MaterialTheme.typography.bodyLarge
    )
}

// Separate Preview for WelcomeMessage
@Preview(showBackground = true)
@Composable
fun PreviewWelcomeMessage() {
    ErrorDetectingTheme {
        WelcomeMessage()
    }
}

// Separate Preview for FarewellMessage
@Preview(showBackground = true)
@Composable
fun PreviewFarewellMessage() {
    ErrorDetectingTheme {
        FarewellMessage()
    }
}