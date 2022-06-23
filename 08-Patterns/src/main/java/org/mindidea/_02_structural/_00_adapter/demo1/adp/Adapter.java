package org.mindidea._02_structural._00_adapter.demo1.adp;

import org.mindidea._02_structural._00_adapter.demo1.dst.Target;
import org.mindidea._02_structural._00_adapter.demo1.src.StockExchange;

public class Adapter extends StockExchange implements Target {
	@Override
	public String xml2Json() {
		String xml = getStockDataInXML();
		System.out.println("适配器将 xml 格式数据转换成 json 数据");
		// 模拟将 xml 格式数据转换成 json
		@SuppressWarnings("UnnecessaryLocalVariable")
		String json = xml;
		return json;
	}
}