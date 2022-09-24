package com.elixter.kopring.service.member

import com.elixter.kopring.aop.LogExecutionTime
import com.elixter.kopring.domain.member.Member
import com.elixter.kopring.domain.member.MemberRole
import com.elixter.kopring.domain.member.MemberRole.MEMBER
import com.elixter.kopring.dto.member.CreateMemberParam
import com.elixter.kopring.mapper.member.MemberMapper
import mu.KLogging
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class MemberService @Autowired constructor(private val memberMapper: MemberMapper) {

    // TODO: Caffein 캐싱 적용해보기.
    @LogExecutionTime
    fun createUser(param: CreateMemberParam): Member {
        val member = Member(
            name = param.name,
            loginId = param.loginId,
            password = BCrypt.hashpw(param.password, BCrypt.gensalt()),
            email = param.email,
            role = MEMBER
        )
        memberMapper.insert(member)
        logger.info { "[MemberService] member created - id : ${member.id}" }

        return member
    }


    companion object : KLogging()
}