package org.ibrahimhilali.TimeTracker.classes;

import com.google.gson.Gson;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import generators.Timers;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class TimerTest {

    @Property(trials = 10)
    public void testsToString(@From(Timers.class) Timer timer) {
        assertEquals((new Gson()).toJson(timer), timer.toString());


    }
}