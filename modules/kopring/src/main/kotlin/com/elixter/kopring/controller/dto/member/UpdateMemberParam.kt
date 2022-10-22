package com.elixter.kopring.controller.dto.member

import com.elixter.persistence.member.MemberRole

data class UpdateMemberParam(
    val password: String? = null,
    val role: MemberRole? = null
)