package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uid: Long? = null,

    @Column(name = "name")
    val name: String,
    @Column(name = "id")
    val id: String,
    @Column(name = "password")
    val password: String,

    @OneToMany(mappedBy = "related_group", cascade = [CascadeType.ALL])
    var relatedGroups: MutableList<RelatedGroup>,
    )