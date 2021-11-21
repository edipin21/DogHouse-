
public class ReeClass {

	public static boolean isTheSame(String str) {
		if (str.length() == 1) {
			return true;
		}

		if (str.charAt(0) == str.charAt(str.length() - 1)) {

			return isTheSame(str.substring(1));
		}

		return false;

	}

	public static int numOfMod3(int[] arr, int size) {

		if (size == 0) {
			if (arr[size]%3==0) {

				return 1;
			}
				else { 
					return 0;
				}
				
		}
		if (arr[size - 1] % 3 == 0) {
			 
			 return 1+ numOfMod3(arr, size-1 );
		}
		
		return numOfMod3(arr, size-1);
	}

	
	
	private static void subGroup(int n,String str) {
		if(n==0) {
			System.out.println("{"+str+"}");
			return;
		
		}
		
		 subGroup(n-1, str+n);
		
		 subGroup(n-1, str);
		 return;
		
	}
	public static void main(String[] args) {
		subGroup(150);
	}

	private static void subGroup(int n) {
		String str="";
		subGroup(n,str);
		
	}
	
	
	
	
	
	
	
	
		
		
		
		
	}


