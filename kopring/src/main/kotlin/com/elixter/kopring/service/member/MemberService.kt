package com.elixter.kopring.service.member

import com.elixter.kopring.controller.dto.member.CreateMemberParam
import com.elixter.kopring.controller.dto.member.MemberResponse
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

    fun getUser(id: Long): Mono<MemberResponse> {
        return memberRepository.findById(id)
            .mapNotNull {
                MemberResponse(
                    id = checkNotNull(it.id),
                    name = it.name,
                    loginId = it.loginId,
                    email = it.email,
                )
            }
    }

    companion object : KLogging()
}