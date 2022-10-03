package com.elixter.persistence.member

import com.elixter.persistence.TestConfig
import com.elixter.persistence.member.MemberRole.MEMBER
import com.elixter.persistence.utils.TransactionHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.context.annotation.Import

@DataR2dbcTest
@Import(TestConfig::class)
class MemberRepositoryTest @Autowired constructor(
    private var repository: MemberRepository,
) {

    private var txHelper: TransactionHelper,
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
        val actual = txHelper.withRollback(repository.save(given)).block()

        // then
        Assertions.assertEquals(given.copy(id = actual?.id), actual)
    }
}