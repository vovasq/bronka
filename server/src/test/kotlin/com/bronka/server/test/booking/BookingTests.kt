package com.bronka.server.test

import com.bronka.server.users.*
import com.bronka.server.entity.Comment
import com.bronka.server.entity.Visit
import com.bronka.server.entity.VisitState
import com.bronka.server.repository.RestaurantRepository
import com.bronka.server.repository.VisitRepository
import com.bronka.server.test.workflow.BookingTestsConfig
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

    private fun createVisit(restId: String): Visit {
        restRepo.createWithId(restId)
        client.chooseRestAndRequest(restId, "pohi", getCurrentTime(), 5)
        return visitRepository.selectById(client.id + restId)
    }

    @Test
    fun createClientTest() {
        assertEquals(client.phone, "+29292992")
    }

    @Test
    fun createVisitTest() {
        val restId = "restid_1"
        val visit = createVisit(restId)
        assertEquals(visit.state, VisitState.NEW)
    }

    @Test
    fun createVisitAndDeclineTest() {
        val restId = "restid_1"
        val visit = createVisit(restId)
        waiter.declineVisit(visit.id, Comment("com",
                13232, "fdsmkldsfnlkdsmfklmdslkmf", "dnjkdsa", "ndjfnsdfsdk"))
        assertEquals(visit.state, VisitState.DECLINED)
        // after declined action it should not be this visit in repo
        assertEquals(visitRepository.selectById(visit.id).state, VisitState.NEW)
    }

    @Test
    fun createVisitAndApproveTest() {
        val restId = "restid_1"
        val visit = createVisit(restId)
        assertEquals(visit.state, VisitState.NEW)
//        createVisit()
    }


}
