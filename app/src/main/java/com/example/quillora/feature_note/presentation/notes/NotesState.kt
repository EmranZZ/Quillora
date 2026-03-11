package com.example.quillora.feature_note.presentation.notes

import com.example.quillora.feature_note.domain.model.Note
import com.example.quillora.feature_note.domain.util.NoteOrder
import com.example.quillora.feature_note.domain.util.OrderType

/**
 * @author EMRAN AHMED
 */
data class NotesState (
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)