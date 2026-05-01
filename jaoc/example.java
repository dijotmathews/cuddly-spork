///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.out;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


class day1 {


	public static void main(String[] args) {
		if(args.length <= 0)
			return; 
		String input = args[0];

		try(BufferedReader reader = new BufferedReader(new FileReader(input))) {
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}		
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
