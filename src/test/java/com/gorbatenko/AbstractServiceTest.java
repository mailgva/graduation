package com.gorbatenko;

import org.junit.Rule;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractServiceTest {
    @Rule
    public Stopwatch stopwatch = TimingRules.STOPWATCH;
}
