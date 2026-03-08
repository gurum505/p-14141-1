package com.back.boundedContexts.member.`in`

import com.back.boundedContexts.member.app.MemberFacade
import com.back.boundedContexts.member.dto.MemberDto
import com.back.global.rsData.RsData
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member/api/v1/members")
class ApiV1MemberController(
    private val memberFacade: MemberFacade,
) {
    @GetMapping("/randomSecureTip")
    fun randomSecureTip() =
        "비밀번호는 영문, 숫자, 특수문자를 조합하여 8자 이상으로 설정하세요."

    data class MemberJoinRequest(
        @field:NotBlank
        @field:Size(min = 2, max = 30)
        val username: String,
        @field:NotBlank
        @field:Size(min = 2, max = 30)
        val password: String,
        @field:NotBlank
        @field:Size(min = 2, max = 30)
        val nickname: String,
    )

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    fun join(
        @RequestBody @Valid reqBody: MemberJoinRequest,
    ): RsData<MemberDto> {
        val member = memberFacade.join(
            reqBody.username,
            reqBody.password,
            reqBody.nickname,
        )

        return RsData(
            "201-1",
            "${member.nickname}님 환영합니다. 회원가입이 완료되었습니다.",
            MemberDto(member),
        )
    }
}
