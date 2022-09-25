package com.elixter.persistence.member

import org.springframework.data.r2dbc.repository.R2dbcRepository

interface MemberRepository : R2dbcRepository<MemberEntity, Long> {
}