package com.elixter.kopring.mapper

import com.elixter.kopring.domain.Member
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface MemberMapper {

    fun save(member: Member)

    fun findById(id: Long): Member?
}