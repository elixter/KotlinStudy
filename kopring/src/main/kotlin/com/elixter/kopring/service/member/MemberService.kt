package com.elixter.kopring.service.member

import com.elixter.kopring.aop.LogExecutionTime
import com.elixter.kopring.domain.member.Member
import com.elixter.kopring.domain.member.MemberRole.MEMBER
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
    fun createUser(newMember: Member): Member {
        val result = newMember.copy(
            password = BCrypt.hashpw(newMember.password, BCrypt.gensalt()),
            role = MEMBER
        ).apply {
            memberMapper.save(this)
        }
        logger.info("newMember={}", result)

        return result
    }

    companion object : KLogging()
}