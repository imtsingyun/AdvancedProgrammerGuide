package org.mindidea.demo02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TraderMain {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		System.out.println("=============================================");
		// 找出 2011 年所有交易并按交易额排序
		List<Transaction> tr2011 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());
		System.out.println(tr2011);
		System.out.println("=============================================");
		// 交易员都在哪些城市工作过
		List<String> cities = transactions.stream().map(transaction -> transaction.getTrader().getCity())
				.distinct().collect(Collectors.toList());
		System.out.println(cities);
		System.out.println("=============================================");
		// 找出所有来自剑桥的交易员，并按名字排序
		List<Trader> traders = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct().sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		System.out.println(traders);
		System.out.println("=============================================");
		//
		String traderStr = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (n1, n2) -> n1 + "," + n2);
		System.out.println(traderStr);
		System.out.println("=============================================");
	}
}
