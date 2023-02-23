package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*
import java.sql.Date


data class Event(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "time")
    val time: Date,

    @ManyToOne @JoinColumn(name = "subject_name")
    val subject: Subject,
    @OneToOne(mappedBy = "attendance", cascade = [CascadeType.ALL])
    private val attendance: Attendance,
)
