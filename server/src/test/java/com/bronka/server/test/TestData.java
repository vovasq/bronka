package com.bronka.server.test;

import com.bronka.server.data.Client;
import com.bronka.server.data.Restaurant;
import com.bronka.server.data.Visit;
import com.bronka.server.data.VisitState;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TestData {

    private final Logger LOG = Logger.getLogger(TestData.class);

    @Test
    public void createEnities() {
        Restaurant restaurant = new Restaurant("restId1", "Blevotnya",
                "very awesome resto", "de to tam" , "hohlyatskay", 0);

        Assert.assertEquals("Blevotnya",restaurant.getName());

        Client client = new Client("clientId", "vovasq",
                "password", "Vovas", "+123456789", "vovas@vovas.ru");
        Assert.assertTrue(client.getId().equals("clientId"));

        Visit visit = new Visit("visitId", 123, VisitState.NEW, 456, 3,
                "Restoraunt", "client Name", "client id");





        LOG.info(visit);


    }

    @Test
    public void clientCreationTest() {

    }

}
