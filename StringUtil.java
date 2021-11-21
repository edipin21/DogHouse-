
public class StringUtil {

	private static boolean getFirstLettersHelper(String str, char c) {
		c = Character.toUpperCase(c);
		str = str.toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				return false;
			}
		}
		return true;
	}

	public static String getFirstLetters(String str) {
		String str2 = "";
		String[] FirstL = str.split(" ");
		for (int i = 0; i < FirstL.length; i++) {
			if (getFirstLettersHelper(str2, FirstL[i].charAt(0))) {
				str2 += FirstL[i].charAt(0);

			}

		}
		return str2;

	}

	public static boolean isOnlyLetters(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			if(Character.isAlphabetic(str.charAt(i))!=true) {
				return false;
			}
		}
			return true;	
			
	
	
	}
		
	
	
	
	
	
	public static void main(String[] args) {
		String str="edi pin efefn frg ";
		System.out.println(getFirstLetters(str));
		
				
		
	}

	
	
	
}
