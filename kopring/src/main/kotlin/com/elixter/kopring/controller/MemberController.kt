package com.elixter.kopring.controller

import com.elixter.kopring.aop.LogExecutionTime
import com.elixter.kopring.controller.dto.member.CreateMemberParam
import com.elixter.kopring.controller.dto.member.MemberResponse
import com.elixter.kopring.service.member.MemberService
import mu.KLogging
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/members")
class MemberController (
    val memberService: MemberService,
) {

    // TODO: Swagger UI 적용해보기 (Optional)
    @PostMapping
    @LogExecutionTime
    internal fun createUser(
        @RequestBody createMemberParam: CreateMemberParam
    ): ResponseEntity<MemberResponse> {
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    @LogExecutionTime
    internal fun getUser(
        @PathVariable id: Long,

    ): Mono<MemberResponse> {
        return memberService.getUser(id)
    }

    companion object : KLogging()
}