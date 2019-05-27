package com.bronka.server.repository

import com.bronka.server.data.Feedback
import org.apache.log4j.Logger

class FeedbackRepository : Repository<Feedback, String> {

    private var feedbacks: HashMap<String, Feedback> = HashMap<String, Feedback>()
    val logger = Logger.getLogger(Feedback::class.java)

    override fun selectById(id: String): Feedback {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createWithId(obj: Feedback): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateById(id: String, v: Feedback): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dropById(id: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}