package com.proj252.AIstopwatch.proj252.domain

import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

@Entity
data class CustomUser(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @OneToMany(mappedBy = "host", cascade = [CascadeType.ALL])
    var hosts: MutableList<Host>,
    @OneToMany(mappedBy = "mate", cascade = [CascadeType.ALL])
    var mates: MutableList<Mate>,



){
    fun toUser(): User {
        return User(
            name,
            "",
            mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
        )
    }
}