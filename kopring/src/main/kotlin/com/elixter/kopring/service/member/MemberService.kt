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
import reactor.kotlin.core.publisher.switchIfEmpty

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
                logger.info { "[MemberService] member created - id : ${member.id}, loginId : ${member.loginId}, email : ${member.email}" }
            }
    }

    fun getMember(id: Long): Mono<MemberResponse> =
        memberRepository.findById(id)
            .switchIfEmpty {
                logger.warn { "[회원조회] 회원 조회에 실패했습니다. - id : ${id}" }
                throw Exception() // TODO: implement HandlerException
            }
            .mapNotNull {
                MemberResponse(
                    id = checkNotNull(it.id),
                    name = it.name,
                    loginId = it.loginId,
                    email = it.email,
                )
            }
            .doOnSuccess { logger.info { "[회원조회] 조회 결과 : ${it}" } }

    companion object : KLogging()
}