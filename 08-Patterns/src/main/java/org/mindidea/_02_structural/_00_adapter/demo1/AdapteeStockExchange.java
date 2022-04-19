package org.mindidea._02_structural._00_adapter.demo1;

/**
 * 股票交易所，需要被适配的类
 * 该类是返回 xml 数据
 */
public class AdapteeStockExchange {

	/**
	 * 获取股票数据，xml 格式
	 * @return xml
	 */
	public String getStockDataInXML() {
		System.out.println("股票交易所返回 xml 格式数据");
		return "";
	}
}
