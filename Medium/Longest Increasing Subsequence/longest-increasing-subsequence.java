//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        int[] tail = new int[size];
        int len = 1;
        
        tail[0] = a[0];
        
        for(int i = 1 ; i < size ; i++)
        {
            if(tail[len-1] < a[i])
            {
                tail[len] = a[i];
                len++;
            }
            else 
            {
               int c = binarySearch(tail , 0 , len-1 , a[i]);
               tail[c] = a[i];
            }
        }
        
        return len;
    }
    
    
    static int binarySearch(int[] tail, int low , int high , int element)
    {
        while(low < high)
        {
            int mid  = low + (high - low)/2;
            
            if(tail[mid] >= element)
            {
               high = mid; 
            }
            else // element 
            {
             low = mid + 1;   
            }
        }
        
        return high;
        
    }
} 