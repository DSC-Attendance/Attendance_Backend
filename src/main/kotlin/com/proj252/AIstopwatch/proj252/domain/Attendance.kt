package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne

data class Attendance(
    @Id @OneToOne @JoinColumn(name = "event_id")
    val event: Event,

    @Column(name = "attend")
    val attend: Int,

    @ManyToOne @JoinColumn(name = "mate_id")
    val mate: Mate,
)