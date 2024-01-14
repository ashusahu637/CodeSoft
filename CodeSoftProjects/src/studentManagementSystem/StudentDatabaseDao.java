package studentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDatabaseDao implements StudentInterface<Student, Integer>{

	@Override
	public void createNew(Student newStudent) {
		try (Connection con = JdbcUtilies.buildConnection();){
			String sqlQuery = "insert into student(studentId,studentName,rollNo,grade)values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sqlQuery);
			int id = newStudent.getStudentId();
			String name = newStudent.getStudentName();
			int roll = newStudent.getRollNo();
			String grade = newStudent.getGrade();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, roll);
			pstmt.setString(4, grade);
			int count = pstmt.executeUpdate();
			System.out.println(count +" record added");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Collection<Student> getAll() {
		Collection<Student> allStudent = new ArrayList<Student>();
		try (Connection con = JdbcUtilies.buildConnection();){
			Statement stmt = con.createStatement();
			
			String sqlQuery = "select studentId, studentName, rollNo, grade";
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int rollNo = rs.getInt(3);
				String grade = rs.getString(4);
				
				Student currentStudent = new Student(id,name,rollNo,grade);
				allStudent.add(currentStudent);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allStudent;
	}

	@Override
	public Student getOneById(Integer id) {
		Student foundStudent = null;
		try (Connection con = JdbcUtilies.buildConnection();){
			String sqlQuery = "select * from student where studentId = ?";
			PreparedStatement pstmt = con.prepareStatement(sqlQuery);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int studentId = rs.getInt(1);
				String name = rs.getString(2);
				int rollNo = rs.getInt(3);
				String grade = rs.getString(4);
				foundStudent = new Student(studentId,name,rollNo,grade);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundStudent;
	}

	@Override
	public void update(Student modifiedStudent) {
		
		try (Connection con = JdbcUtilies.buildConnection();){
			
			String sqlQuery = "update student set studentId=?,studentName=?,rollNo=?,grade=?";
			PreparedStatement pstmt = con.prepareStatement(sqlQuery);
			String name = modifiedStudent.getStudentName();
			int id = modifiedStudent.getStudentId();
			String grade = modifiedStudent.getGrade();
			int rollno = modifiedStudent.getRollNo();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, rollno);
			pstmt.setString(4, grade);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" recorde updated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void deleteById(Integer id) {
try (Connection con =  JdbcUtilies.buildConnection();){
	
	String sqlQuery = "delete from student where studentId=?";
	PreparedStatement pstmt = con.prepareStatement(sqlQuery);
	pstmt.setInt(1, id);
	int deleteCount = pstmt.executeUpdate();
	System.out.println(deleteCount+" record deleted");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}

	
}
