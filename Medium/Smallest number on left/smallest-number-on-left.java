//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//stacks ka question -- Mrityunjay 
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
      List<Integer> ans = new ArrayList<Integer>();
      Stack<Integer> stack1 = new Stack<Integer>();
      
      for(int i = 0 ; i < n ; i++)
      {  
          //jab tak chota element na mil jaye stack se elements nikalte raho stack1.pop()
          while(!stack1.empty() && stack1.peek() >= a[i])
          {  stack1.pop(); }
          
           
           //pura stack khali no smaller element so add -1
          if(stack1.empty())
          ans.add(-1);
          else
          ans.add(stack1.peek()); //the topmost element will the smallest one
    
    
          //add the element into the stack after we have found the left smaller element for it 
          stack1.push(a[i]);
          
      }
      
      //result arraylist
      return ans;
    }
    
    //Anuj bhaiya dsa playlist stacks  -- https://www.youtube.com/watch?v=_RtghJnM1Qo&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=42
}