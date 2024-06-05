package hyrDay_1_27032024;

public class stringbuffer {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Sharath");
		StringBuffer sb2 = new StringBuffer("Sharath");
		System.out.println(sb1==sb2);
		
		sb1 = sb1.append(" kumar");
		System.out.println(sb1);

	}

}
