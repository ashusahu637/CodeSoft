package studentManagementSystemTask5;

public class Student {
	
	private int studentId;
	
	private String studentName;
	
	private int rollNo;
	
	private String grade;

	public Student(int studentId, String studentName, int rollNo, String grade) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.grade = grade;
	}

	public Student() {
		super();
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", rollNo=" + rollNo + ", grade="
				+ grade + "]";
	}
	
	
}
