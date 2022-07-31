package org.mindidea._02_structural._00_adapter.clazz;

public class AdapterPattern02 {
	public static void main(String[] args) {
		StockAnalysis stock = new StockAnalysis();
		stock.analysis(new StockJsonAdapter());
	}
}

interface IStockJson {
	String xml2Json();
}

// 被适配对象
class StockXmlAdaptee {
	/**
	 * 获取股票数据，xml 格式
	 *
	 * @return xml
	 */
	public String getStockDataInXML() {
		System.out.println("股票交易所返回 xml 格式数据");
		return "xml";
	}
}

class StockJsonAdapter extends StockXmlAdaptee implements IStockJson {
	@Override
	public String xml2Json() {
		String xml = getStockDataInXML();
		System.out.println("将 xml 数据转换成 json 格式");
		return "json";
	}
}

class StockAnalysis {
	public void analysis(IStockJson json) {
		String s = json.xml2Json();
		if ("json".equals(s))
			System.out.println("分析系统可以分析 json 数据了");
	}
}