package com.bronka.server.entity

import org.apache.log4j.Logger

data class Restaurant(val id: String, var name:String,
                 var description: String, var location: String,
                 var cousine: String,  var rate: Int, var categories:List<Category>) {
    init {
        val LOG = Logger.getLogger(Restaurant::class.java)
        LOG.info("Created new Restaurant name = $name with id = $id")
    }

}