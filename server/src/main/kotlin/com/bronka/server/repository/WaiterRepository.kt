package com.bronka.server.repository

import com.bronka.server.users.Waiter

class WaiterRepository: Repository<Waiter, String>{
    override fun selectById(id: String): Waiter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createWithId(obj: Waiter): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateById(id: String, represent:Waiter): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dropById(id: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}