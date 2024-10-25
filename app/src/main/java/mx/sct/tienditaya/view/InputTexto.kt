package mx.sct.tienditaya.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputTexto(text: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier, padding: Int = 16, onDone: () -> Unit = {}, keyBoardType: KeyboardType = KeyboardType.Text, placeHolder: String =""){
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = text,
        onValueChange =onValueChange,
        modifier = modifier
            .padding(horizontal = padding.dp)
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onTertiary)
            .border(1.dp, MaterialTheme.colorScheme.onTertiary),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                onDone()
                focusManager.clearFocus()
            }
        ),
        placeholder = {
            Text(placeHolder, color = Color.LightGray)
        }
    )
}