package hyrDay_1_27032024;

public class multiD_array {

	public static void main(String[] args) {
		int[][] a = new int[3][2];
		a[0][0]= 1;
		a[0][1]= 2;
		a[1][0]= 3;
		a[1][1]= 4;
		a[2][0]= 5;
		a[2][1]= 6;
		
		for(int i=0;i<a.length;i++) {
			int[] Norows = a[i];
			for(int j=0;j<Norows.length;j++) {
				System.out.print(Norows[j]+" ");
			}
			System.out.println();
		}

	}

}
