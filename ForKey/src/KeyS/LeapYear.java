package KeyS;

public class LeapYear {
	public static Boolean isLeapYear(int y) {
		if ((y / 4 == 0 && y / 100 != 0)||y % 400 == 0) {
			return true;
		}
		return false;
	}
	public static Boolean isLeapYear1(int y) {
		return (y / 4 == 0 && y / 100 != 0)||y % 400 == 0?true:false;
			
		
	}

	
	public int count_one_bit(int num)
	{
	    int count = 0;
	    while(num!=0)
	    {
	        count++;    //ֻҪһ������Ϊ0��������Ʊ����������һ��1
	        num = num & (num-1);//ûִ��һ��������䣬��ʵ����ʹ�������λ��һ��1�ó�0
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		Boolean leapYear = isLeapYear(400);
		System.out.println("leapYear:"+leapYear);
		Boolean leapYear1 = isLeapYear1(400);
		System.out.println("leapYear1:"+leapYear1);
	}
}
