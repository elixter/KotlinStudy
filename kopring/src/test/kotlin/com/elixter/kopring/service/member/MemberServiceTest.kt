package com.elixter.kopring.service.member

import com.elixter.kopring.dto.member.CreateMemberParam
import com.elixter.kopring.mapper.member.MemberMapper
import mu.KLogging
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class MemberServiceTest @Autowired constructor(val service: MemberService, val mapper: MemberMapper) {

    @Test
    @Transactional
    internal fun createMember() {
        with(
            CreateMemberParam(
            name = "Taewon Lee",
            loginId = "createTest",
            password = "1q2w3e4r",
            email = "test@test.com"
        ).let {
            service.createUser(it)
        }) {
            logger.info("createMember={}", this)
            Assertions.assertThat(this).isEqualTo(mapper.findById(this.id!!))
        }
    }

    companion object : KLogging()
}