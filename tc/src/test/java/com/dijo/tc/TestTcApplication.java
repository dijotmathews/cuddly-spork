package com.dijo.tc;

import org.springframework.boot.SpringApplication;

public class TestTcApplication {

	public static void main(String[] args) {
		SpringApplication.from(TcApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
