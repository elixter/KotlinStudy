package com.elixter.kopring.dto

data class CreateMemberDto (
    val name: String,
    val loginId: String,
    val password: String,
    val email: String,
)