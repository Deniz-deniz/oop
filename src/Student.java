public class Student extends Person {
    private String studentNa;
    private String department;
    private int stuID;


    //Polymorphism
    public Student(String firstName,String lastName,String userID) {
        super(firstName, lastName, userID);


    }

    public Student() {
        super("deniz","ilkiz","0002");
    }

    public String getStudentNa() {
        return studentNa;
    }

    public void setStudentNa(String studentNa) {
        this.studentNa = studentNa;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }
}


