package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class StringGenerator extends Generator<StringBuilder> {

    public StringGenerator() {
        super(StringBuilder.class);
    }

    @Override
    public StringBuilder generate(SourceOfRandomness random, GenerationStatus status) {
        String s = gen().type(String.class).generate(random, status);
        return new StringBuilder(s);
    }
}