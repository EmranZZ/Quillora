package com.example.quillora.feature_note.presentation.util

/**
 * @author EMRAN AHMED
 */
sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_note_screen")
}