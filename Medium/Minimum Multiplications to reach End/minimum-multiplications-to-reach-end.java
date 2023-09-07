//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
       if(start == end) return 0;
       
       int mod = 1_00_000;
       
     boolean[] visited = new boolean[mod];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int level = 0;

        while (!q.isEmpty()) 
        {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                int ele = q.poll();

                for (int num : arr) {
                    int child = (ele * num) % mod;

                    if (!visited[child]) {
                        if (child == end) {
                            return level;
                        }

                        visited[child] = true;
                        q.offer(child);
                    }
                }
            }
        }

              
       
       return -1;
    }
}
