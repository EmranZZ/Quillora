package com.example.quillora.feature_note.domain.use_case

/**
 * @author EMRAN AHMED
 */
data class NoteUseCases (
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNote: AddNoteUseCase
)