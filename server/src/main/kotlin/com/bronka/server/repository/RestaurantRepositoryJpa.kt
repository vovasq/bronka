package com.bronka.server.repository

import com.bronka.server.entity.Restaurant
import com.bronka.server.entity.Visit
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepositoryJpa : JpaRepository<Restaurant, Long>{
    fun findByName(name:String): List<Restaurant>

}