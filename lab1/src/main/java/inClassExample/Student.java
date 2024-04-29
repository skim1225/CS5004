package inClassExample;

public class Student {

    private String studentsName;
    private String studentsID;
    private String studentsEmail;
    private String major;
    private String minor;
    private Float currentGPA;

    public Student(String studentsName, String studentsID, String studentsEmail, String major, String minor, Float currentGPA) {
        this.studentsName = studentsName;
        this.studentsID = studentsID;
        this.studentsEmail = studentsEmail;
        this.major = major;
        this.minor = minor;
        this.currentGPA = currentGPA;
    }

    public String getStudentsName() {
        return this.studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public String getStudentsID() {
        return this.studentsID;
    }

    public void setStudentsID(String studentsID) {
        this.studentsID = studentsID;
    }

    public String getStudentsEmail() {
        return this.studentsEmail;
    }

    public void setStudentsEmail(String studentsEmail) {
        this.studentsEmail = studentsEmail;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return this.minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public Float getCurrentGPA() {
        return this.currentGPA;
    }

    public void setCurrentGPA(Float currentGPA) {
        this.currentGPA = currentGPA;
    }



    public void displayStudentInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentsName='" + studentsName + '\'' +
                ", studentsID='" + studentsID + '\'' +
                ", studentsEmail='" + studentsEmail + '\'' +
                ", major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                ", currentGPA=" + currentGPA +
                '}';
    }
}
