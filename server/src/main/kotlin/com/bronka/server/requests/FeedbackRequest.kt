package com.bronka.server.requests

data class FeedbackRequest(val userId: Long,
                           val visitId: Long,
                           val text: String,
                           val rate: String){
    override fun toString(): String {
        return "FeedbackRequest(userId=$userId, visitId=$visitId, text='$text', rate='$rate')"
    }
}