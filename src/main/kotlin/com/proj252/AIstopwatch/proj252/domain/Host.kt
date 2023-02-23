package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*

data class Host (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: CustomUser,
    @ManyToOne
    @JoinColumn(name = "group_id")
    val group: Group,
)