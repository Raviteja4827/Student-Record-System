package student_management_system;

import java.util.ArrayList;
import java.util.Random;

public class Student {
	private String name;
	private int rollNumber;
	private int age;
	private String branch;
	private double marks;
	private String grade;
	private long parentsMobileNo;
	private static Random random=new Random();
    private static ArrayList<Integer> usedRollNumbers = new ArrayList<Integer>();
	
	//defalut Constructor
	public Student() {}
	
	//intialize properties using Constructor
	public Student(String name,int age, String branch, double marks, String grade,
			long parentsMobileNo) {
		this.name = name;
		this.rollNumber = generateUniqueRollNumber();
		this.age = age;
		this.branch = branch;
		this.marks = marks;
		this.grade = grade;
		this.parentsMobileNo = parentsMobileNo;
	}
	private int generateUniqueRollNumber() {
        int num;
        do {
            num = random.nextInt(1000,9999); 
        } while (usedRollNumbers.contains(num)); // regenerate already number their in arraylist

        usedRollNumbers.add(num);
        return num;
    }
	//Getters And Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getParentsMobileNo() {
		return parentsMobileNo;
	}

	public void setParentsMobileNo(long parentsMobileNo) {
		this.parentsMobileNo = parentsMobileNo;
	}  

	public int getRollNumber() {
		return rollNumber;
	}
	
	@Override
	public String toString() {
	    return "\n--- Student Details ---" +
	           "\nName: " + name +
	           "\nRoll Number: " + rollNumber+
	           "\nAge: " + age +
	           "\nBranch: " + branch +
	           "\nMarks: " + marks +
	           "\nGrade: " + grade +
	           "\nParent's Mobile No: " + parentsMobileNo;
	}
}
