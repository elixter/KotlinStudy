package com.elixter.kopring.dto.member

data class CreateMemberParam (
    val name: String,
    val loginId: String,
    val password: String,
    val email: String,
)