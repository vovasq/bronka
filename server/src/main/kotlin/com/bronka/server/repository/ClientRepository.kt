package com.bronka.server.repository

import com.bronka.server.users.Client

class ClientRepository: Repository<Client, String> {
    val clients: HashMap<String,Client> = HashMap<String,Client>()
    override fun selectById(id: String): Client {
        return Client(id, "login_$id", "pass",
                "Name_$id", "+29292992", "$id@vovas.com")
    }

    override fun createWithId(obj: Client): Boolean {
        return true;
    }

    override fun updateById(id: String, client: Client): Boolean {
        return true;
    }

    override fun dropById(id: String): Boolean {
        return true;
    }
}