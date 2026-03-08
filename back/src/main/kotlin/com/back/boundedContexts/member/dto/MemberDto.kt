package com.back.boundedContexts.member.dto

import com.back.boundedContexts.member.domain.shared.Member
import java.time.Instant

data class MemberDto(
    val id: Int,
    val createdAt: Instant,
    val modifiedAt: Instant,
    val isAdmin: Boolean,
    val name: String,
    val profileImageUrl: String,
) {
    constructor(member: Member) : this(
        id = member.id,
        createdAt = member.createdAt,
        modifiedAt = member.modifiedAt,
        isAdmin = member.isAdmin,
        name = member.name,
        profileImageUrl = member.redirectToProfileImgUrlOrDefault,
    )
}
