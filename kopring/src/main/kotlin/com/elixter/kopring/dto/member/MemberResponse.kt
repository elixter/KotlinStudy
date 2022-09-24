package com.elixter.kopring.dto.member

data class MemberResponse(
    val id: Long,
    val name: String,
    val loginId: String,
    val email: String,
)