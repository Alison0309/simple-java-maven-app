package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testAppConstructor() {
        App app1 = new App();
        App app2 = new App();
        assertEquals(app1.getMessage(), app2.getMessage());
    }

    @Test
    public void testAppMessage()
    {
        App app = new App();
        assertEquals("Hello from Spark Web Server! Welcome to the Java world!", app.getMessage());
    }

    @Test
    public void testMessageLength() {
        App app = new App();
        assertEquals(28, app.getMessageLength());  // "Hello from Spark Web Server!!!Come" has 34 characters
    }

    @Test
    public void testMessageUpperCase() {
        App app = new App();
        assertEquals("HELLO FROM SPARK WEB SERVER!!!COME", app.getMessageUpperCase());
    }
}
