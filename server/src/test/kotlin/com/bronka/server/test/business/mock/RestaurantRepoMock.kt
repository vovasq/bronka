package com.bronka.server.test.business.mock

import com.bronka.server.entity.Restaurant
import com.bronka.server.repository.RestaurantRepositoryJpa
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.NoRepositoryBean
import java.util.*
import kotlin.collections.HashMap

@NoRepositoryBean
class RestaurantRepoMock : RestaurantRepositoryJpa {
    private var rests: HashMap<String, Restaurant> = HashMap()
    private val idToNameMap: HashMap<Long, String> = HashMap<Long, String>()
    private var idCounter: Long = 0

    override fun findAll(): MutableList<Restaurant> {
        var result: MutableList<Restaurant> = mutableListOf<Restaurant>();
        result.addAll(rests.values)
        return result
    }

    override fun deleteById(p0: Long) {
        rests.remove(idToNameMap[p0])
        idToNameMap.remove(p0)
    }

    override fun findByWaiter(id: Long): Restaurant {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> save(p0: S): S {
        var id = ++idCounter
        if (p0 != null) {
            p0.id = id
            rests.put(p0.name, p0)
            idToNameMap.put(id, p0.name)
        }
        return p0
    }

    override fun count(): Long {
        return rests.size.toLong()
    }

    override fun findByName(name: String): List<Restaurant> {
        var result = ArrayList<Restaurant>()
        result.add(rests[name]!!)
        return result
    }

    override fun deleteInBatch(p0: MutableIterable<Restaurant>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun findAll(p0: Sort): MutableList<Restaurant> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> findAll(p0: Example<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> findAll(p0: Example<S>, p1: Sort): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(p0: Pageable): Page<Restaurant> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> findAll(p0: Example<S>, p1: Pageable): Page<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllInBatch() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> saveAndFlush(p0: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun flush() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(p0: MutableIterable<Restaurant>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> saveAll(p0: MutableIterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> findOne(p0: Example<S>): Optional<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> count(p0: Example<S>): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOne(p0: Long): Restaurant {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(p0: MutableIterable<Long>): MutableList<Restaurant> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(p0: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Restaurant?> exists(p0: Example<S>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(p0: Long): Optional<Restaurant> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(p0: Restaurant) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}