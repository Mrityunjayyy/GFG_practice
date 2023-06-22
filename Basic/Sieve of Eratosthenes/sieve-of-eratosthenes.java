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
    ArrayList<Integer> al = new ArrayList<Integer>();
     boolean[] isPrime = new boolean[N+1];
     Arrays.fill(isPrime , true);
     
     isPrime[0] = false;
     isPrime[1] = false; 
     
     EratosThenes(isPrime , N);
     
     for(int i = 0 ; i <= N ; i++)
     { 
         if(isPrime[i])
         al.add(i);
     }
     
     
     return al;
     
    }
    
    public static void EratosThenes(boolean[] isPrime , int N)
    {
      for(int i = 2 ; i * i <= N ; i++)
      {
          for(int j = 2*i ; j <= N ; j = j + i)
          { 
              isPrime[j] = false;
          }
      }
    }
}