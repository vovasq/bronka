package com.bronka.server.test.business

//import com.bronka.server.repository.VisitRepository
import com.bronka.server.entity.Restaurant
import com.bronka.server.entity.VisitState
import com.bronka.server.test.business.mock.RestaurantRepoMock
import com.bronka.server.test.business.mock.VisitRepoMock
import com.bronka.server.users.Client
import com.bronka.server.users.Waiter
import com.bronka.server.utils.getCurrentTime
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import kotlin.test.assertEquals
import kotlin.test.assertTrue


@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [BookingTestsConfig::class])
class BookingTests {

    @Qualifier("clientMock")
    @Autowired
    private lateinit var client: Client

    @Qualifier("waiterMock")
    @Autowired
    private lateinit var waiter: Waiter

    @Qualifier("restaurantRepositoryMock")
    @Autowired
    private lateinit var restRepo: RestaurantRepoMock

    @Qualifier("visitRepositoryMock")
    @Autowired
    private lateinit var visitRepo: VisitRepoMock

    private val clientId: Long = 1
    private val clientName = "Client Clientovich"
    private val waiterId: Long = 2
    private val waiterName = "Waiter Kekovich"
    private val restaurantName= "resikk"

    private lateinit var restaurant: Restaurant

    @Before
    fun createRestaurant(){
        restaurant = Restaurant(null,restaurantName, "MEGDNGKDSNK","dnsmjdksmka",
                "mksld",0,waiter.userAccount.id!!)

    }

    @Test
    fun createVisit(){
        restaurant = restRepo.save(restaurant)
        println("rest id = ${restaurant.id}")
        client.createVisit(restaurantName, getCurrentTime(),3)
        assertTrue(visitRepo.findByClientName(clientName).isNotEmpty())
        assertEquals(visitRepo.findByClientName(clientName).get(0).state, VisitState.NEW)
    }
}
