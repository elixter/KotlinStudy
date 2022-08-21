package com.elixter.kopring.mapper.member

import com.elixter.kopring.domain.member.Member
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface MemberMapper {

    fun save(member: Member)

    fun findById(@Param("id") id: Long): Member?
}