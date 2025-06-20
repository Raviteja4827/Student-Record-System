package student_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolOperations{
	//Add Students
    public static void addStudent(Student s) {
        try {
            Connection con = StudentDBConnection.getConnection();
            String query = "INSERT INTO students (roll_number, name, age, branch, marks, grade, parent_mobile) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, s.getRollNumber());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getBranch());
            ps.setDouble(5, s.getMarks());
            ps.setString(6, s.getGrade());
            ps.setLong(7, s.getParentsMobileNo());
            
            ps.executeUpdate();
            System.out.println("Student inserted into DataBase Successfully✅");
            con.close();
        } catch (Exception e) {
            System.err.println("❌ Error: Student Data Not Inserted Into Data Base");
        }
    }
    //Get All Student Data
    public static void getAllStudents() {
        try {
            Connection con = StudentDBConnection.getConnection();
            String query = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("\n------ Student Details ------");
                System.out.println("Roll Number: " + rs.getInt("roll_number"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Branch: " + rs.getString("branch"));
                System.out.println("Marks: " + rs.getDouble("marks"));
                System.out.println("Grade: " + rs.getString("grade"));
                System.out.println("Parent Mobile: " + rs.getLong("parent_mobile"));
            }

            if (!found) {
                System.out.println("🫙 No student records found in the database.");
            }

            con.close();
        } catch (Exception e) {
            System.err.println("❌ Error fetching students: " + e.getMessage());
        }
    }
    
    //Search By Student Name 
    public static void searchStudentByName(String name) {
        try {
            Connection con = StudentDBConnection.getConnection();
            String query = "SELECT * FROM students WHERE name = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("\n✅ Student Found:");
                System.out.println("Roll Number: " + rs.getInt("roll_number"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Branch: " + rs.getString("branch"));
                System.out.println("Marks: " + rs.getDouble("marks"));
                System.out.println("Grade: " + rs.getString("grade"));
                System.out.println("Parent Mobile: " + rs.getLong("parent_mobile"));
            }

            if (!found) {
                System.err.println("❌ No student found with name: " + name);
            }

            con.close();
        } catch (Exception e) {
            System.err.println("❌ Error searching student: " + e.getMessage());
        }
    }
    //Update Mobile Number Using Student Roll Number
    public static void updateMobileNumberByRoll(int rollNumber,long newNumber) {
    	try {
			Connection conn=StudentDBConnection.getConnection();
			String query="UPDATE students SET parent_mobile=? WHERE roll_number =?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setLong(1,newNumber);
			ps.setInt(2, rollNumber);
			int rowsUpdated=ps.executeUpdate();
			if(rowsUpdated>0) {
                System.out.println("✅ Mobile Number updated successfully!");
			}
			else {
                System.err.println("❌ Roll number not found. Update failed.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error Updating Mobile Number");
		}
    }
    //Update By Student Name By RollNumber
    public static void updateStudentNameByRoll(int rollNumber, String newName) {
        try {
            Connection con = StudentDBConnection.getConnection();
            String query = "UPDATE students SET name = ? WHERE roll_number = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, rollNumber);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("✅ Student name updated successfully!");
            } else {
                System.err.println("❌ Roll number not found. Update failed.");
            }

            con.close();
        } catch (Exception e) {
            System.err.println("❌ Error updating student name: " + e.getMessage());
        }
    }
    //Delete Student Details By RollNumber
    public static void deleteStudentByRoll(int rollNumber) {
        try {
            Connection con = StudentDBConnection.getConnection();
            String query = "DELETE FROM students WHERE roll_number = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rollNumber);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("✅ Student deleted successfully!");
            } else {
                System.err.println("❌ Roll number not found. Delete failed.");
            }

            con.close();
        } catch (Exception e) {
            System.err.println("❌ Error deleting student: " + e.getMessage());
        }
    }
    //Search By Student By Student RollNumber
    public static void searchStudentByRollNumber(int rollNumber) {
        try {
            Connection con = StudentDBConnection.getConnection();
            String query = "SELECT * FROM students WHERE roll_number = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rollNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n✅ Student Found:");
                System.out.println("Roll Number: " + rs.getInt("roll_number"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Branch: " + rs.getString("branch"));
                System.out.println("Marks: " + rs.getDouble("marks"));
                System.out.println("Grade: " + rs.getString("grade"));
                System.out.println("Parent Mobile: " + rs.getLong("parent_mobile"));
            } else {
                System.err.println("❌ No student found with roll number: " + rollNumber);
            }

            con.close();
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }

}
