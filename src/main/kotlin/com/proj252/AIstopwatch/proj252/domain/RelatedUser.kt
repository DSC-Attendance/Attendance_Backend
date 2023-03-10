package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class RelatedUser(
    @Id
    val userUid: Long,

    @Column(name = "role")
    val role: Int,
    @Column(name = "recent_attend")
    val recentAttend: Int,
    @Column(name = "next_attend")
    val nextAttend: Int,

    @ManyToOne @JoinColumn(name = "group_id")
    val group: Group

)