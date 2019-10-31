package room.database.volunteer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import room.database.utils.DatabaseHelper;

@Entity(tableName = DatabaseHelper.VOLUNTEER_TABLE)//by default table name is in app name
public class Volunteer {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String volunteerName;

    private String dept;

    private String campus;

    private String studentid;

    private String mail;

    private String mobileNumber;

    public Volunteer(String volunteerName, String dept, String campus, String studentid, String mail, String mobileNumber) {
        this.volunteerName = volunteerName;
        this.dept = dept;
        this.campus = campus;
        this.studentid = studentid;
        this.mail = mail;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public String getDept() {
        return dept;
    }

    public String getCampus() {
        return campus;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getMail() {
        return mail;
    }
}
