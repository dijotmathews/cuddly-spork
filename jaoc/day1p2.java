///usr/bin/env jbang "$0" "$@" ; exit $?

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


class day1p2 {

	public static void main(String[] args) {
		String input = (args.length <= 0) ? "day1input" : args[0];
		int start = (args.length == 2) ? Integer.parseInt(args[1]) : 50;
		final int size = 100;

		try (Stream<String> lines = Files.lines(Path.of(input))) {
			State result = lines.reduce(
				new State(start, 0),
				(state, line) -> step(state, line, size),
				(left, right) -> right
			);
			System.out.println(result.count());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static State step(State state, String line, int size) {
		char direction = line.charAt(0);
		int value = Integer.parseInt(line.substring(1));

		int current = state.current();
		int count = state.count();
		int div = 0;

		switch(direction) {
			case 'R':
				int newCurrent = (current + value);
				if(newCurrent > 0 && current < 0) {
					count++;
				}
				current = newCurrent % size;
				div = newCurrent / size;
				if(div > 0) {
					count += div;
				}
				break;
			case 'L':
				int newCurrent1 = (current - value);
				if(newCurrent1 < 0 && current > 0) {
					count++;
				}
				current = newCurrent1 % size;
				div = newCurrent1 / -size;
				if(div > 0) {
					count += div;
				}
				break;
			default:
				break;
		}

		if(current == 0 && div == 0) {
			count++;
		}
		return new State(current, count);
	}

	private record State(int current, int count) {}
}
