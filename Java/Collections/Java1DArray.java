/* Java 1D Array

Array is a very simple data structure which is used to store a collection of
data, for example roll number  of all the students in a class or name of all the
countries in the world. To create an array of integer  that can hold 10 values,
you can write code like this:

int[] myList = new int[10]; This problem will test your knowledge on java array.
You are given an array of n integers. A sub-array is "Negative" if sum of all
the integers in that sub-array is negative. Count the number of "Negative sub-
arrays" in the input array.

Note: Subarrays are contiguous chunks of the main array. For example if the
array is {1,2,3,5} then some of the subarrays are {1}, {1,2,3}, {2,3,5},
{1,2,3,5} etc. But {1,2,5} is not an subarray as it is not contiguous.

Input Format

The first line consists an integer n. The next line will contain n space
separated integers. Value of n will be at most 100. The numbers in the array
will range between -10000 to 10000.

Output Format

Print the answer to the problem.

Sample Input

5 1 -2 4 -5 1 Sample Output

9

Explanation

These are the ranges of the 9 negative subarrays in this sample:

[0:1]
[0:3]
[0:4]
[1:1]
[1:3]
[1:4]
[2:3]
[3:3]
[3:4]
Assume that the index is 0 based.
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[game.length];
        
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // Check if we can win from current position
            if (current + leap >= game.length || current == game.length - 1) {
                return true;
            }
            
            // Try moving forward by 1
            if (current + 1 < game.length && game[current + 1] == 0 && !visited[current + 1]) {
                queue.offer(current + 1);
                visited[current + 1] = true;
            }
            
            // Try leaping forward
            if (current + leap < game.length && game[current + leap] == 0 && !visited[current + leap]) {
                queue.offer(current + leap);
                visited[current + leap] = true;
            }
            
            // Try moving backward by 1
            if (current - 1 >= 0 && game[current - 1] == 0 && !visited[current - 1]) {
                queue.offer(current - 1);
                visited[current - 1] = true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        while (q-- > 0) {
            int n = scanner.nextInt();
            int leap = scanner.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scanner.nextInt();
            }
            
            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }
        
        scanner.close();
    }
}
