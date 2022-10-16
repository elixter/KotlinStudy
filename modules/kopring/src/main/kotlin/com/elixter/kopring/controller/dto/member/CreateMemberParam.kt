package com.elixter.kopring.controller.dto.member

data class CreateMemberParam (
    val name: String,
    val loginId: String,
    val password: String,
    val email: String,
)