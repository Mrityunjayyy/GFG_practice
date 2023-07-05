//{ Driver Code Starts
//Initial Template for Java


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 


// } Driver Code Ends


//User function Template for Java
// stack ka next smaller element wala question hai ye

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	  int[] ans = new int[n];
	  Deque<Integer> s = new ArrayDeque<Integer>();
	  
	  //next wale mai right to left traverse
	  for(int i = n -1  ; i > -1  ; i--)
	  { 
	      while(!s.isEmpty() && s.peek() >= arr[i])
	      { s.pop() ; }
	      
	      if(s.isEmpty())
	      ans[i] = -1;
	      else 
	      ans[i] = s.peek(); // array mai store karne se order sahi ho jayega 
	      //ans wali array mai bi values left to right store hongi.
	      
	      
	      //push the element into the stack after we have founf the respective element for it
	      s.push(arr[i]);
	  }
	  
	  

	  
	  return ans;
	} 
}
