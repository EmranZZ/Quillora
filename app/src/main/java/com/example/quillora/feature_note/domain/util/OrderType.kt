package com.example.quillora.feature_note.domain.util

/**
 * @author EMRAN AHMED
 */
sealed class OrderType {

    object Ascending: OrderType()
    object Descending: OrderType()
}