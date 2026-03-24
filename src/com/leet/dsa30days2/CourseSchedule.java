package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.List;

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
