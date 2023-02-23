package com.proj252.AIstopwatch.proj252.u_repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SdjMemberRepo: JpaRepository<Member, String> {
    @Override
    fun existsMemberById(accountId: String): Boolean
    @Override
    fun findMemberById(accountId: String): Optional<Member>
    @Override
    fun deleteMemberByUser_UserId(userId: Long)
}