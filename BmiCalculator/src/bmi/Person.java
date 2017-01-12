package bmi;

public class Person {
	
	private String firstname;
	private String lastname;
	private double weight;
	private double size;
	private Gender gender;
	
	/*
	 * Constructors
	 */
	
	public Person() {}
	
	public Person(String firstname,String lastname,double weight,double size,Gender gender) {
		setFirstname(firstname);
		setLastname(lastname);
		setWeight(weight);
		setSize(size);
		setGender(gender);
	}

	/*
	 * Getters and setters
	 */
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public double getWeight() {
		return weight;
	}

	public double getSize() {
		return size;
	}

	public Gender getGender() {
		return gender;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/*
	 * Methods
	 */
	
	public double computeIMC() {
		return weight/size/size;
	}
	
	public String diagnosys() {
		
		double IMC = computeIMC();
		
		if(IMC < 17) return "Anorexy";
		else if(IMC < 19) return "Underweight";
		else if(IMC < 25) return "Normal";
		else if(IMC < 30) return "Overweight";
		return "Obesity";
	}
	
	private double squareSizeOf(double a) {
		return a*size*size;
	}
	
	public double computeMinWeight() {
		return squareSizeOf(19);
	}

	public double computeMaxWeight() {
		return squareSizeOf(25);
	}

	public double computeIdealWeight() {
		if(gender==Gender.M) return squareSizeOf(22);
		return squareSizeOf(21);
	}
	

}
