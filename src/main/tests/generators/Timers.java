package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.ibrahimhilali.TimeTracker.classes.Timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timers extends Generator<Timer> {
    Timers() {
        super(Timer.class);
    }

    @Override
    public Timer generate(SourceOfRandomness random, GenerationStatus status) {
        Timer timer = new Timer();
        Long duration = gen().type(Long.class).generate(random, status);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTime = dtf.format(gen().type(LocalDateTime.class).generate(random, status));
        String description = gen().type(String.class).generate(random, status);
        String project = gen().type(String.class).generate(random, status);
        String id = gen().type(String.class).generate(random, status);
        timer.setDescription(description);
        timer.setProject(project);
        timer.setId(id);
        timer.setLocalDateTime(localDateTime);
        timer.setDuration(duration);
        return timer;
    }
}
