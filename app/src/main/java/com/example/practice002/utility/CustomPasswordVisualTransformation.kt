package com.example.practice002.utility

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

class CustomPasswordVisualTransformation(
    private val mask: Char = '•',
    private val fontSize: Int = 26,
    private val letterSpacing: Float = 0.5f
) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val maskString = mask.toString().repeat(text.text.length)
        val styled = AnnotatedString(
            text = maskString,
            spanStyles = listOf(
                AnnotatedString.Range(
                    SpanStyle(
                        fontSize = fontSize.sp,
                        letterSpacing = letterSpacing.sp
                    ),
                    start = 0,
                    end = maskString.length
                )
            )
        )
        return TransformedText(styled, OffsetMapping.Identity)
    }
}