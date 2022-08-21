package com.elixter.kopring.dto.member

import com.elixter.kopring.domain.member.MemberRole

data class UpdateMemberDto(
    val password: String? = null,
    val role: MemberRole? = null
)