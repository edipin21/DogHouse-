import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

//אדי אברמוב 307047655
public class Cage {

	public static final Double CAGE_WEIGTH = 100.0;
	public static final int NUM_DOGS_IN_CAGE = 4;
	private int id;
	boolean ifMale;
	private Dog[] cage;
	private static int counter = 0;
	private int numDogInCage = 0;
	private Double cageWeigte = 0.0;
	
	
	public Cage(Scanner scan) {
		cage = new Dog[NUM_DOGS_IN_CAGE];
		id=scan.nextInt();	
		numDogInCage=scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < numDogInCage; i++) {
			cage[i]=new Dog(scan);
			ifMale = ifMale || cage[i].getifMale();
			cageWeigte+=cage[i].getWeight();
			cage[i].setCageNum(id);		
		}
	
	
	}

	public Cage() {
		cage = new Dog[NUM_DOGS_IN_CAGE];
		id = ++counter;
	}

	public Cage(Cage other) {
		cage = new Dog[NUM_DOGS_IN_CAGE];
		for (int i = 0; i < cage.length; i++) {
			if (other.dogIndex(i) != null) {
				cage[i] = new Dog(other.dogIndex(i));
			}
		}
		id = other.id;
		numDogInCage = other.numDogInCage;
		cageWeigte = other.cageWeigte;
	}
	
	
	public Dog dogIndex(int i) {
		return cage[i];
	}

	public boolean idCheck(Dog dog1) {
		for (int i = 0; i < cage.length; i++) {

			if (cage[i] != null && dog1.getId() == cage[i].getId()) {

				return false;
			}
		}
		return true;

	}

	public int getDogPlaceById(Dog dog1) {
		for (int i = 0; i < cage.length; i++) {
			if (dog1.getId() == cage[i].getId() && dog1 != null) {
				return i;
			}
		}
		return -1;

	}
	
	private boolean isMale() {
		for (int i = 0; i < cage.length; i++) {
			if (cage[i] != null && cage[i].getifMale()) {
				return true;
			}
		}
		return false;
	}

	public boolean addDogToCage(Dog dog1) {

		if (dog1.getifMale() && isMale()) {
			return false;
		}
		if (numDogInCage == NUM_DOGS_IN_CAGE || cageWeigte + dog1.getWeight() >= CAGE_WEIGTH
				|| idCheck(dog1) == false) {
			return false;

		}
		for (int i = 0; i < cage.length; i++) {
			if (cage[i] == null) {
				dog1.setCageNum(id);
				cage[i] = new Dog(dog1);
				numDogInCage++;
				cageWeigte += dog1.getWeight();
				return true;
			}
		}
		return false;
	}
	
	

	public int getNumDogInCage() {
		return numDogInCage;
	}

	public boolean removeDog(Dog dog4) {
		int t = getDogPlaceById(dog4);
		if (t > -1) {
			cage[t] = null;
			numDogInCage--;
			cageWeigte -= dog4.getWeight();
			ifNull();
			return true;
		}
		return false;
	}

	public String toString() {
		String printcage;
		printcage = "In Cage " + id + " there are  " + numDogInCage + " dogs\n";
		for (int i = 0; i < cage.length; i++) {
			if (cage[i] != null) {
				printcage += cage[i].toString() + "\n";
			}
		}
		return printcage;
	}

	public Dog getDogById(int id) {
		for (int i = 0; i < cage.length; i++) {
			if (cage[i] != null && cage[i].getId() == id) {
				return cage[i];
			}
		}

		return null;

	}

	public int numdDogInCage() {
		return numDogInCage;
	}

	private void ifNull() {
		for (int i = 0; i < cage.length - 1; i++) {
			if (cage[i] == null && cage[i + 1] != null) {
				cage[i] = new Dog(cage[i + 1]);
				cage[i + 1] = null;
			}

		}

	}

	public Dog[] getCage() {
		return cage;
	}

	public int getId() {
		return id;
	}

	public void save(PrintWriter writer) {
		writer.println(id);
		writer.println(numdDogInCage());
		for (int i = 0; i < numDogInCage; i++) {
			cage[i].save(writer);
			
			
		}
		
		
	}

	public static void setCounter(int id2) {
		counter=id2;
	}
}