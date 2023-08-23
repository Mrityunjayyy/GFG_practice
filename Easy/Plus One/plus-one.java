//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0 ; i<N ; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<Integer> res = ob.increment(arr,N);
            
            for(int i=0; i<res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        int[] nums = new int[arr.size()];
        for(int i = 0 ; i < arr.size() ; i++)
        {
            nums[i] = arr.get(i).intValue();
        }
        
        int n = nums.length;
        for(int i = n-1 ; i > -1 ; i--)
        {
            if(nums[i] < 9)
            {
                nums[i]++;
                return make(nums);
            }
            else if(nums[i] == 9)
            {
                 nums[i] = 0;
            }
        }
        
        
        if(nums[0] == 0)
        {
            nums = new int[N+1];
            nums[0] =1;
        }
         return make(nums);
    }
    
    static ArrayList<Integer> make(int[] arr)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < arr.length ; i++)
        {
            al.add(arr[i]);
        }
        return al;
    }
    
}; 