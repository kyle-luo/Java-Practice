import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
    }

//    private static String big(String a, String b){
//        if(a.length() == b.length()) {
//            if(Integer.valueOf(a) > Integer.valueOf(b)) return a;
//            else return b;
//        }
//        else if(a.length() > b.length()) {
//
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

