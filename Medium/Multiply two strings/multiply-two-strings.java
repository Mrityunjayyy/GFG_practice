//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    { 
        
        boolean negative1 = false;
        boolean negative2 = false;
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        if(sb1.charAt(0) == '-')
        {
            sb1.deleteCharAt(0);
            negative1 = true;
        }
        if(sb2.charAt(0) == '-')
        {
            sb2.deleteCharAt(0);
            negative2 = true;
        }

        int len1 = sb1.length();
        int len2 = sb2.length();
        int[] result = new int[len1 + len2]; // To store the intermediate products and sum

        // Multiply digits from right to left
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = (sb1.charAt(i) - '0') * (sb2.charAt(j) - '0');
                int sum = product + result[i + j + 1]; // Add the current product to any carry from previous step
                result[i + j + 1] = sum % 10; // Update current digit
                result[i + j] += sum / 10; // Update carry to next digit
            }
        }

        //make a string from int[]
        StringBuilder sb = new StringBuilder();
        for(int a : result)
        {
            sb.append(a);
        }

        // removing leading zeroes from the string builder
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0')
        {
            i++;
        }

        sb.delete(0 , i);


        if(sb.length() == 0) return "0";
        else
        {
            if((negative1 == false && negative2 == true) || (negative1 == true && negative2 == false) )
            {
                sb.insert(0 , '-');
            }
        }

        return sb.toString();
    }
}