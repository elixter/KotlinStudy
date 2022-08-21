package com.elixter.kopring.mapper.member

import com.elixter.kopring.domain.member.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class MemberMapperTest @Autowired constructor(val memberMapper: MemberMapper){

    @Test
    @Transactional
    fun save() {
        val member = Member(name = "test")
        memberMapper.save(member)

        log.info("member={}", member)
    }

    @Test
    @Transactional
    fun findById() {
        val member = Member(name = "findById")
        memberMapper.save(member)

        val findById = memberMapper.findById(member.id!!)
        log.info("findById={}", findById)
        Assertions.assertThat(findById).isEqualTo(member)
    }

    companion object {
        val log = LoggerFactory.getLogger(MemberMapperTest.toString())
    }
}