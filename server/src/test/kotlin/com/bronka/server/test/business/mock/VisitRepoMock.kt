package com.bronka.server.test.business.mock

import com.bronka.server.entity.Visit
import com.bronka.server.repository.VisitRepositoryJpa
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
class VisitRepoMock: VisitRepositoryJpa {
    private val visits: HashMap<String, Visit> = HashMap<String, Visit>()
    private val idToNameMap: HashMap<Long, String> = HashMap<Long, String>()
    private var idCounter:Long = 0

    override fun findAll(): MutableList<Visit> {
        var result: MutableList<Visit> = mutableListOf<Visit>();
        result.addAll(visits.values)
        return result
    }

    override fun deleteById(p0: Long) {
        visits.remove(idToNameMap[p0])
        idToNameMap.remove(p0)
    }

    override fun <S : Visit?> save(p0: S): S {
        var id = ++idCounter
        if (p0 != null) {
            p0.id = id
            visits.put(p0.clientName,p0)
            idToNameMap.put(id, p0.clientName)
        }
        return p0
    }

    override fun count(): Long {
        return visits.size.toLong()
    }

    override fun findByClientName(name: String): List<Visit> {
        var result = ArrayList<Visit>()
        result.add(visits[name]!!)
        return result
    }

    override fun getOne(p0: Long): Visit {
        return visits[idToNameMap[p0]]!!
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByClientId(clientId: Long): List<Visit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByRestaurant(restaurant: String): List<Visit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteInBatch(p0: MutableIterable<Visit>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(p0: Sort): MutableList<Visit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> findAll(p0: Example<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> findAll(p0: Example<S>, p1: Sort): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(p0: Pageable): Page<Visit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> findAll(p0: Example<S>, p1: Pageable): Page<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllInBatch() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> saveAndFlush(p0: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun flush() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(p0: MutableIterable<Visit>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> saveAll(p0: MutableIterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> findOne(p0: Example<S>): Optional<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> count(p0: Example<S>): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(p0: MutableIterable<Long>): MutableList<Visit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(p0: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Visit?> exists(p0: Example<S>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(p0: Long): Optional<Visit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(p0: Visit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}