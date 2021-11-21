import java.io.PrintWriter;
import java.util.Scanner;
public class Dog {

	private int weight, cageNum, id;
	private String name;
	private MyDate date;
	private boolean ifMale;

	public enum dogtype {
		Poodle, Wolf, Pitbull, Malinois
	};

	private dogtype type;
	private static int counter = 99;

	public Dog(int weight, boolean ifmale, MyDate date, String name, dogtype type) {
		setWeight(weight);
		setName(name);
		this.ifMale = ifmale;
		this.date = date;
		this.type = type;
		id = ++counter;

	}

	public Dog(Dog other) {
		ifMale = other.ifMale;
		date = other.date;
		name = other.name;
		type = other.type;
		id = other.id;
		weight = other.weight;
		cageNum = other.cageNum;
	}

	public Dog(Scanner scan) {
		String[] dogiDog = scan.nextLine().split(", ");

		date = new MyDate(scan);
		name = dogiDog[0];
		weight = Integer.parseInt(dogiDog[1]);
		ifMale = Boolean.parseBoolean(dogiDog[2]);
		type = dogtype.valueOf(dogiDog[3]);
		id = Integer.parseInt(dogiDog[4]);

	}

	public void setName(String name) {
		if (name.length() < 8 && StringUtil.isOnlyLetters(name) == true
				&& Character.isUpperCase(name.charAt(0)) == true) {
			this.name = name;
		} else
			this.name = "TheD";
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Dog.counter = counter;
	}

	public void setCageNum(int cage) {
		this.cageNum = cage;
	}

	public void setWeight(int weight) {
		if (weight < 5) {
			this.weight = 5;

		} else
			this.weight = weight;
	}

	public MyDate getDate() {
		return date;
	}

	public dogtype getType() {
		return type;
	}

	public void setIfMale(boolean f) {
		if (f == true) {
			this.ifMale = true;

		} else
			this.ifMale = false;
	}

	public boolean getifMale() {
		return ifMale;
	}

	public int getWeight() {
		return weight;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		String printdog, gender;
		if (ifMale == true) {
			gender = "Male";
		} else
			gender = "female";

		printdog = "Dog id " + id + " " + name + " of type " + type + " weight " + weight + " " + gender
				+ " enter to dog house on " + date.toString() + " is in cage number " + cageNum;
		return printdog;
	}

	public void save(PrintWriter writer) {
		writer.print(name + " ,");
		writer.print(weight + " ,");
		writer.print(ifMale + " ,");
		writer.print(type + " ,");
		writer.println(id + " ");
		date.save(writer);

	}

}
