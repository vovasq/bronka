package com.bronka.server.data

import org.apache.log4j.Logger

data class Restaurant(val id: String, var name:String,
                 var description: String, var location: String,
                 var cousine: String,  var rate: Int) {

    init {
        val LOG = Logger.getLogger(Restaurant::class.java)
        LOG.info("Created new Restaurant name = $name with id = $id")
    }
}