package student_management_system;

import java.util.Scanner;

public class SchoolMainClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean start = true;
        while (start) {
            System.out.println("\n========== School Management Menu ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student By Name");
            System.out.println("4. Search Student By Roll Number");
            System.out.println("5. Update Student Name By Roll Number");
            System.out.println("6. Remove Student By Roll Number");
            System.out.println("7. Update Mobile Number By Roll Number");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("Enter Student Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scan.nextInt();
                    scan.nextLine(); 
                    System.out.print("Enter Branch: ");
                    String branch = scan.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scan.nextLine();
                    System.out.print("Enter Parent's Mobile Number: ");
                    long mobile = scan.nextLong();
                    Student s = new Student(name, age, branch, marks, grade, mobile);
                    SchoolOperations.addStudent(s);
                    break;
                }
                case 2: {
                	SchoolOperations.getAllStudents();
                    break;
                }
                case 3: {
                    System.out.print("Enter Student Name to Search: ");
                    String searchName = scan.nextLine();
                    SchoolOperations.searchStudentByName(searchName);
                    break;
                }
                case 4: {
                    System.out.print("Enter Roll Number to Search: ");
                    int roll = scan.nextInt();
                    SchoolOperations.searchStudentByRollNumber(roll);
                    break;
                }
                case 5: {
                    System.out.print("Enter Roll Number to Update: ");
                    int roll = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scan.nextLine();
                    SchoolOperations.updateStudentNameByRoll(roll, newName);
                    break;
                }
                case 6: {
                    System.out.print("Enter Roll Number to Delete: ");
                    int roll = scan.nextInt();
                    SchoolOperations.deleteStudentByRoll(roll);
                    break;
                }
                case 7:{
                	System.out.print("Enter Roll Number to Update MobileNo: ");
                    int roll = scan.nextInt();
                	System.out.println("Enter New Mobile Number :");
                	long mobile=scan.nextInt();
                	SchoolOperations.updateMobileNumberByRoll(roll, mobile);
                	break;
                }
                case 8: {
                    System.out.println("🙏 Thank you for using School Management System!");
                    start = false;
                    break;
                }
                default:
                    System.err.println("⚠️ Invalid Choice! Please try again.");
            }
        }
    }
}
