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
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        boolean[] primeNumbers = new boolean[N+1];
        Arrays.fill(primeNumbers, true);
        ArrayList<Integer> al = new ArrayList<Integer>();
        primeNumbers[0] = false; //0 
        primeNumbers[1] = false; //1 is neither prime nor composite
       
       for(int i = 2 ; i * i <=  N ; i++)
       { 
           for(int j = 2 * i ; j <= N ; j = j + i)
           { 
               primeNumbers[j] = false;
           }
       }
          
          
          for(int i = 2; i <= N; i++) 
          { 
              if(primeNumbers[i])
              al.add(i);
          }
          
          
          return al;
    }
}