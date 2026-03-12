package com.example.quillora.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @author EMRAN AHMED
 */

@Composable
fun DefaultRadioButton(
    text: String,
    select: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
){
    RadioButton(
        selected = select,
        onClick = onSelect,
        modifier = modifier,
        colors = RadioButtonDefaults.colors(
            selectedColor = MaterialTheme.colorScheme.primary,
            unselectedColor = MaterialTheme.colorScheme.onBackground
        )
    )

    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge
    )
}