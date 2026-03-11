package com.example.quillora.feature_note.domain.use_case

import com.example.quillora.feature_note.domain.model.InvalidNoteException
import com.example.quillora.feature_note.domain.model.Note
import com.example.quillora.feature_note.domain.repository.NoteRepository

/**
 * @author EMRAN AHMED
 */

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            InvalidNoteException("Note Title Can Not be Empty")
        }

        if(note.content.isBlank()){
            InvalidNoteException("Note Content Can Not be Empty")
        }

        repository.insertNote(note)
    }
}