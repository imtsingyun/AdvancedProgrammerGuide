package org.mindidea._01_creation._04_builder.demo1;

public class MainTest {
	public static void main(String[] args) {
		Builder game = new GameBuilder();
		Director dir0 = new Director(game);
		dir0.send();
		System.out.println(game.buildComputer().toString());

		Builder business = new BusinessBuilder();
		Director dir1 = new Director(business);
		dir1.send();
		System.out.println(business.buildComputer().toString());
	}
}
