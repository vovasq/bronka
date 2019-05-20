package com.bronka.server.service

import com.bronka.server.data.*
import com.bronka.server.repository.Repository
import org.apache.log4j.Logger

class ClientService (private var repository: Repository<Client, String>){

    private val LOG = Logger.getLogger(UserAccount::class.java)

    fun createVisit(clientId:String, visit: Visit):Boolean{
        LOG.debug("+createVisit $visit for user $clientId")

        LOG.debug("-createVisit $visit for user $clientId")
        return true;
    }

    fun closeVisit(clientId:String, visitId: String):Boolean{
        LOG.debug("+closeVisit $visitId for user $clientId")

        LOG.debug("-closeVisit $visitId for user $clientId")
        return true;
    }

    fun modifyVisit(clientId:String, prevVisitId: String, newVisit: Visit): Boolean{
        LOG.debug("+modifyVisit $prevVisitId for user $clientId")

        LOG.debug("-modifyVisit $prevVisitId for user $clientId")
        return true;
    }

    fun leaveFeedback(clientId:String, feedback: Feedback): Boolean{
        LOG.debug("+leaveFeedback $feedback for user $clientId")

        LOG.debug("-leaveFeedback $feedback for user $clientId")
        return true;
    }

    fun getStateOfVisit(clientId: String, visitId:Visit): Visit{
        LOG.debug("+getStateOfVisit $visitId for user $clientId")

        LOG.debug("-getStateOfVisit $visitId for user $clientId")
        return Visit("","", VisitState.NEW, "",
                3, "rere", "dsdas", "sasd");
    }



}