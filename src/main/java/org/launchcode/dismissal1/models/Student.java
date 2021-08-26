package org.launchcode.dismissal1.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
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

    @NotNull
    private String transportationMode;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   @ManyToOne
    private User user;

    @OneToMany
    @JoinColumn(name ="student_id")
    private List<Changetransportation> changetransportations = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="student_id")
    private List<Early> earlys= new ArrayList<>();


    public Student(String studentname, String teachername, String gradelevel, String transportationMode) {
        this.studentname = studentname;
        this.teachername=teachername;
        this.gradelevel=gradelevel;
        this.transportationMode=transportationMode;

    }

    public Student() {

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

    public String getTransportationMode(){return transportationMode;}

    public void setTransportationMode(String transportationMode){ this.transportationMode=transportationMode;}
}
