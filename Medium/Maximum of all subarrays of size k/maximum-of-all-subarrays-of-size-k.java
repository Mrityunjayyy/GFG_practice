//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

// sliding window question using deque - Mrityunjay

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
       ArrayList<Integer> ans = new ArrayList<Integer>();
       Deque<Integer> dq = new ArrayDeque<Integer>();
       
       solve(arr , n , k , ans , dq);
       
       return ans;
       
    }
    
    
    public static void solve(int[] arr , int n , int k , ArrayList<Integer> ans ,   Deque<Integer> dq)
    {
        int i = 0 ; 
        for( i = 0 ; i <  k ; i++)
        { 
            while(!dq.isEmpty()  && arr[i] > arr[dq.peekLast()])
            { dq.removeLast() ;}
            
            dq.addLast(i);
        }
        
         for( ; i < n ; i++)
         {
             ans.add(arr[dq.peekFirst()]);
             
             //remove the elements that are not the part of our sliding window
             while(!dq.isEmpty() && (dq.peekFirst() <= i -k ) )
             dq.removeFirst();
             
             
             //same as step1 and step2
             
            while(!dq.isEmpty()  && arr[i] > arr[dq.peekLast()])
            { dq.removeLast() ;}
            
            dq.addLast(i);
         }
         
         ans.add(arr[dq.peekFirst()]);
         
          
    }
}