

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ids = new int[] { 13, 23, 33, 43 };
		//int[] ids = new int[4];
		
		System.out.println(ids.length);
		
		/* Add value for each index 
		for (int i = 0; i < ids.length; i++)
		{
			ids[i] = i + 10;
		}
		*/
		for (int i = 0; i < ids.length; i++)
		{
			System.out.println(ids[i]);
		}	
		
		int[] test = ids.clone();
		
		for (int i = 0; i < test.length; i++)
		{
			System.out.println(test[i]);
		}	
		
	}
}
