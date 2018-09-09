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
	        count++;    //只要一个数不为0，则二进制表达中至少有一个1
	        num = num & (num-1);//没执行一次这条语句，其实就是使该数最低位的一个1置成0
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
