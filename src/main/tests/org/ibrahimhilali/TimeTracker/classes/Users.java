package org.ibrahimhilali.TimeTracker.classes;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;


public class Users extends Generator<User> {

    public Users() {
        super(User.class);
    }

    @Override
    public User generate(SourceOfRandomness random, GenerationStatus status) {
        String email = gen().type(String.class).generate(random, status);
        String name = gen().type(String.class).generate(random, status);
        String token = Long.toString(Math.abs(random.nextLong()), 16);
        return new User(name, email, token);
    }
}
