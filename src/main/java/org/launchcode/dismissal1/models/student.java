package org.launchcode.dismissal1.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Size(min = 3, max = 15)
    private String studentname;

    @NotNull
    @Size(min = 1, message= "Select a teacher.")
    private String teachername;

    @NotNull
    @Size(min = 1, message= "Choose your child's grade level.")
    private int gradelevel;

    //@ManyToOne
    //private User user;

    public student(String studentname, String teachername, int gradelevel) {
        this.studentname = studentname;
        this.teachername=teachername;
        this.gradelevel=gradelevel;
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

    public int getGradelevel() {
        return gradelevel;
    }

    public void setGradelevel(int gradelevel) {
        this.gradelevel = gradelevel;
    }
}
