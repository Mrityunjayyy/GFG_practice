//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        solve(arr , n , k , dq , ans);
        return ans;
        
    }
    
    
    public static void solve(int[] arr , int n , int k,  Deque<Integer> dq , ArrayList<Integer> ans)
    { 
      int i = 0; 
      for(i = 0 ; i < k ; i++)
      {   
          //step 1 -- if the element at the left is less remove it cannot be part of the window
          while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()])
          { dq.removeLast(); }
          
          //step2 -- add the elements from the rear end
          dq.addLast(i);
      }
      
      
      for(  ;  i < n ; i++)
      {   
          // step3 -- print the top element which is max
          //this is the maximum element at the start of the deque
          ans.add(arr[dq.peekFirst()]);
          
          
       
          //step4 -- remove the element not part of the sliding window
          while(!dq.isEmpty() && ( dq.peekFirst() <= i-k ) )
          dq.removeFirst();
          
          
          //step5 -- same as step 1&2
           while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()])
           { dq.removeLast(); }
          
           dq.addLast(i);
      }
      
       //step6 -- printing the max element of the last window
        ans.add(arr[dq.peekFirst()]);
    } 
}