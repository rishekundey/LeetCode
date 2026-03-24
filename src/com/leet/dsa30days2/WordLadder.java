package com.leet.dsa30days2;

import java.util.Arrays;
import java.util.List;

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
