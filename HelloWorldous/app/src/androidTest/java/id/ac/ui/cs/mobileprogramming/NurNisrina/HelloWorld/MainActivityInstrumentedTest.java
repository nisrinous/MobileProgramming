package id.ac.ui.cs.mobileprogramming.NurNisrina.HelloWorld;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);
    @Test
    public void testHelloMessageAppear() {
        onView(withId(R.id.greetingImage)).perform(click());
    }

}

