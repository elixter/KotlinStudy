package com.elixter.kopring.service.member

import com.elixter.kopring.domain.member.Member
import com.elixter.kopring.domain.member.MemberRole.MEMBER
import com.elixter.kopring.dto.member.CreateMemberDto
import com.elixter.kopring.mapper.member.MemberMapper
import org.mindrot.jbcrypt.BCrypt
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService @Autowired constructor(private val memberMapper: MemberMapper) {

    fun createUser(createMember: CreateMemberDto): Member {
        val newMember = Member(
            name = createMember.name,
            loginId = createMember.loginId,
            password = BCrypt.hashpw(createMember.password, BCrypt.gensalt()),
            email = createMember.email,
            role = MEMBER
        ).apply {
            memberMapper.save(this)
        }

        log.info("newMember={}", newMember)

        return newMember
    }

    companion object {
        val log = LoggerFactory.getLogger(MemberService.toString())
    }
}