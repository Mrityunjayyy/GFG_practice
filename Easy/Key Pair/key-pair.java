//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
    boolean flag = false;
     HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
     
     //add the values of the array to the hashmap arr[i] is key and index (i) is value 
     for(int i = 0 ; i < n ; i++)
     {  
         map.put(arr[i] , i);
     }
     
     for(int i =0 ; i< n ; i++)
     { 
         // hashmap use karke arrays ki values as keys store karwa li.
         // contains key ka use isliye kia because it will be O(1) and hame ek aur loop nahi lagana pada
         if(arr[i] == x && map.containsKey(0))
         {flag = true;
         break; }
         
        else if(map.containsKey(x - arr[i]))
        { 
            if(map.get(x - arr[i]) > i ) //map.get() will give address and should be greater than i so that the same element is not taken eg : target = 2 , 2+2        
            { 
                flag = true; 
                break;
            }
        }
            
     }
     
     
     return flag;
    }
}