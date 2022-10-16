package com.elixter.kopring.service.member

import com.elixter.kopring.controller.dto.member.CreateMemberParam
import com.elixter.persistence.member.MemberRepository
import com.navercorp.fixturemonkey.kotlin.KFixtureMonkeyBuilder
import com.navercorp.fixturemonkey.kotlin.giveMeOne
import io.mockk.every
import io.mockk.mockk
import mu.KLogging
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import reactor.core.publisher.Mono

class MemberServiceTest {

    private var memberService: MemberService

    private var memberRepository: MemberRepository

    init {
        memberRepository = mockk()
        memberService = MemberService(
            memberRepository
        )
    }

    // TODO: Junit exception 해결해야함.
    @Test
    internal fun createMember() {
        // given
        val param = CreateMemberParam(
            name = "Taewon Lee",
            loginId = "createTest",
            password = "1q2w3e4r",
            email = "test@test.com"
        )

        // when
        every { memberRepository.save(any()) } returns Mono.just(FIXTURE.giveMeOne())
        val actual = assertDoesNotThrow { memberService.createUser(param) }

        // then
        Assertions.assertNotNull(actual.block()!!.id)
    }

    companion object : KLogging() {
        val FIXTURE = KFixtureMonkeyBuilder().defaultNotNull(true).build()
    }
}