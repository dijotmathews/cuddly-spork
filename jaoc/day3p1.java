///usr/bin/env jbang "$0" "$@" ; exit $?

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class day3p1 {
        public static void main(String[] args) {
            String input = (args.length <= 0) ? "day3input" : args[0];
//            System.out.println(input);

            int totalJoltage = 0;

            try(Stream<String> lines = Files.lines(Path.of(input))) {
//                Stream<Integer> l = lines.flatMap( line -> Arrays.stream(line.split(""))).map(Integer::parseInt);

              for(String line : (Iterable<String>) lines::iterator) {
                  int[] nums = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray(); int firstMaxIndex = IntStream.range(0, nums.length -1).reduce((i, j) -> nums[i] >= nums[j] ? i : j ).orElseThrow();

                  int secondMaxIndex = IntStream.range(firstMaxIndex + 1, nums.length).reduce((i, j) -> nums[i] >= nums[j] ? i : j ).orElseThrow();

                  System.out.println("Found first max: " + nums[firstMaxIndex] + " at index " + firstMaxIndex);
                  System.out.println("Found second max: " + nums[secondMaxIndex] + " at index " + secondMaxIndex);
                  System.out.println("Joltage  " + nums[firstMaxIndex] + nums[secondMaxIndex]);
                  totalJoltage = totalJoltage + nums[firstMaxIndex] * 10 + nums[secondMaxIndex];

              }

              System.out.println("Total joltage: " + totalJoltage);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
}
