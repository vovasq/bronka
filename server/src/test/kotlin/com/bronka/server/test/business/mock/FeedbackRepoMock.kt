package com.bronka.server.test.business.mock

import com.bronka.server.entity.Feedback
import com.bronka.server.repository.FeedbackRepositoryJpa
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

//class FeedbackRepoMock : FeedbackRepositoryJpa {
//    private val feedbacks: HashMap<String, Feedback> = HashMap<String, Feedback>()
//    private val idToNameMap: HashMap<Long, String> = HashMap<Long, String>()
//    private var idCounter:Long = 0
//
//    override fun findAll(): MutableList<Feedback> {
//        var result: MutableList<Feedback> = mutableListOf<Feedback>();
//        result.addAll(feedbacks.values)
//        return result
//    }
//
//    override fun deleteById(p0: Long) {
//        feedbacks.remove(idToNameMap[p0])
//        idToNameMap.remove(p0)
//    }
//
//    override fun <S : Feedback?> save(p0: S): S {
//        var id = ++idCounter
//        if (p0 != null) {
//            p0.id = id
//            feedbacks.put(p0.clientName,p0)
//            idToNameMap.put(id, p0.clientName)
//        }
//        return p0
//    }
//
//    override fun count(): Long {
//        return feedbacks.size.toLong()
//    }
//
//    override fun findByClientName(name: String): List<Feedback> {
//        var result = ArrayList<Feedback>()
//        result.add(feedbacks[name]!!)
//        return result
//    }
//
//    override fun findByClientId(clientId: Long): List<Feedback> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun deleteInBatch(p0: MutableIterable<Feedback>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun findAll(p0: Sort): MutableList<Feedback> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> findAll(p0: Example<S>): MutableList<S> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> findAll(p0: Example<S>, p1: Sort): MutableList<S> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun findAll(p0: Pageable): Page<Feedback> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> findAll(p0: Example<S>, p1: Pageable): Page<S> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun deleteAllInBatch() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> saveAndFlush(p0: S): S {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun flush() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun deleteAll(p0: MutableIterable<Feedback>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun deleteAll() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> saveAll(p0: MutableIterable<S>): MutableList<S> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> findOne(p0: Example<S>): Optional<S> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> count(p0: Example<S>): Long {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getOne(p0: Long): Feedback {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun findAllById(p0: MutableIterable<Long>): MutableList<Feedback> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun existsById(p0: Long): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun <S : Feedback?> exists(p0: Example<S>): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun findById(p0: Long): Optional<Feedback> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun delete(p0: Feedback) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}