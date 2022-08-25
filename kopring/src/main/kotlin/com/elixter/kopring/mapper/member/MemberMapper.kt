package com.elixter.kopring.mapper.member

import com.elixter.kopring.domain.member.Member
import com.elixter.kopring.dto.member.UpdateMemberParam
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface MemberMapper {

    //save
    fun save(member: Member)

    // find
    fun findById(@Param("id") id: Long): Member?
    fun findByEmail(@Param("email") email: String): Member?
    fun findByLoginId(@Param("loginId") loginId: String): Member?

    // findAll

    // update
    fun update(@Param("id") id: Long, @Param("updateParam") updateParam: UpdateMemberParam)

    // delete
}