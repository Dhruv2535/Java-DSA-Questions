import java.util.*;
public class Main
{
    public static int fact(int n)
    {
        int fact=1;
        for(int i=1;i<=n;i++)
        {
            fact=fact*i;
        }
    return fact;
    }
    
    
    
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter the number");
	    int x = s.nextInt();
	 
	    System.out.print(fact(x));
		
	}
}

