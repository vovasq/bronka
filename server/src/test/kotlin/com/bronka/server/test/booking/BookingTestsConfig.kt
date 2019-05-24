package com.bronka.server.test.booking

import com.bronka.server.data.Client
import com.bronka.server.data.Waiter
import com.bronka.server.repository.RestaurantRepository
import com.bronka.server.repository.VisitRepository
import com.bronka.server.utils.getNextClientId
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope


@Configuration
open class BookingTestsConfig {

    private val numOfRests = 5
    private val numOfClients = 5

    @Bean
    open fun client(): Client {
        val id = getNextClientId()
        return Client(id, "login_$id", "pass",
                "Name_$id", "+29292992", "$id@vovas.com")
    }

    @Bean
    open fun waiter(): Waiter {
        val id = getNextClientId()
        return Waiter(id, "restalogin_$id", "pass",
                "Name_$id", "+29292992", "$id@rest.com")
    }

    @Bean
    @Scope("singleton")
    open fun restaurantRepository(): RestaurantRepository {
        return RestaurantRepository()
    }

    @Bean
    @Scope("singleton")
    open fun visitRepository(): VisitRepository {
        return VisitRepository()
    }

}