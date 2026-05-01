///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.out;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class day1p1 {

	public static void main(String[] args) {
		String input = "";
		input = (args.length <= 0) ? "day1input" : args[0]; 
		int start = (args.length == 2) ? Integer.parseInt(args[1]) : 50;
		int count = 0;
		

		try(BufferedReader reader = new BufferedReader(new FileReader(input))) {
			System.out.println("The dial start by pointing at "+ start);
			List<Integer> steps = IntStream.rangeClosed(0,99).boxed().collect(Collectors.toList());
			int size = steps.size();
			int current = start;

			System.out.println(size);

			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				String direction = line.substring(0,1);
				int value = Integer.parseInt(line.substring(1,line.length()));
				// steps.get(value % size);
				
				System.out.print("The dial is rotated "+ line + " to point at ");
				switch(direction) {
					case "R":
						current = (current + value) % size;
						break;
					case "L":
						current = (current - value) % size;	
						break;
				}
				// System.out.println(value);
				System.out.println(current);
				if(current == 0) 
					count++;

			}
			System.out.println(count);
				
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
