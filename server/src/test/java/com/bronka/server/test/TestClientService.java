package com.bronka.server.test;

import com.bronka.server.data.Client;
import com.bronka.server.test.repository.ClientRepository;
import com.bronka.server.repository.Repository;
import org.junit.Before;
import org.junit.Test;

public class TestClientService {

    private Repository<Client, String> repo;


    @Before
    public void createRepoAndClients(){
        repo = new ClientRepository();
    }

    @Test
    public void createVisit(){


    }
}
