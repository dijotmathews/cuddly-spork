import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

///usr/bin/env jbang "$0" "$@" ; exit $?

public class day3p2 {
   public static void main(String[] args) {
       String input = (args.length <= 0) ? "day3input" : args[0];

       try(Stream<String> lines = Files.lines(Path.of(input))) {

       }
   }

}
