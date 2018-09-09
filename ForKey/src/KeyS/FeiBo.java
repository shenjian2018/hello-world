package KeyS;

public class FeiBo{
    public static void main(String[] args) {
        int num1=0;
        int num2=1;
        int numn=1;
        int n=10;
        for (int i = 3; i <=n; i++) {
            numn=num1+num2;
            num1=num2;
            num2=numn;
        }
        System.err.println(n+"个数的结果为："+numn);
    }
}