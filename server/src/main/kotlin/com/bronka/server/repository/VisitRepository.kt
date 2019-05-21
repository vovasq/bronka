package com.bronka.server.repository

import com.bronka.server.data.Visit
import com.bronka.server.data.VisitState
import com.bronka.server.utils.getCurrentTime
import com.bronka.server.utils.randState
import org.apache.log4j.Logger

class VisitRepository : Repository<Visit, String> {

    private var visits: HashMap<String, Visit> = HashMap<String, Visit>()
    val logger = Logger.getLogger(VisitRepository::class.java)

    override fun selectById(id: String): Visit {
        if (visits.containsKey(id)) {
            return visits.get(id)!!
        } else {
            val visit = Visit(id,
                    getCurrentTime(),
                    randState(),
                    getCurrentTime(),
                    2,
                    "restaurant $id",
                    "Vobas_ $id",
                    "clinet_$id")
            visits.put(id, visit)
            return visit
        }
    }

//    TODO exception for empty visits or something database

    fun createWithId(id: String): Boolean {
        val visit = Visit(id,
                getCurrentTime(),
                randState(),
                getCurrentTime(),
                2,
                "restaurant $id",
                "Vobas_ $id",
                "clinet_$id")
        visits.put(id, visit)
        return true;
    }

    fun updateVisitState(id: String, state: VisitState){
        selectById(id).state=state
    }

    override fun createWithId(obj: Visit): Boolean {
        val visit = Visit(obj.id,
                getCurrentTime(),
                randState(),
                getCurrentTime(),
                2,
                "restaurant $obj.id",
                "Vobas_ $obj.id",
                "clinet_$obj.id")
        visits.put(obj.id, visit)
        return true;
    }

    override fun updateById(id: String, v: Visit): Boolean {
        if (visits.containsKey(id)) {
            visits.put(id,v)
        } else {
            logger.warn("No visit wit id $id")
            createWithId(v)
        }
        return true;
    }

    override fun dropById(id: String): Boolean {
        return visits.remove(id) != null;
    }

}