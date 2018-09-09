package KeyS;

import java.util.Scanner;

public class test {
	 public static void main(String[] args) {

	       System.out.println("请输入一个不大于5位数的数字：");

	       Scanner scanner=new Scanner(System.in);

	       int num=scanner.nextInt();//获取输入

	       int[] arr=new int[5];//创建5位数的数组

	       int i=0;

	       //循环取位

	       do{     

	            arr[i]=num%10;
                System.out.println("----------"+arr[i]);
	            num=num/10;
	            System.out.println("###########"+num);
	            i++;

	       }while (num!=0);//只剩下一位时，说明获取完毕，跳出循环

	       System.out.println("输入数字串的是"+i+"位数的");

	       System.out.println("逆序输出：");

	       //打印出数组

	       for (int j = 0; j < i;j++) {

	           System.out.print(arr[j]+"  ");

	       }

	       scanner.close();

	    }
	 
}
