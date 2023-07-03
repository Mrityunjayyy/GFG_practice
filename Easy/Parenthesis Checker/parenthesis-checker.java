//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution 
{   
    // pw skills -- stack question
    //for each loop use
    
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        Stack<Character> stack1 = new Stack<Character>();
      char[] chars = x.toCharArray();
      for(char c : chars)
      { 
          if(c == '{' || c == '[' || c == '(')
          { 
              //continue lagana zaruri hai taaki pehle sirf open brackets se fill ho jaye
              stack1.push(c);
              continue;
          }
          
          //upar wali statement ke baad koi empty bracket nahi mila return false
          else if(stack1.empty())
          return false;
          
         
          char top = stack1.pop(); //stack a pehla element remove 
          
          if(top == '(' && c != ')')
          return false;
          
          else if(top == '{' && c != '}')
          return false;
          
          else if(top == '[' && c != ']')
          return false;
      }
        
        //agar pura khali ho gya to har bracker ka pair bankar nikal gya
        return stack1.empty();
    }
}
