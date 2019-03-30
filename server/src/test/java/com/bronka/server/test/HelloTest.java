package com.bronka.server.test;

import com.bronka.server.JavaMain;
import com.bronka.server.KotlinMainKt;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

public class HelloTest extends TestCase {

    private final static Logger LOG = Logger.getLogger(HelloTest.class);

    public void testAssert() {
        assertEquals("This Hello is sent from Kotlin!", KotlinMainKt.KotlinHelloString);
        assertEquals("This Hello is sent from JAVA!", JavaMain.javaSendToKotlin());
        LOG.info("VSE OKAY");
    }
}
