package com.bronka.server.repository

class ClientRepository<Client, String>: Repository<Client, String> {
    override fun selectById(id: String): Client {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun createWithId(obj: Client): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateById(id: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dropById(id: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}