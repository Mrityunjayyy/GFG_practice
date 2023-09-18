//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.onesComplement(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int onesComplement(int N){
      
      //step1 
      //count the number of bits
      
      int number_of_bits = (int)Math.floor( Math.log(N) / Math.log(2) ) +1;
    //   System.out.println("ye" + number_of_bits);
      
      //step2
      //make a number of with the all the bits as 1
      
      int num = (1 << number_of_bits) - 1;
    //   System.out.println("nums is: "  +num);
      
      return N ^ num;
      
    }
}