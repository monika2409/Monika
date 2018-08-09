
public class TestA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Data types: int, double, char,boolean and String(String is class not a data types)
		   Above all are permeative data types
		 */
		int i = 12;
		int j = 10;
		
		String s = "Hello";
		String s1 = "World";
		
		double b = 12.23;
		double c = 10.34;
		
		boolean t = true;
		boolean f = false;
		
		
		System.out.println(i+j);
		System.out.println(i+j+s+s1);
		System.out.println(s+s1+i+j);
		System.out.println(s+s1+(i+j));
		System.out.println(i+j+s+s1);
		System.out.println(b+c+i+j+s+s1);
		System.out.println((b+c)+(i+j)+(s+s1));
		System.out.println((b+c)+i+j+(s+s1));
		System.out.println(b+c+i+j+(s+s1));
		System.out.println(s+s1+b+c+i+j);
		System.out.println(s+s1+(b+c)+(i+j));
		System.out.println(t+(s+s1)+b+c+(i+j));
		System.out.println((s+s1)+b+c+(i+j)+t);
		System.out.println(f+(s+s1)+b+c+(i+j));
		System.out.println((s+s1)+b+c+(i+j)+f);
		
	}

}

