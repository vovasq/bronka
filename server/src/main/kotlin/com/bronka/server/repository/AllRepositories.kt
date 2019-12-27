package com.bronka.server.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class AllRepositories {
    @Autowired
    lateinit var restsRepo: RestaurantRepositoryJpa
    @Autowired
    lateinit var visitsRepo: VisitRepositoryJpa

    @Qualifier("feedbackRepositoryJpa")
    @Autowired
    lateinit var feedbackRepo: FeedbackRepositoryJpa

    @Autowired
    lateinit var commentRepository: CommentRepository

}