package com.leet.dsa30days2;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 146. LRU Cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, 
 * add the key-value pair to the cache. If the number of keys exceeds the capacity from this 
 * operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * Constraints:
 * 1 <= capacity <= 3000
 * 0 <= key <= 10^4
 * 0 <= value <= 10^5
 * At most 2 * 10^5 calls will be made to get and put.
 * 
 * Approach:
 * 1. We can use a LinkedHashMap to implement the LRU cache. The LinkedHashMap maintains the 
 * order of access, which allows us to easily evict the least recently used item when the 
 * cache exceeds its capacity.
 * 2. The get method retrieves the value associated with the key and updates the access order. 
 * If the key does not exist, it returns -1.
 * 3. The put method adds a new key-value pair to the cache or updates the value of an 
 * existing key. If the cache exceeds its capacity, the least recently used item is 
 * automatically evicted by overriding the removeEldestEntry method of LinkedHashMap.
 * 
 * Time Complexity:
 * Both get and put operations run in O(1) time complexity due to the use of LinkedHashMap.
 * 
 * Space Complexity:
 * The space complexity is O(capacity) since we are storing at most 'capacity' number of 
 * key-value pairs in the cache.
 * This implementation efficiently manages the cache while adhering to the LRU eviction 
 * policy, ensuring that both get and put operations are performed in constant time.
 * 
 * Alternate Approach:
 * 1. We can also implement the LRU cache using a combination of a HashMap and a Doubly 
 * Linked List. The HashMap allows for O(1) access to cache items, while the Doubly Linked 
 * List maintains the order of usage.
 * 2. The get method retrieves the value from the HashMap and moves the corresponding node 
 * to the front of the Doubly Linked List to indicate that it was recently used.
 * 3. The put method adds a new key-value pair to the HashMap and creates a new node in the 
 * Doubly Linked List. If the cache exceeds its capacity, the least recently used item (the 
 * tail of the list) is removed from both the HashMap and the Doubly Linked List.
 * Time Complexity:
 * Both get and put operations run in O(1) time complexity due to the use of HashMap and 
 * Doubly Linked List.
 * Space Complexity:
 * The space complexity is O(capacity) since we are storing at most 'capacity' number of 
 * key-value pairs in the cache, along with the nodes in the Doubly Linked List.
 * This approach provides a more manual implementation of the LRU cache, giving us more 
 * control over the data structure and potentially better performance in certain scenarios, 
 * but it is more complex to implement compared to using LinkedHashMap.
 * 
 * Note:
 * The LinkedHashMap approach is simpler and more concise, while the HashMap and Doubly 
 * Linked List approach offers more control and can be more efficient in certain cases. The 
 * choice between the two approaches depends on the specific requirements of the application 
 * and the developer's preference for code clarity versus performance optimization.
 * 
 * Explanation video: https://www.youtube.com/watch?v=7ABFKPK2hD4
 * 
 * Explanation for the LinkedHashMap approach:
 * 1. We create a LinkedHashMap with a specified capacity and set the accessOrder flag to 
 * true, which maintains the order of access.
 * 2. We override the removeEldestEntry method to automatically remove the least recently 
 * used entry when the cache exceeds its capacity.
 * 3. The get method retrieves the value associated with the key and updates the access order. 
 * If the key does not exist, it returns -1.
 * 4. The put method adds a new key-value pair to the cache or updates the value of an 
 * existing key. If the cache exceeds its capacity, the least recently used item is 
 * automatically evicted by the overridden removeEldestEntry method.
 * This implementation efficiently manages the cache while adhering to the LRU eviction 
 * policy, ensuring that both get and put operations are performed in constant time.
 * 
 * Explanation for the HashMap and Doubly Linked List approach:
 * 1. We create a HashMap to store the key-value pairs and a Doubly Linked List to maintain 
 * the order of usage.
 * 2. The get method retrieves the value from the HashMap and moves the corresponding node 
 * to the front of the Doubly Linked List to indicate that it was recently used. If the key 
 * does not exist, it returns -1.
 * 3. The put method adds a new key-value pair to the HashMap and creates a new node in the 
 * Doubly Linked List. If the cache exceeds its capacity, the least recently used item (the 
 * tail of the list) is removed from both the HashMap and the Doubly Linked List.
 * This approach provides a more manual implementation of the LRU cache, giving us more 
 * control over the data structure and potentially better performance in certain scenarios, 
 * but it is more complex to implement compared to using LinkedHashMap.
 * In summary, both approaches effectively implement the LRU cache with O(1) time complexity 
 * for get and put operations, but the LinkedHashMap approach is simpler and more concise, 
 * while the HashMap and Doubly Linked List approach offers more control and can be more 
 * efficient in certain cases. The choice between the two approaches depends on the specific 
 * requirements of the application and the developer's preference for code clarity versus 
 * performance optimization.
 * 
 */

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
