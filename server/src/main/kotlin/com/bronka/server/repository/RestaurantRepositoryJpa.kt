package com.bronka.server.repository

import com.bronka.server.entity.Restaurant
import com.bronka.server.entity.Visit
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

interface RestaurantRepositoryJpa : JpaRepository<Restaurant, Long>{
    fun findByName(name:String): List<Restaurant>
    fun findByWaiter(id:Long):Restaurant
}