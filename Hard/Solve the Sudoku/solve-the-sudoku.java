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
        for(int i = 0 ; i < grid.length ; i++)
        { 
            for(int j = 0 ; j < grid[0].length ; j++)
            { 
                if(grid[i][j] == 0)
                { 
                    for(int x = 1  ; x <= 9 ;x++)
                    { 
                        if(isValid(grid , i , j , x))
                        { 
                            grid[i][j] =  x;
                            
                            if(SolveSudoku(grid) == true)
                            return true;
                            
                            else
                            grid[i][j] = 0;
                        }
                    }
                    
                    // 1-9 kuch bi nahi rakh paya pehla number galat rakh dia tha 
                    return false;
                }
            }
        }
        
        //No empty block found full maze solved;
        return true;
    }
    

    
    
    public static boolean isValid(int[][] board , int row , int column , int x)
    {  
        // 9 row check , 9 column check and 3*3 inner matrix check
        for(int i = 0 ; i < 9 ; i++)
        { 
            
            if(board[row][i] == x) return false;
            
            if(board[i][column] == x) return false;
            
            int m = 3* (row/3) + i/3;
            int n = 3 * (column/3) + i%3;
            
            if(board[m][n] == x) return false;
        }
        
        
        return true;
        
    }
    

    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
       for(int a[] : grid)
       { 
           for(int b : a)
           {
               System.out.print(b + " ");
           }
       }
    }
}