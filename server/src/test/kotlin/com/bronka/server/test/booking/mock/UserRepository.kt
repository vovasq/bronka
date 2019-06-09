package com.bronka.server.test.booking.mock

import com.bronka.server.entity.UserAccount
import com.bronka.server.repository.UserRepositoryJpa
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

abstract class UserRepository : UserRepositoryJpa {
    private val clients: HashMap<String, UserAccount> = HashMap<String, UserAccount>()
    private val idToNameMap: HashMap<Long, String> = HashMap<Long, String>()
    private var idCounter:Long = 0

    override fun deleteInBatch(p0: MutableIterable<UserAccount>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): MutableList<UserAccount> {
        var result: MutableList<UserAccount> = mutableListOf<UserAccount>();
        result.addAll(clients.values)
        return result
    }

    override fun deleteById(p0: Long) {
        clients.remove(idToNameMap[p0])
    }

    override fun <S : UserAccount?> save(p0: S): S {
        var id = ++idCounter
        if (p0 != null) {
            p0.id = id
            clients.put(p0.name,p0)
            idToNameMap.put(id, p0.name)
        }
        return p0
    }

    override fun count(): Long {
        return clients.size.toLong()
    }

    override fun findAll(p0: Sort): MutableList<UserAccount> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByName(name: String): List<UserAccount> {
        var result = ArrayList<UserAccount>()
        result.add(clients[name]!!)
        return result
    }

    override fun <S : UserAccount?> findAll(p0: Example<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : UserAccount?> findAll(p0: Example<S>, p1: Sort): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(p0: Pageable): Page<UserAccount> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : UserAccount?> findAll(p0: Example<S>, p1: Pageable): Page<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllInBatch() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : UserAccount?> saveAndFlush(p0: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun flush() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(p0: MutableIterable<UserAccount>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : UserAccount?> saveAll(p0: MutableIterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : UserAccount?> findOne(p0: Example<S>): Optional<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : UserAccount?> count(p0: Example<S>): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOne(p0: Long): UserAccount {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(p0: MutableIterable<Long>): MutableList<UserAccount> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(p0: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : UserAccount?> exists(p0: Example<S>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(p0: Long): Optional<UserAccount> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(p0: UserAccount) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


