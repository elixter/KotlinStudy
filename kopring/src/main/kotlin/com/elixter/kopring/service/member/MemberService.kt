package com.elixter.kopring.service.member

import com.elixter.kopring.aop.LogExecutionTime
import com.elixter.kopring.dto.member.CreateMemberParam
import com.elixter.persistence.member.MemberEntity
import com.elixter.persistence.member.MemberRepository
import com.elixter.persistence.member.MemberRole
import mu.KLogging
import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {

    // TODO: Caffein 캐싱 적용해보기.
    @LogExecutionTime
    fun createUser(param: CreateMemberParam): Mono<MemberEntity> {
        val member = MemberEntity(
            name = param.name,
            loginId = param.loginId,
            password = BCrypt.hashpw(param.password, BCrypt.gensalt()),
            email = param.email,
            role = MemberRole.MEMBER
        )

        return memberRepository.save(member)
            .also {
                logger.info { "[MemberService] member created - id : ${member.id}" }
            }
    }


    companion object : KLogging()
}