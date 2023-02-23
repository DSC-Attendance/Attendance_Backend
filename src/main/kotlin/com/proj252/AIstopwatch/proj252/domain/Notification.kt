package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

data class Notification(
    @Id @OneToOne @JoinColumn(name = "group_id")
    val group: Group,

    @Column(name = "message")
    val message: String
)