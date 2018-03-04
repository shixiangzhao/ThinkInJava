package com.shixiang.think.swing;

import java.util.HashMap;
import java.util.Map;

public class Countries {

	public static Map<? extends String, ? extends String> capitals() {
		Map<String, String> map = new HashMap<>();
		map.put("henan", "zhengzhou");
		map.put("beijing", "beijing");
		map.put("tianjin", "tianjin");
		map.put("hebei", "shijiazhuang");
		map.put("shandong", "jinan");
		return map;
	}

}
