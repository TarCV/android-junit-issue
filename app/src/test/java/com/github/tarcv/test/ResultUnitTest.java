package com.github.tarcv.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class ResultUnitTest {
    @After
    public void afterMethod() {
        throw new RuntimeException("Exception from afterMethod");
    }

    @Test
    public void normalFailure() {
        basicTestSteps();

        Assert.assertTrue(false);
    }

    @Test
    public void assumptionFailure() {
        basicTestSteps();

        Assume.assumeTrue(false);
    }

    private void basicTestSteps() {
        // no op
    }
}
