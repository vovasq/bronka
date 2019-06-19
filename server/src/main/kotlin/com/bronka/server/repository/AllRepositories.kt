package com.bronka.server.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AllRepositories {
    @Autowired
    lateinit var restsRepo: RestaurantRepositoryJpa
    @Autowired
    lateinit var visitsRepo: VisitRepositoryJpa
    @Autowired
    lateinit var feedbackRepo: FeedbackRepositoryJpa


}