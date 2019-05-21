package com.bronka.server.repository

import com.bronka.server.data.Category
import com.bronka.server.data.Restaurant
import com.bronka.server.utils.getCurrentTime
import com.bronka.server.utils.randState
import org.apache.log4j.Logger

class RestaurantRepository : Repository<Restaurant, String> {

    private var rests: HashMap<String, Restaurant> = HashMap<String, Restaurant>()
    val logger = Logger.getLogger(RestaurantRepository::class.java)

    //    TODO exception for empty rests or something database


    override fun selectById(id: String): Restaurant {
        if (rests.containsKey(id)) {
            return rests.get(id)!!
        } else {
            val rest = mockedRest(id)
            rests.put(id,rest)
            return rest
        }
    }

    private fun mockedRest(id: String): Restaurant = Restaurant(
            id,
            "restname_$id",
            "mega cool description $id",
            "Saint-P",
            "Ukranian",
            5,
            listOf(Category("GOOD FOOD", "really goood"), Category("Street Food", "street food")))


    fun createWithId(id: String): Boolean {
        val rest = mockedRest(id)
        rests.put(id, rest)
        return true;
    }

    override fun createWithId(obj: Restaurant): Boolean {
        val restaurant = mockedRest(obj.id)
        rests.put(obj.id, restaurant)
        return true;
    }

    override fun updateById(id: String, v: Restaurant): Boolean {
        if (rests.containsKey(id)) {
            rests.put(id,v)
        } else {
            logger.warn("No rest wit id $id")
            createWithId(v)
        }
        return true;
    }

    override fun dropById(id: String): Boolean {
        return rests.remove(id) != null;
    }

}