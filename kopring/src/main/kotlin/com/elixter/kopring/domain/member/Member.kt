package com.elixter.kopring.domain.member

import com.elixter.kopring.domain.member.MemberRole.MEMBER

data class Member (
    val id: Long? = null,
    val name: String = "",
    val loginId: String ="",
    val password: String = "",
    val email: String = "",
    val role: MemberRole = MEMBER
)