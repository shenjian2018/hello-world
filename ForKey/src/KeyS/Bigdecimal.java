package KeyS;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Bigdecimal {
	
	
	 public static double div(double value1,double value2,int scale) throws IllegalAccessException{
		          //�����ȷ��ΧС��0���׳��쳣��Ϣ
		          if(scale<0){         
		              throw new IllegalAccessException("��ȷ�Ȳ���С��0");
		         }
		          BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		          BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		          return b1.divide(b2, scale).doubleValue();    
		   }
	 
	   public static void main(String[] args) {
                Double  v1=114545454545454545.12d;
                Double  v2=42.0d;
                System.out.println(v1);
                try {
                	   DecimalFormat dec = new DecimalFormat("#,##0.00");// ��ʽ������  
					div(v1,v2,2);
					System.out.println(dec.format(div(v1,v2,2)));
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 }  

}
