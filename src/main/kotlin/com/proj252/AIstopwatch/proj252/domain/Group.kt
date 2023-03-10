package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*

data class Group(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,
    @Column(name = "notification")
    val notification: String,

    @OneToMany(mappedBy = "event", cascade = [CascadeType.ALL])
    var events: MutableList<Event>,
    @OneToMany(mappedBy = "related_user", cascade = [CascadeType.ALL])
    var relatedUsers: MutableList<RelatedUser>,
)