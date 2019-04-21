package matajus.binaryencoder;

public class Encoder {
	public static String encode(String text) {
		String result = " ";
		String [] words = text.split(" ");
		int index = 0;
		for(int i = 0; i < words.length; i++) {
			if(i < words.length-1) {
				words[i] += " ";
			}
			for(int j = 0; j < words[i].length(); j++) {
				if(words[i].charAt(j) == ' ') {
					index  = 0;
				}
				else {
					for(int k = 0; k < Driver.charset.length; k++) {
						if(words[i].charAt(j) == Driver.charset[k]) {
							index = k + 34;
						}
					}
				}
				for(int k = 0; k < 8; k++) {
					if(index > Driver.mapping[k]) {
						result += "1";
						index -= Driver.mapping[k];
					}
					else {
						result += "0";
					}
				}
				result += " ";
			}
		}
		return result;
	}
}
