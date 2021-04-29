import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int N = in.nextInt();
        for (int i = 0; i < N; i++){
            arr.add(in.nextInt());
        }
        int number = in.nextInt();
        int index = in.nextInt() - 1;
        arr.add(index, number);
        for (int i = 0; i < arr.size() - 1; i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.print(arr.get(arr.size() - 1));
    }
}