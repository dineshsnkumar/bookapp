package io.projects.book_service.dto

import java.time.LocalDateTime

data class ApiErrorResponse(val timestamp: LocalDateTime, val status: Int,
                            val error:String, val message: String)
