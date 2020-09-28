package id.ac.ui.cs.mobileprogramming.NurNisrina.HelloWorld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MainActivityUnitTest {
    @Test
    public void testHelloMessageAppear() {
        String helloMessage = StaticFunctions.GreetingMessage("Hello!");
        assertEquals(helloMessage, "Hello!");
    }

}
