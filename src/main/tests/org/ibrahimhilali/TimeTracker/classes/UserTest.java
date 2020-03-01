package org.ibrahimhilali.TimeTracker.classes;

import com.google.gson.Gson;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class UserTest {

    @Property(trials = 5)
    public void tests(@From(Users.class) User user) {
        assertEquals((new Gson()).toJson(user), user.toString());
    }


}