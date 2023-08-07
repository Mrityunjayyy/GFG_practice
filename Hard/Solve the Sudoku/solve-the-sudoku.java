//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        return solve(grid);
    }
    
    static boolean solve(int[][] a )
    {
        for(int i = 0 ; i < a.length ; i++)
        {
            for(int j = 0 ; j < a[0].length ; j++)
            {
                if(a[i][j] == 0)
                {
                    for(int m = 1 ; m <= 9 ; m++)
                    {
                        if(isValid(a, i , j , m))
                        {
                            a[i][j] = m;
                            
                            if(solve(a) == true)
                            return true;
                            
                            else 
                            a[i][j] = 0;
                        }
                    }
                    return false;
                }
               
            }
        }
        
        return true;
    }
    
    
    
    static boolean isValid(int[][] a , int row , int col , int m)
    {
        for(int i = 0 ; i < 9 ; i++)
        {
            if (a[row][i] == m) return false;
        
            if (a[i][col] == m) return false;
            
            int nrow = 3 * (row/3) + (i/3);
            int ncol = 3 * (col/3) + (i%3);
            
            if(a[nrow][ncol] == m) return false;
        }
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int[] a : grid)
        {
            for(int b : a)
            {
                System.out.print(b  + " ");
            }
        }
    }
}