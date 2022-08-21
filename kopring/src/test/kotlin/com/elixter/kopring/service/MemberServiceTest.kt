package com.elixter.kopring.service

import com.elixter.kopring.dto.CreateMemberDto
import com.elixter.kopring.mapper.MemberMapper
import com.elixter.kopring.service.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class MemberServiceTest @Autowired constructor(val service: MemberService, val mapper: MemberMapper) {

    @Test
    @Transactional
    internal fun createMember() {
        with(CreateMemberDto(
            name = "Taewon Lee",
            loginId = "createTest",
            password = "1q2w3e4r",
            email = "test@test.com"
        ).let {
            service.createUser(it)
        }) {
            log.info("createMember={}", this)
            Assertions.assertThat(this).isEqualTo(mapper.findById(this.id!!))
        }
    }

    companion object {
        val log = LoggerFactory.getLogger(MemberServiceTest.toString())
    }
}