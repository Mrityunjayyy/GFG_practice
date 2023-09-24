//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
         int[] count = new int[n];  // Create a count array to store the occurrences of each element

        // Count the occurrences of each element
        for (int num : arr) {
            count[num]++;
        }

        ArrayList<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] > 1) {
                duplicates.add(i);
            }
        }

        if (duplicates.isEmpty()) {
            duplicates.add(-1);
        }

        return duplicates;
    }
}
