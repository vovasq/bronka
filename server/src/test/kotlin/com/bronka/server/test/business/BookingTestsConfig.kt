//package com.bronka.server.test.business
//
//import com.bronka.server.entity.UserAccount
//import com.bronka.server.test.business.mock.FeedbackRepoMock
//import com.bronka.server.test.business.mock.RestaurantRepoMock
//import com.bronka.server.test.business.mock.VisitRepoMock
//import com.bronka.server.users.Client
//import com.bronka.server.users.Waiter
//import org.junit.runner.RunWith
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Scope
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
//
//@RunWith(SpringJUnit4ClassRunner::class)
//@Configuration
//open class BookingTestsConfig {
//
//    private val numOfRests = 5
//    private val numOfClients = 5
//    private val clientId: Long = 1
//    private val clientName = "Client Clientovich"
//    private val waiterId: Long = 2
//    private val waiterName = "Waiter Kekovich"
//    private val restaurant= "resikk"
//
//
//    @Bean
//    open fun clientMock(): Client {
//        return Client(UserAccount(clientId, "Client", clientName,
//                clientName, "password", "+29292992", "dsabdjsa@vovas.com"))
//    }
//
//    @Bean
//    open fun waiterMock(): Waiter {
//        return Waiter(UserAccount(waiterId, "Waiter", waiterName,
//                waiterName, "password", "+29292992", "asdsa@rest.com"), restaurant)
//    }
//
//    @Bean
//    @Scope("singleton")
//    open fun restaurantRepositoryMock(): RestaurantRepoMock {
//        return RestaurantRepoMock()
//    }
//
//    @Bean
//    @Scope("singleton")
//    open fun visitRepositoryMock(): VisitRepoMock {
//        return VisitRepoMock()
//    }
//
//    @Bean
//    @Scope("singleton")
//    open fun FeedbackRepositoryMock(): FeedbackRepoMock {
//        return FeedbackRepoMock ()
//    }
//}