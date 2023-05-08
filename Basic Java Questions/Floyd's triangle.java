import java.util.*;
public class Main
{
	public static void floyd(int n){
	    int count=1,i,j;
	    for(i=1;i<=n;i++){
	        for(j=1;j<=i;j++){
	            System.out.print(count+" ");
	            count++;
	        }
	          System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int e = s.nextInt();
		floyd(e);
	}
}
