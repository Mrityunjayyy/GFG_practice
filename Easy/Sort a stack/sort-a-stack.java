//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		sorting(s);
		return s;
	}
	
	public void sorting(Stack<Integer> stack)
	{
	    if(stack.size() == 1)
	    return;
	    
	    
	    int temp = stack.pop();
	    sorting(stack);
	    insert(stack , temp);
	}
	
	public void insert(Stack<Integer> stack , int temp)
	{
	    if(stack.empty() || stack.peek() < temp)
	    {
	        stack.push(temp);
	        return;
	    }
	    
	    int val = stack.pop();
	    insert(stack , temp);
	    stack.push(val);
	}
}