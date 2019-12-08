package org.launchcode.dismissal1.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class student {
    //@ID tells hibernate this is the primary key
    @Id
    //@Generate id for us
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String studentname;

    @NotNull
    private String teachername;

    @NotNull
    private String gradelevel;


    @ManyToOne
    private user user;

    public student(String studentname, String teachername, String gradelevel) {
        this.studentname = studentname;
        this.teachername=teachername;
        this.gradelevel=gradelevel;
    }

    public student() {

    }

    public int getId() {
        return id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getGradelevel() {
        return gradelevel;
    }

    public void setGradelevel(String gradelevel) {
        this.gradelevel = gradelevel;
    }
}
