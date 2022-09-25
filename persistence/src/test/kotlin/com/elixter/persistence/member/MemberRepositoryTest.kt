package com.elixter.persistence.member

import com.elixter.persistence.member.MemberRole.MEMBER
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.test.annotation.Rollback

@DataR2dbcTest
class MemberRepositoryTest @Autowired constructor(
    private var repository: MemberRepository
) {
    // TODO: Rollback 구현해야함

    @Test
    fun insert() {
        // given
        val given = MemberEntity(
            name = "test",
            loginId = "test",
            password = "test",
            email = "test",
            role = MEMBER,
        )

        // when
        val actual = repository.save(given)
            .block()

        // then
        Assertions.assertEquals(given.copy(id = actual?.id), actual)
    }
}