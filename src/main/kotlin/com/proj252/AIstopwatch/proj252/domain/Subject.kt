package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*
import lombok.NonNull

data class Subject(
    @Id @NonNull
    val name: String,

    @Column(name = "reps")
    val reps: Int,
    @Column(name = "period")
    val period: Int?,

    @ManyToOne @JoinColumn(name = "group_id")
    private val group: Group,
    @OneToMany(mappedBy = "event", cascade = [CascadeType.ALL])
    var events: MutableList<Event>,
)