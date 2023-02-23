package com.proj252.AIstopwatch.proj252.u_repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SdjUserRepo: JpaRepository<CustomUser,Long> {
    @Override
    override fun findById(id: Long): Optional<CustomUser>

}