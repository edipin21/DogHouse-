import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DogHouse {
	final int MAX_CAGES = 20;
	private Cage[] pension;
	private int numOfCages;
	final double PRICE_FOR_KG = 0.8;
	private String pensionName;
	private int counter = 0;
	private int numDogsInpension;
	private Dog[] numDogs = new Dog[MAX_CAGES * Cage.NUM_DOGS_IN_CAGE];

	public DogHouse() {

		pension = new Cage[MAX_CAGES];
		pensionName = "default";
		numDogsInpension = counter;
	}

	public DogHouse(String pensionName) {
		pension = new Cage[MAX_CAGES];
		this.pensionName = pensionName;
		numDogsInpension = counter;
	}

	public boolean addDog(Dog dog) {
		for (int i = 0; i < pension.length; i++) {
			if (pension[i] == null) {
				pension[i] = new Cage();
			}
			if (pension[i].addDogToCage(dog) == true) {
				pension[i].addDogToCage(dog);
				numDogs[counter] = new Dog(dog);
				counter++;
				return true;
			}

		}
		return false;
	}

	public int outDog(int id, MyDate d1) {
		boolean removed = false;
		Dog dog = null;
		int days = 0;
		for (int i = 0; i < pension.length; i++) {
			if (pension[i] != null) {
				dog = pension[i].getDogById(id);
				if (dog != null) {
					removed = pension[i].removeDog(dog);
					ifNullCages();
					DogIsnull(id);
					counter--;
					days = dog.getDate().daysCount(d1);
				}
			}
			if (removed) {
				if (pension[i].getNumDogInCage() == 0) {
					pension[i] = null;
					ifNullCages();
				}
				return days;
			}

		}
		return -1;
	}

	public void DogIsnull(int id) {
		for (int i = 0; i < numDogs.length; i++) {
			if (numDogs[i] != null && numDogs[i].getId() == id) {
				numDogs[i] = null;
			}
		}
		for (int i = 0; i < numDogs.length - 1; i++) {
			if (numDogs[i] == null && numDogs[i + 1] != null) {
				numDogs[i] = new Dog(numDogs[i + 1]);
				numDogs[i + 1] = null;
			}
		}
	}

	public void ifNullCages() {
		for (int i = 0; i < pension.length - 1; i++) {
			if (pension[i] == null && pension[i + 1] != null) {
				pension[i] = new Cage(pension[i + 1]);
				pension[i + 1] = null;

			}
		}
	}

	public int getDogsCount() {

		return counter;
	}

	public int getCagesCount() {
		int count = 0;

		for (int i = 0; i < pension.length; i++) {
			if (pension[i] != null) {
				count++;

			}

		}

		return count;
	}

	public void makePriceStatment(Dog dog, int days) {

		double totalPrice;
		double tempPrice = (PRICE_FOR_KG * dog.getWeight());
		if (tempPrice < 30.0) {
			tempPrice = 30.0;

		}
		totalPrice = tempPrice * days;
		System.out.println("need to pay " + totalPrice + " IS");
	}

	public void save(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		PrintWriter pw = new PrintWriter(f);
		pw.println(pensionName);
		pw.println(Dog.getCounter());
		pw.println(numOfCages);
		for (int i = 0; i < numOfCages; i++) {
			pension[i].save(pw);

		}
		pw.close();
	}

	public DogHouse(Scanner scan) throws FileNotFoundException {
		pension = new Cage[MAX_CAGES];
		pensionName = scan.nextLine();
		Dog.setCounter(scan.nextInt());
		setNumOfCages(scan.nextInt());

		for (int i = 0; i < numOfCages; i++) {
			pension[i] = new Cage(scan);

		}
		for (int i = 0; i < numOfCages; i++) {
			for (int j = 0; j < pension[i].getNumDogInCage(); j++) {
				
			
			numDogs[numDogsInpension]=new Dog(pension[i].dogIndex(j));
			numDogsInpension++;
			}
		
		}
		Cage.setCounter(pension[numOfCages - 1].getId() + 1);
	}

	public void setNumOfCages(int numOfCages) {
		this.numOfCages = numOfCages;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String toString() {
		String printPension;
		printPension = "In house " + pensionName + " there are " + numDogsInpension+ " dogs\n";
		for (int i = 0; i < numDogs.length; i++) {
			if (numDogs[i] != null) {
				printPension += numDogs[i].toString() + "\n";
			}
		}

		for (int i = 0; i < pension.length; i++) {
			if (pension[i] != null) {

				printPension += pension[i].toString();
			}

		}
		return printPension;
	}

}
