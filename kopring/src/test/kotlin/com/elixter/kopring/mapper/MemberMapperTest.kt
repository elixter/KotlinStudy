package com.elixter.kopring.mapper

import com.elixter.kopring.domain.Member
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberMapperTest @Autowired constructor(val memberMapper: MemberMapper){

    @Test
    fun save() {
        val member = Member(name = "test")
        memberMapper.save(member)

        log.info("member={}", member)
    }

    companion object {
        val log = LoggerFactory.getLogger(MemberMapperTest.toString())
    }
}