package com.bronka.server.repository.jpa

import com.bronka.server.entity.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepositoryJpa : JpaRepository<Restaurant, Long>{


}