package com.example.quillora.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quillora.feature_note.domain.util.NoteOrder
import com.example.quillora.feature_note.domain.util.OrderType

/**
 * @author EMRAN AHMED
 */

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onChangeOrder: (NoteOrder) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Title",
                select = noteOrder is NoteOrder.Title,
                onSelect = {
                    onChangeOrder(NoteOrder.Title(noteOrder.orderType))
                }
            )
            Spacer(Modifier.height(8.dp))

            DefaultRadioButton(
                text = "Date",
                select = noteOrder is NoteOrder.Date,
                onSelect = {
                    onChangeOrder(NoteOrder.Date(noteOrder.orderType))
                }
            )
            Spacer(Modifier.height(8.dp))

            DefaultRadioButton(
                text = "Color",
                select = noteOrder is NoteOrder.Color,
                onSelect = {
                    onChangeOrder(NoteOrder.Color(noteOrder.orderType))
                }
            )

        }
        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                select = noteOrder.orderType is OrderType.Ascending ,
                onSelect = {
                    onChangeOrder(noteOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(Modifier.height(8.dp))

            DefaultRadioButton(
                text = "Descending",
                select = noteOrder.orderType is OrderType.Descending ,
                onSelect = {
                    onChangeOrder(noteOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}