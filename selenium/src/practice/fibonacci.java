package practice;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int f=0, s=1;
		int next;
		
		for(int i=0;i<100;i++)
		{
			System.out.print(f+",");
			next = f+s;
			f=s;
			s=next;
		}
	}

}
