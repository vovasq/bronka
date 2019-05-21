package com.bronka.server.utils

import com.bronka.server.data.VisitState
import java.text.SimpleDateFormat
import java.util.*


fun randState(): VisitState {
    val states: List<VisitState> = listOf(VisitState.NEW,
            VisitState.IN_PROCESS,
            VisitState.DECLINED,
            VisitState.APPROVED,
            VisitState.END,
            VisitState.CLOSED)

    return states.shuffled().first()
}


fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    return sdf.format(Date())
}
