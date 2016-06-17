package com.yc.music.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
	public static void getFromMap(Map map) {
		for (Iterator ite = map.keySet().iterator(); ite.hasNext();) {
			Object key = ite.next();
			Object value = map.get(key);
		}
	}

	public static void getFromMapByEntrySet(Map map) {
		for (Iterator ite = map.entrySet().iterator(); ite.hasNext();) {
			Map.Entry entry = (Map.Entry) ite.next();
			entry.getKey();
			entry.getValue();
		}
	}

	public static void main(String[] args) {
		Map map = new HashMap();
		for (int i = 0; i < 200000; i++) {
			map.put("key" + i, "value" + i);
		}
		long currentTime = System.currentTimeMillis();
		getFromMap(map);
		long currentTime2 = System.currentTimeMillis();
		getFromMapByEntrySet(map);
		long currentTime3 = System.currentTimeMillis();
		System.out.println(currentTime2 - currentTime);
		System.out.println(currentTime3 - currentTime2);
	}
}
