package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*
import java.sql.Date


data class Event(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "next_schedule")
    val nextSchedule: Date,
    @Column(name = "name")
    val name: String,
    @Column(name = "rule")
    val rule: Int,
    @Column(name = "code")
    val code: String,

    @ManyToOne @JoinColumn(name = "group_id")
    val group: Group,
)
