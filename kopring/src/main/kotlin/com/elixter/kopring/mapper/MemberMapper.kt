package com.elixter.kopring.mapper

import com.elixter.kopring.domain.Member
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface MemberMapper {

    fun save(member: Member)

    fun findById(@Param("id") id: Long): Member?
}