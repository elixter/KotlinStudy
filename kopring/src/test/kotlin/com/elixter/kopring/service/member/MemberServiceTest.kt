package com.elixter.kopring.service.member

import com.elixter.kopring.dto.member.CreateMemberParam
import mu.KLogging
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class MemberServiceTest @Autowired constructor(val service: MemberService) {

    
    // TODO: Mockk, FixtureMonkey 적용
    @Test
    @Transactional
    internal fun createMember() {
        // given
        val param = CreateMemberParam(
            name = "Taewon Lee",
            loginId = "createTest",
            password = "1q2w3e4r",
            email = "test@test.com"
        )

        // when
        val actual = assertDoesNotThrow { service.createUser(param) }

        // then
        Assertions.assertEquals(param.name, actual.name)
    }

    companion object : KLogging()
}