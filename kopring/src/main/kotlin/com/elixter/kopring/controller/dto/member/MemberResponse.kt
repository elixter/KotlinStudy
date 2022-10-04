package com.elixter.kopring.controller.dto.member

data class MemberResponse(
    val id: Long,
    val name: String,
    val loginId: String,
    val email: String,
)