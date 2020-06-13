package com.github.tarcv.test;

import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;

import static android.os.SystemClock.sleep;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class ResultAndroidTest {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(
            MainActivity.class, true, true);

    @After
    public void afterMethod() {
        throw new RuntimeException("Exception from afterMethod");
    }

    @Test
    public void normalFailure() {
        basicTestSteps();
        onView(withResourceName("non_existing_id"))
                .check(matches(isDisplayed()));
    }

    @Test
    public void assumptionFailure() {
        basicTestSteps();

        Assume.assumeTrue(false);
    }

    private void basicTestSteps() {
        sleep(2_000);
    }
}
