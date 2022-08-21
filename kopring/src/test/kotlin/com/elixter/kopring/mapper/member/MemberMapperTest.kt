package com.elixter.kopring.mapper.member

import com.elixter.kopring.domain.member.Member
import com.elixter.kopring.domain.member.MemberRole
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mindrot.jbcrypt.BCrypt
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class MemberMapperTest @Autowired constructor(val memberMapper: MemberMapper) {

    @Test
    @Transactional
    fun save() {
        val member = Member(
            name = "Taewon Lee",
            loginId = "mapperTest",
            password = BCrypt.hashpw("1q2w3e4r", BCrypt.gensalt()),
            email = "test@mapperTest.com",
            role = MemberRole.MEMBER
        ).apply {
            memberMapper.save(this)
        }

        log.info("member={}", member)
    }

    @Test
    @Transactional
    fun findById() {
        val member = Member(
            name = "Taewon Lee",
            loginId = "mapperTest",
            password = BCrypt.hashpw("1q2w3e4r", BCrypt.gensalt()),
            email = "test@mapperTest.com",
            role = MemberRole.MEMBER
        ).apply {
            memberMapper.save(this)
        }

        val findById = memberMapper.findById(member.id!!)
        log.info("findById={}", findById)
        Assertions.assertThat(findById).isEqualTo(member)
    }

    @Test
    @Transactional
    fun findByEmail() {
        val member = Member(
            name = "Taewon Lee",
            loginId = "mapperTest",
            password = BCrypt.hashpw("1q2w3e4r", BCrypt.gensalt()),
            email = "test@mapperTest.com",
            role = MemberRole.MEMBER
        ).apply {
            memberMapper.save(this)
        }

        memberMapper.findByEmail("test@mapperTest.com")
            .run {
                log.info("findByEmail={}", this)
                Assertions.assertThat(this).isEqualTo(member)
            }
    }

    @Test
    @Transactional
    fun findByLoginId() {
        val member = Member(
            name = "Taewon Lee",
            loginId = "mapperTest",
            password = BCrypt.hashpw("1q2w3e4r", BCrypt.gensalt()),
            email = "test@mapperTest.com",
            role = MemberRole.MEMBER
        ).apply {
            memberMapper.save(this)
        }

        memberMapper.findByLoginId("mapperTest")
            .run {
                log.info("findByLoginId={}", this)
                Assertions.assertThat(this).isEqualTo(member)
            }
    }

    companion object {
        val log = LoggerFactory.getLogger(MemberMapperTest.toString())
    }
}