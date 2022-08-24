package com.elixter.kopring.mapper.member

import com.elixter.kopring.domain.member.Member
import com.elixter.kopring.domain.member.MemberRole
import com.elixter.kopring.domain.member.MemberRole.ADMIN
import com.elixter.kopring.dto.member.UpdateMemberDto
import mu.KLogging
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

        logger.info("member={}", member)
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
        logger.info("findById={}", findById)
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
                logger.info("findByEmail={}", this)
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
                logger.info("findByLoginId={}", this)
                Assertions.assertThat(this).isEqualTo(member)
            }
    }

    @Test
    @Transactional
    fun update() {
        val member = Member(
            name = "Taewon Lee",
            loginId = "mapperTest",
            password = BCrypt.hashpw("1q2w3e4r", BCrypt.gensalt()),
            email = "test@mapperTest.com",
            role = MemberRole.MEMBER
        ).apply {
            memberMapper.save(this)
        }

        logger.info("### update password ###")
        val updatePassword = member.copy(
            password = BCrypt.hashpw("newPW", BCrypt.gensalt())
        )
        logger.info("updatePassword={}", updatePassword)

        memberMapper.update(member.id!!, UpdateMemberDto(password = updatePassword.password))
        memberMapper.findById(member.id!!)
            .run {
                logger.info("newPassword={}", this)
                Assertions.assertThat(this).isEqualTo(updatePassword)
            }

        logger.info("### update member role ###")
        memberMapper.update(member.id!!, UpdateMemberDto(role = ADMIN))
        memberMapper.findById(member.id!!)
            .run {
                logger.info("newRole={}", this)
                Assertions.assertThat(this).isEqualTo(updatePassword.copy(role = ADMIN))
            }
    }

    companion object : KLogging()
}