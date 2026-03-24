package com.leet.dsa30days2;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, Integer> cache;
	int capacity;
	
	public LRUCache(int capacity) {
		cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > LRUCache.this.capacity;
			}
		};
		this.capacity = capacity;
		
	}

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		cache.put(key, value);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 1); // cache is {1=1}
		lruCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lruCache.get(1));    // return 1
		lruCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
		System.out.println(lruCache.get(2));    // returns -1 (not found)
		lruCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
		System.out.println(lruCache.get(1));    // return -1 (not found)
		System.out.println(lruCache.get(3));    // return 3
		System.out.println(lruCache.get(4));    // return 4
		

	}

}
