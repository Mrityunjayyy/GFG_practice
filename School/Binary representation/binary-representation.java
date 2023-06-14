//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            String ans = ob.getBinaryRep(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String getBinaryRep(int N){
        StringBuilder sb = new StringBuilder();
        while(N > 0 || sb.length() < 30)
        { 
            
            if(N != 0)
            {
            sb.insert(0 , "" + N%2);
            N  = N/2; 
            }
            
            else
            { 
                sb.insert(0,"" + 0);
            }
        }
        
        // for(int i = 1 ; i <= 30 - sb.length() ; i++)
        // { 
        //     sb.append("" + 0);
        // }
        
        return sb.toString();
    }
}