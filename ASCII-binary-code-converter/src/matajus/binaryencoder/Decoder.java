package matajus.binaryencoder;

public class Decoder {
	public static String decode(String text) {
		String result = "";
		String[] bits = text.split(" ");
		for(int i = 0; i < bits.length; i++) {
			int sum = 0;
			char[] digits = bits[i].toCharArray();
			for(int j = digits.length-1; j >= 0; j--) {
				if(Character.getNumericValue(digits[j]) == 1) {
					sum += Driver.mapping[j];
				}
 			}
			if(sum < 33) result += " ";
			else result += Driver.charset[sum-33];
		} 
		return result;
	}
}
