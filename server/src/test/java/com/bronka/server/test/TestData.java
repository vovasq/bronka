package com.bronka.server.test;

import com.bronka.server.data.Client;
import com.bronka.server.data.Restaurant;
import com.bronka.server.data.Visit;
import com.bronka.server.data.VisitState;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

        Visit visit = new Visit("visitId", "", VisitState.NEW, "", 3,
                "Restoraunt", "client Name", "client id");


        LOG.info(visit);


    }

    @Test
    public void clientCreationTest() {

        long rangeBegin = 1;
        long rangeEnd = 45;
        List<String> list = new ArrayList<>();
        list.stream().distinct().collect(Collectors.toList());

        }

}
