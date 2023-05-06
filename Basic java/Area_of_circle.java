import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Enter value of radious");
		Scanner s = new Scanner(System.in);
		float r = s.nextFloat();
		float area = 3.14f*r*r;
		System.out.print(area);
	}
}
