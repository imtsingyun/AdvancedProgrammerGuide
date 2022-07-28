package org.mindidea._01_creation._00_singleton.staticinnerclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 30; i++) {
			es.submit(() -> System.out.println(DBConnectionPool.getInstance()));
		}
	}
}
