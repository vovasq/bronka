package com.bronka.server.test.booking

import com.bronka.server.data.Client
import com.bronka.server.data.Comment
import com.bronka.server.data.VisitState
import com.bronka.server.data.Waiter
import com.bronka.server.repository.RestaurantRepository
import com.bronka.server.repository.VisitRepository
import com.bronka.server.utils.getCurrentTime
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import kotlin.test.assertEquals


@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [BookingTestsConfig::class])
class BookingTests {

    @Autowired
    private lateinit var client: Client

    @Autowired
    private lateinit var waiter: Waiter

    @Autowired
    private lateinit var restRepo: RestaurantRepository

    @Autowired
    private lateinit var visitRepository: VisitRepository

    @Test
    fun createClient() {
        assertEquals(client.phone, "+29292992")
    }

    @Test
    fun createVisitAndDeclineTest(){
        val restId = "restid_1"
        restRepo.createWithId(restId)
        client.chooseRestAndRequest(restId,"pohi", getCurrentTime(),5)
        val visit = visitRepository.selectById(client.id+restId)
        assertEquals(visit.state, VisitState.NEW)
        waiter.declineVisit(client.id+restId, Comment("com",
                13232, "fdsmkldsfnlkdsmfklmdslkmf","dnjkdsa","ndjfnsdfsdk"))
        assertEquals(visit.state, VisitState.DECLINED)
    }

}
