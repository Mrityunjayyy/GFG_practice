//{ Driver Code Starts
import java.util.*;


class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queue g = new Queue();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.enqueue(a);
				}
				else if(QueryType == 2)
				System.out.print(g.dequeue()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}


// } Driver Code Ends


class Queue
{
    Stack<Integer> input = new Stack<Integer>(); 
    Stack<Integer> output = new Stack<Integer>(); 
    
    /*The method pop which return the element poped out of the stack*/
    int dequeue()
    {
        int ele ;
        
        // for this question testcases the stack will always be non empty.
        //check if stack is empty
        if(input.empty() && output.empty())
        return -1;
        
	    if(output.empty())
	    {  
	        while(!input.empty())
	        {  
	            //stack1 ke elements stack2 mai bhar diye ulte karke
	            ele = input.pop();
	            output.push(ele);
	        }
	    }
	    
	    // queue is FIFO pop will give the top element of stack2 i.e last element of stack1
	    ele  = output.pop();
	    return ele; 
	    //here ele is is top of stack to  implement FIFO using LIFO.
    }
	
    /* The method push to push element into the stack */
    void enqueue(int x)
    {
	   input.push(x);
    }
}

