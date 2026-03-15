package com.example.quillora.feature_note.presentation.add_edit_note.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quillora.feature_note.domain.use_case.NoteUseCases
import javax.inject.Inject

/**
 * @author EMRAN AHMED
 */
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _noteTitle = mutableStateOf("")
    val noteTitle: State<String> = _noteTitle

    
}