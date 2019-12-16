package org.launchcode.dismissal1.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @ManyToMany
    private List<Changetransportation> changetransportations;
    @ManyToMany
    private List<Early>early1;

    public Student(String studentname, String teachername, String gradelevel) {
        this.studentname = studentname;
        this.teachername=teachername;
        this.gradelevel=gradelevel;
    }

    public Student() {

    }
    public void addItem(Changetransportation item) {changetransportations.add(item);}
    public void addIteme(Early item1) {early1.add(item1);}

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
