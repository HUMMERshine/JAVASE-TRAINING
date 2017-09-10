import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i <= n - 1; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i <= n - 1; i++) {
            long value1 = 0, value2 = 0;
            int sep = array[i];
            int value1_pre = -1, value2_pre = -1;
            for (int num : array) {
                if (num <= sep) {
                    if (value1_pre == -1) {
                        value1_pre = num;
                    } else {
                        value1 += Math.abs(num - value1_pre);
                        value1_pre = num;
                    }
                } else {
                    if (value2_pre == -1) {
                        value2_pre = num;
                    } else {
                        value2 += Math.abs(num - value2_pre);
                        value2_pre = num;
                    }
                }
            }
            min = Math.min(value1 + value2, min);
        }

        System.out.println(min);
    }


}