//package com.bronka.server.test.repository
//
//import com.bronka.server.BronkaApplication
//import com.bronka.server.entity.*
//import com.bronka.server.repository.*
//import com.bronka.server.test.business.BookingTestsConfig
//import com.bronka.server.users.Client
//import com.bronka.server.utils.getCurrentTime
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.beans.factory.annotation.Qualifier
//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.context.annotation.ComponentScan
//import org.springframework.context.annotation.FilterType
//import org.springframework.context.annotation.Primary
//import org.springframework.test.context.junit4.SpringRunner
//import kotlin.test.assertEquals
//import kotlin.test.assertTrue
//
//@RunWith(SpringRunner::class)
//@SpringBootTest(classes = [BronkaApplication::class])
//@ComponentScan("com.brinka.server.repository")
//open class RepositoriesTest {
//
//    @Qualifier("userRepositoryJpa")
//    @Autowired
//    private lateinit var userRepo: UserRepositoryJpa
//
//    @Qualifier("restaurantRepositoryJpa")
//    @Autowired
//    private lateinit var restaurantRepo: RestaurantRepositoryJpa
//
//    @Qualifier("visitRepositoryJpa")
//    @Autowired
//    private lateinit var visitRepo: VisitRepositoryJpa
//
//    @Qualifier("feedbackRepositoryJpa")
//    @Autowired
//    private lateinit var feedBackRepo: FeedbackRepositoryJpa
//
//    @Qualifier("commentRepository")
//    @Autowired
//    private lateinit var commentRepo: CommentRepository
//
//    private lateinit var restaurant: Restaurant;
//    private lateinit var restaurant1: Restaurant;
//    private lateinit var client: Client;
//    private lateinit var comment:Comment
//
//    private var clientName = "Vovas"
//    private val restaurantName = "RESTIK"
//    private val text = "perfect visit jdjksfndsk"
//    private val email = "vovvas@amil.ru"
//
//
//    @Before
//    fun initTestEntities() {
//        restaurant = Restaurant(
//                null,
//                restaurantName,
//                "mega cool description ",
//                "Saint-P",
//                "Ukranian",
//                5, 11)
//
//        restaurant1 = Restaurant(
//                null,
//                restaurantName,
//                "mega cool description ",
//                "Saint-P",
//                "Ukranian",
//                5, 11)
//
////                listOf(Category("GOOD FOOD", "really goood"), Category("Street Food", "street food")))
//        client = Client(UserAccount(null, "client", clientName, "vovasName",
//                "password", "+75748574385", email))
//
//
//    }
//
//    @Test
//    fun userRepoTest() {
//        userRepo.save(client.userAccount)
//        assertEquals(userRepo.findByName(clientName).size, 1)
//        assertTrue(userRepo.findByEmail(email).isNotEmpty())
//        client = Client(userRepo.findByName(clientName).get(0))
//    }
//
//    @Test
//    fun restaurantRepoTest() {
//        restaurantRepo.save(restaurant)
//        restaurantRepo.save(restaurant1)
////        restaurantRepo.save(restaurant)
////        restaurantRepo.save(restaurant)
//        assertTrue(restaurantRepo.findByName(restaurantName).isNotEmpty())
//        assertTrue(restaurantRepo.findAll().isNotEmpty())
//    }
//
//    @Test
//    fun visitRepoTest() {
//        val client = Client(userRepo.findByName(clientName).get(0))
//        val time = "time"
//        val restaurantName = "restik"
//        for (i in 0..10) {
//            visitRepo.save(Visit(null, time, VisitState.NEW, "boooking time", 2,
//                    restaurantName + "$i", clientName, client.userAccount.id!!))
//        }
//        assertTrue(visitRepo.findByClientId(client.userAccount.id!!).isNotEmpty())
//        var newVisit = visitRepo.findByClientId(client.userAccount.id!!).get(0)
//        newVisit.state=VisitState.APPROVED
//        visitRepo.save(newVisit)
//        println("Kek")
//        assertTrue(visitRepo.findByRestaurant(restaurantName + "1").isNotEmpty())
//        assertTrue(visitRepo.findByClientName(clientName).isNotEmpty())
//    }
//
//    @Test
//    fun commentRepoTest() {
//        val id:Long = 111
//        comment = Comment(null, getCurrentTime(),text,
//                id,client.userAccount.name, null)
//        commentRepo.save(comment)
//        assertEquals(commentRepo.findByAuthorId(id).size, 1)
//        assertEquals(commentRepo.findByAuthorName(client.userAccount.name).get(0).authorName, client.userAccount.name)
//        assertTrue(commentRepo.findByAuthorName(client.userAccount.name).isNotEmpty())
//        println(client.userAccount.name)
//    }
//
//    @Test
//    fun FeedBackRepoTest() {
//        println(client.userAccount.name);
//        comment = Comment(null, getCurrentTime(),text, client.userAccount.id,client.userAccount.name, null)
//        var feedback =Feedback(null,comment,Rate.FIVE_STARS,"restik", 123,"Vovas")
//        feedBackRepo.save(feedback)
//        assertTrue(feedBackRepo.findByClientName(client.userAccount.name).isNotEmpty())
//        assertTrue(commentRepo.findByAuthorName(client.userAccount.name).isNotEmpty())
//    }
//
//
//}