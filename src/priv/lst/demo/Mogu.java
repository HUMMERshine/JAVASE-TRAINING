package priv.lst.demo;

import java.util.Scanner;

public class Mogu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int [] array = new int [12];
		for(int i = 1; i < 12; i++){
			int num = 30;
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
				num = 31;
			}else if(i == 2){
				num = 28;
			}
			array[i] = array[i-1] + num;
		}
		while(scanner.hasNext()){
			int year = scanner.nextInt();
			int month = scanner.nextInt();
			int day = scanner.nextInt();
			
			if(year % 4 == 0 && year / 100 != 0 || year % 400 == 0){
				array[2]++;
				System.out.println(array[month - 1] + day);
				array[2]--;
			}else{
				System.out.println(array[month - 1] + day);
			}
		}
	}

}