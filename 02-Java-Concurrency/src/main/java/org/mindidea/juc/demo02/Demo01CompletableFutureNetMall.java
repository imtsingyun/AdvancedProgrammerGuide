/*
 * @class Demo01CompletableFutureNetMall
 * @package org.mindidea.juc.demo02
 * @date 2021-11-30 9:53
 */
package org.mindidea.juc.demo02;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021-11-30 9:52
 */
public class Demo01CompletableFutureNetMall {

	static List<NetMall> list = Arrays.asList(
			new NetMall("tm"),
			new NetMall("jd"),
			new NetMall("pdd"),
			new NetMall("tb")
	);

	public static List<String> getPriceListByStep(List<NetMall> list, String productName) {
		return list.stream()
				.map(mall -> String.format(productName + " in %s price is %.2f.", mall.getMallName(), mall.calcPrice(productName)))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {

	}
}

class NetMall {

	public NetMall(String mallName) {
		this.mallName = mallName;
	}

	private String mallName;

	public String getMallName() {
		return mallName;
	}

	public double calcPrice(String productName) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
	}
}