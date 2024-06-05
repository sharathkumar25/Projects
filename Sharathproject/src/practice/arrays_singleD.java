package practice;

import java.util.Arrays;
import java.util.Scanner;

public class arrays_singleD {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the size");
		int arrsize = scan.nextInt();
		int[] a = new int[arrsize];
		System.out.println("Please enter the values");
		for(int i=0;i<arrsize;i++) {
			a[i]=scan.nextInt();
		}
		System.out.println("Input :"+Arrays.toString(a));
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		System.out.println("output: "+sum/a.length);
		
		scan.close();

	}

}
