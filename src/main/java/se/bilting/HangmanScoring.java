package se.bilting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class HangmanScoring implements Scoring {

    Path path = Path.of("hangmanscore.txt");
    @Override
    public void saveResult(int score) {
        try {
            Files.writeString(path, score+"\n", StandardOpenOption.APPEND,StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getStats() {
        Stream<String> str = null;
        try {
            str = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IntSummaryStatistics stat = str
                .mapToInt(Integer::parseInt)
                .summaryStatistics();
        return "Games played: " + stat.getCount() + "\n" +
                "Average: " + stat.getAverage() + "\n";

    }
}
