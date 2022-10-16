package com.elixter.persistence.member

import com.elixter.persistence.BaseEntity
import com.elixter.persistence.member.MemberRole.MEMBER
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("members")
data class MemberEntity(
    @Id
    val id: Long? = null,
    val name: String = "",
    val loginId: String ="",
    val password: String = "",
    val email: String = "",
    val role: MemberRole = MEMBER,
    override val createdAt: LocalDateTime = LocalDateTime.now(),
    override var updatedAt: LocalDateTime = LocalDateTime.now(),
) : BaseEntity()