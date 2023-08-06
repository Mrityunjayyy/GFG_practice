//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
       
       int[][][] t = new int[n1 +1 ][n2 + 1][ n3 +1];
       return dp(A,B,C, n1 , n2 , n3 , t);
       
        
    }
    
     
     int dp(String A , String B , String C , int n1 , int n2 , int n3 , int[][][] t)
     {
         for(int i =1 ; i < n1 +1 ; i++)
         {
             for(int j =1 ; j < n2 + 1 ; j++)
             {
                 for(int k = 1 ; k < n3 +1 ; k++)
                 {
                     if(A.charAt(i-1) == B.charAt(j-1) && B.charAt(j-1) == C.charAt(k-1))
                     {
                         t[i][j][k] = 1 + t[i-1][j-1][k-1];
                     }
                     else 
                     {
                         t[i][j][k] = Math.max(t[i-1][j][k] , Math.max( t[i][j-1][k] , t[i][j][k-1] ));
                     }
                 }
             }
         }
         
         return t[n1][n2][n3];
     }
} 