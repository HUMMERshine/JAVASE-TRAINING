package priv.lst.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] array = new int[n];
		int i = 0;
		int sum = 0;
		while (i < n) {
			array[i] = scanner.nextInt();
			sum += array[i];
			i++;
		}

		int left = 0, right = n - 1;
		while (left < right) {
			if (array[left] == array[right]) {
				left++;
				right--;
			} else if (array[left] < array[right]) {
				sum += array[left];
				left++;
			} else {
				sum += array[right];
				right--;
			}
		}

		System.out.println(sum);
	}

}