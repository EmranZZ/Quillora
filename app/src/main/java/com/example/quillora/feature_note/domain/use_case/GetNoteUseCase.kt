package com.example.quillora.feature_note.domain.use_case

import com.example.quillora.feature_note.domain.model.Note
import com.example.quillora.feature_note.domain.repository.NoteRepository

/**
 * @author EMRAN AHMED
 */

class GetNoteUseCase(
    private val repository: NoteRepository
){
    suspend operator fun invoke(id: Int): Note?{
        return repository.getNoteById(id)
    }
}