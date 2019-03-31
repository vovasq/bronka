package com.bronka.server.repository

interface Repository<U,T>{

    fun selectById(id: T): U

    fun createWithId(obj: U): Boolean

    fun updateById(id: T): Boolean

    fun dropById(id: T): Boolean

}