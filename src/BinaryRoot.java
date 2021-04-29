import java.util.Locale;
import java.util.Scanner;

public class BinaryRoot {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        double m;
        double l,r;
        /*    if(a > 0) {
                l = -Math.abs(d);
                r = Math.abs(d);
            }
            else {
            	r = 0;
            	l = -Math.abs(d);
            }
            */
        l = -Math.abs(d*d);
        r =  Math.abs(d*d);

        while(l<r) {
            m = (r+l)/2;
            if(a*m*m*m + b*m*m + c*m + d >=0) {
                if(a < 0) {
                    l = m;
                }
                else {
                    r = m;
                }
            }
            else {
                if(a < 0) {
                    r = m;
                }
                else {
                    l = m;
                }

            }
            if(r - l < Math.pow(10, -6)) {
                break;
            }

        }
        System.out.println(r);
    }
}