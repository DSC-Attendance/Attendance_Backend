package com.proj252.AIstopwatch.proj252.repository

import com.proj252.AIstopwatch.proj252.domain.Event
import com.proj252.AIstopwatch.proj252.domain.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SdjGroupRepo: JpaRepository<Group, Long> {
    fun getByGroupId(groupId: Long): Group?

}