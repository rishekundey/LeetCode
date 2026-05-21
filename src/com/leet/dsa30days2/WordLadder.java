package com.leet.dsa30days2;

import java.util.Arrays;
import java.util.List;

// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// Example 1:
// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//            return its length 5.
// Example 2:
// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]
//  Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
// Constraints:
// 1 <= beginWord.length <= 10
// endWord.length <= 10
// beginWord and endWord are lowercase English letters.
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// wordList[i] consists of lowercase English letters.

// Time Complexity: O(N * M^2) where N is the number of words in the word list and M is the length of each word. This is because for each word, we compare it with every other word to check if they differ by one character, which takes O(M) time, and we do this for all N words.
// Space Complexity: O(N) for the queue and visited set, where N is the number of words in the word list.
// This implementation uses a breadth-first search (BFS) approach to find the shortest transformation sequence. We start from the beginWord and explore all possible transformations level by level until we reach the endWord or exhaust all possibilities. The helper function differByOne checks if two words differ by exactly one character, which is essential for determining valid transformations.
// Note: The BFS approach ensures that we find the shortest path from beginWord to endWord, and the visited set prevents us from revisiting words, thus avoiding cycles in the transformation process.
// This code can be further optimized by pre-processing the word list to create an adjacency list of words that differ by one character, which would reduce the time complexity of finding neighbors from O(N * M) to O(M^2) for each word. However, the current implementation is straightforward and easy to understand, making it suitable for educational purposes and small input sizes.
// Overall, this solution effectively demonstrates the use of BFS to solve the Word Ladder problem while maintaining clarity and correctness.

//  LeetCode: https://leetcode.com/problems/word-ladder/
// GFG: https://practice.geeksforgeeks.org/problems/word-ladder/1
// Striver: https://takeuforward.org/data-structure/word-ladder-bfs-g-39/
// Video Explanation: https://www.youtube.com/watch?v=9UeBzQYqL7g&list=PLgUwDviBIf0rGEWe64Kq2O3X4pS6C8m&index=19
// Article Explanation: https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
// Approach: We can solve this problem using a breadth-first search (BFS) approach. We start from the beginWord and explore all possible transformations level by level until we reach the endWord or exhaust all possibilities. We use a queue to keep track of the current level of transformations and a set to keep track of visited words to avoid cycles. The helper function differByOne checks if two words differ by exactly one character, which is essential for determining valid transformations.
// Time Complexity: O(N * M^2) where N is the number of words in the word list and M is the length of each word. This is because for each word, we compare it with every other word to check if they differ by one character, which takes O(M) time, and we do this for all N words.
// Space Complexity: O(N) for the queue and visited set, where N is the number of words in the word list.
// This implementation effectively demonstrates the use of BFS to solve the Word Ladder problem while maintaining clarity and correctness. It can be further optimized by pre-processing the word list to create an adjacency list of words that differ by one character, which would reduce the time complexity of finding neighbors from O(N * M) to O(M^2) for each word. However, the current implementation is straightforward and easy to understand, making it suitable for educational purposes and small input sizes.
// Overall, this solution effectively demonstrates the use of BFS to solve the Word Ladder problem while maintaining clarity and correctness.
// Note: The BFS approach ensures that we find the shortest path from beginWord to endWord, and the visited set prevents us from revisiting words, thus avoiding cycles in the transformation process.
// This code can be further optimized by pre-processing the word list to create an adjacency list of words that differ by one character, which would reduce the time complexity of finding neighbors from O(N * M) to O(M^2) for each word. However, the current implementation is straightforward and easy to understand, making it suitable for educational purposes and small input sizes.

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		if (!wordList.contains(endWord)) {
			return 0;
		}

		java.util.Queue<String> queue = new java.util.LinkedList<>();
		java.util.Set<String> visited = new java.util.HashSet<>();

		queue.add(beginWord);
		visited.add(beginWord);

		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentWord = queue.poll();

				if (currentWord.equals(endWord)) {
					return level;
				}

				for (String word : wordList) {
					if (!visited.contains(word) && differByOne(currentWord, word)) {
						queue.add(word);
						visited.add(word);
					}
				}
			}
			level++;
		}

		return 0;
		
	}

	static boolean differByOne(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"))); // Output: 5
		System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"))); // Output: 0
		

	}

}
