package com.bronka.server.test;

import com.bronka.server.JavaMain;
import com.bronka.server.KotlinMainKt;
import junit.framework.TestCase;

public class HelloTest extends TestCase {
    public void testAssert() {
        assertEquals("This Hello is sent from Kotlin!", KotlinMainKt.KotlinHelloString);
        assertEquals("This Hello is sent from JAVA!", JavaMain.javaSendToKotlin());
    }
}
