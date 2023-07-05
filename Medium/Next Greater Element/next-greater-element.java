//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        ot.print(res[i] + " ");
		    ot.println();
		}
        ot.close();
	}
}



// } Driver Code Ends


// User Function Template for JAVA

class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        long[] ans = new long[n];
        //deque works just like a stack 
        //Stack s = new Stack 
        //ye nakli stack hai according to anuj bhaiya
        Deque<Long> s = new ArrayDeque<Long>();
        
        for(int i = n-1 ; i > -1 ; i-- )
        { 
            while(!s.isEmpty() && s.peek() <=  arr[i])
            { s.pop(); }
            
            
            // pura stack khali no element found so -1
            if(s.isEmpty())
            ans[i] = -1;
            else
            ans[i] = s.peek();
            
            
            //push the element into the stack after we have found the respective element for it 
            s.push(arr[i]);
        }
        
        
        return ans;
    } 
    
    //Note to self -- next wale mai right to left jaate hai
    //Next greater mai reverse karne ki zarurat nahi hai
} 