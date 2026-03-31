package com.example.quillora.feature_note.presentation.notes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quillora.feature_note.presentation.notes.components.NoteItem
import com.example.quillora.feature_note.presentation.notes.components.OrderSection
import com.example.quillora.feature_note.presentation.notes.viewmodel.NotesViewModel
import com.example.quillora.feature_note.presentation.util.Screen
import kotlinx.coroutines.launch

/**
 * @author EMRAN AHMED
 */

@Composable
fun NotesScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditNoteScreen.route)
                },
                containerColor = FloatingActionButtonDefaults.containerColor
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add Note"
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your note",
                    style = MaterialTheme.typography.titleLarge
                )
                IconButton(
                    onClick = {
                        viewModel.onEvent(NoteEvent.ToggleOrderSection)
                    },
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Sort,
                        contentDescription = "Sort"
                    )
                }
            }

            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {

                OrderSection(
                    modifier = Modifier,
                    noteOrder = state.noteOrder,
                    onChangeOrder = {
                        viewModel.onEvent(NoteEvent.Order(it))
                    }
                )
            }
            Spacer(Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.notes){ note->
                    NoteItem(
                        note = note,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable{

                                navController.navigate(
                                    Screen.AddEditNoteScreen.route +
                                    "?noteId=${note.id}&noteColor=${note.color}"
                                )
                            }
                        ,
                        onDeleteClick = {
                            viewModel.onEvent(NoteEvent.DeleteNote(note))

                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    message = "Note deleted",
                                    actionLabel = "Undo"
                                )
                                if(result == SnackbarResult.ActionPerformed){
                                    viewModel.onEvent(NoteEvent.RestoreNote)
                                }
                            }
                        }
                    )
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NotesScreen(navController = NavController(LocalContext.current))
}