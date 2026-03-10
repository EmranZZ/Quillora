package com.example.quillora.feature_note.domain.use_case

import com.example.quillora.feature_note.domain.model.Note
import com.example.quillora.feature_note.domain.repository.NoteRepository

/**
 * @author EMRAN AHMED
 */
class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}