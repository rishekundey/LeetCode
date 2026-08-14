package com.leet.code1;

/*
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.
 * The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
 * 
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 * 
 * Example 1:
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
 * 
 * Example 2:
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 * 
 * Constraints:
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 * 
 * Explanation Video: https://www.youtube.com/watch?v=3j0sJ3w4t9A
 * 
 * Time Complexity: O(n) where n is the number of people. We are iterating through the array of people and distributing candies until we run out of candies.
 * Space Complexity: O(n) where n is the number of people. We are using an array of size num_people to store the final distribution of candies.
 * 
 * Data Structures used: Array
 * Algorithm used: Simulation
 * 
 */

public class DistributeCandiesToPeople {
	
	/*
	 * The function takes in two parameters: candies (the total number of candies to
	 * distribute) and num_people (the number of people to distribute the candies
	 * to). It returns an array of integers representing the final distribution of
	 * candies among the people.
	 * 
	 * @param candies The total number of candies to distribute.
	 * @param num_people The number of people to distribute the candies to.
	 * 
	 * @return An array of integers representing the final distribution of candies
	 * 
	 */
	public static int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        
        int currCandyCount = 1;
        
        while(candies > 0) {
            for(int i = 0; i<num_people; i++) {
                if(candies >= currCandyCount) { // check if we have enough candies to distribute next
                    arr[i]+= currCandyCount;
                    candies -=currCandyCount;
                    currCandyCount++;
                    System.out.println("i = "+i+ " candies: " + candies + " currCandyCount: " + currCandyCount);
                } else { // we don't have enough candies to distribute
                    arr[i] += candies; // distribute whatever is remaining
                    candies = 0; // set to 0 so it exits the while loop
                }
            }
        }
        return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candies = 20;
		int num_people = 3;
		
		int[] result = distributeCandies(candies, num_people);
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
