package org.mindidea._02_structural._00_adapter.obj;

public class AdapterPattern02 {
	public static void main(String[] args) {
		new StockAnalysis().analysis(new StockJsonAdapter(new StockXmlAdaptee()));
	}
}

interface IStockJson {
	String xml2Json();
}

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

class StockJsonAdapter implements IStockJson {
	private StockXmlAdaptee stockXmlAdaptee;

	public StockJsonAdapter(StockXmlAdaptee xmlAdaptee) {
		this.stockXmlAdaptee = xmlAdaptee;
	}

	@Override
	public String xml2Json() {
		String xml = stockXmlAdaptee.getStockDataInXML();
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