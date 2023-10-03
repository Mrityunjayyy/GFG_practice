//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
                StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            // Decrement n by 1 because Excel columns start from 1, not 0
            n--;
            
            // Calculate the remainder when dividing n by 26
            long remainder = n % 26;
            
            // Convert the remainder into the corresponding character ('A' to 'Z')
            char charToAdd = (char) ('A' + remainder);
            
            // Add the character to the result string
            result.insert(0, charToAdd);
            
            // Divide n by 26 to move to the next position
            n /= 26;
        }
        
        return result.toString();

    }
}