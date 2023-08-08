//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
       HashMap<ArrayList<Integer> , Integer> map = new  HashMap<>();
       int ans = 0;
       
       for(int i = 0 ; i < n ; i++)
       {
           int hcf = gcd(numerator[i] , denominator[i]);
           
           numerator[i] /= hcf;
           denominator[i] /= hcf;
           
            int x =  numerator[i];
            int y = denominator[i];
            
            int z = y - x ;  // 1 - x/y --> (y-x)/y
            
            //fraction
            ArrayList<Integer> fraction = new ArrayList<>();
            fraction.add(x);
            fraction.add(y);
            
            //1 - fraction
            ArrayList<Integer> minusOne = new ArrayList<>();
            minusOne.add(z);
            minusOne.add(y);
            
            if(map.containsKey(minusOne))
            {
                 ans += map.get(minusOne);
            }
            
            map.put(fraction , map.getOrDefault(fraction , 0) +1 );

       }
       
       return ans;
      
    }
    
    
    static int gcd(int a , int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    
  
    
} 
        
