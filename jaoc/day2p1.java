///usr/bin/env jbang "$0" "$@" ; exit $?

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class day2p1 {
    public static void main(String[] args) {
        String input = (args.length <= 0) ? "day2input" : args[0];

        try (Stream<String> lines = Files.lines(Path.of(input))) {
            Stream<String> parts = lines.flatMap(line -> Arrays.stream(line.split(",")))
                    .flatMapToLong(range -> {
                        String[] nums = range.split("-");
                        long start = Long.parseLong(nums[0]);
                        long end = Long.parseLong(nums[1]);
                        return LongStream.rangeClosed(start, end);
                    }).mapToObj(String::valueOf);


            System.out.println(parts.filter(day2p1::isRepeatingSequence).mapToLong(Long::parseLong).sum());
//            parts.filter(day2p1::isRepeatedTwice).mapToLong(Long::parseLong).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isRepeatingSequence(String s) {
        if(s == null || s.length() <= 1) {
            return false;
        }
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }

    public static boolean isRepeatedTwice(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;  // must be even length
        }

        int mid = s.length() / 2;

        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);

        return firstHalf.equals(secondHalf);
    }

}
