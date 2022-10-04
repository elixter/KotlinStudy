package com.elixter.persistence.member

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : R2dbcRepository<MemberEntity, Long>