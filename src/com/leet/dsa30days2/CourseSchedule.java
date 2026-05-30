package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode Problem 207: Course Schedule
 * Difficulty: Medium
 * Description:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you 
 * must take course bi before course ai.
 * Return true if you can finish all courses. Otherwise, return false.
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0. So it is possible.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0, and to take course 0 you should also have finished course 1. So it is 
 * impossible.
 * Example 3:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,1],[3,2]]
 * Output: true
 * Explanation: There are a total of 4 courses to take. To take course 1 you should have 
 * finished course 0, to take course 2 you should have finished course 1, and to take course 
 * 3 you should also have finished course 2. So it is possible.
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All prerequisite pairs are distinct.
 * 
 * Solution Approach:
 * 1. We can represent the courses and their prerequisites as a directed graph, where each 
 * course is a node and there is a directed edge from course bi to course ai if bi is a 
 * prerequisite for ai.
 * 2. We need to check if there is a cycle in the graph. If there is a cycle, it means that 
 * there is a circular dependency among the courses, and we cannot finish all courses.
 * 3. We can use Depth-First Search (DFS) to detect cycles in the graph. We will maintain 
 * two boolean arrays: one to track visited nodes and another to track nodes currently in 
 * the path of the DFS.
 * 4. If we encounter a node that is currently in the path, it means we have found a cycle, 
 * and we can return false. If we finish processing all nodes without finding a cycle, we 
 * can return true.
 * Time Complexity: O(V + E), where V is the number of courses (nodes) and E is the number 
 * of prerequisites (edges).
 * Space Complexity: O(V + E) for the graph representation and the visited arrays.
 * 
 * Explanation Video: https://www.youtube.com/watch?v=EgI5nUuBqjA
 * 
 */

public class CourseSchedule {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		// Create an adjacency list to represent the graph
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}

		// Build the graph
		for (int[] prerequisite : prerequisites) {
			graph.get(prerequisite[1]).add(prerequisite[0]);
		}

		// Array to track visited nodes
		boolean[] visited = new boolean[numCourses];
		// Array to track nodes in the current path
		boolean[] onPath = new boolean[numCourses];

		// Perform DFS for each course
		for (int i = 0; i < numCourses; i++) {
			if (hasCycle(graph, visited, onPath, i)) {
				return false; // Cycle detected
			}
		}

		return true; // No cycles detected
	}

	private static boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] onPath, int course) {
		if (onPath[course]) {
			return true; // Cycle detected
		}

		if (visited[course]) {
			return false; // Already processed this node
		}

		visited[course] = true;
		onPath[course] = true;

		for (int neighbor : graph.get(course)) {
			if (hasCycle(graph, visited, onPath, neighbor)) {
				return true; // Cycle detected in the neighbor
			}
		}

		onPath[course] = false; // Backtrack
		return false; // No cycle detected
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canFinish(2, new int[][] { { 1, 0 } })); // Output: true
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } })); // Output: false
		System.out.println(canFinish(4, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 } })); // Output: true
	}

}
