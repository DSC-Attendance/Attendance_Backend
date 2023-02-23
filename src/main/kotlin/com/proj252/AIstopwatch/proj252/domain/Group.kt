package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*

data class Group(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @OneToMany(mappedBy = "host", cascade = [CascadeType.ALL])
    var hosts: MutableList<Host>,
    @OneToMany(mappedBy = "mate", cascade = [CascadeType.ALL])
    var mates: MutableList<Mate>,
    @OneToMany(mappedBy = "subject", cascade = [CascadeType.ALL])
    var subjects: MutableList<Subject>,
    @OneToOne(mappedBy = "notification", cascade = [CascadeType.ALL])
    private val notification: Notification,
)