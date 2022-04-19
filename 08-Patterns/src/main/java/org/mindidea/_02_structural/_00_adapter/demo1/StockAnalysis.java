package org.mindidea._02_structural._00_adapter.demo1;

import org.mindidea._02_structural._00_adapter.demo1.dst.Target;

/**
 * 股票数据分析系统，只能接收 json 数据
 */
public class StockAnalysis {

	public void analysis(Target target) {
		target.xml2Json();
		System.out.println("股票分析系统接收到 json 数据");
	}
}
