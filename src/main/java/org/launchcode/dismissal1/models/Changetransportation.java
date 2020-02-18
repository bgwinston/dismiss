package org.launchcode.dismissal1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Changetransportation {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max= 8, message = "Select Transportation change.")
    private String transportationchange;

    @NotNull
    @Size(min = 3, max= 8, message = "Enter date in mm:dd:yyyy format.")
    private String datec;

    @NotNull
    @Size(min = 3, max=200, message= "Write a note for your records.")
    private String notes1;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    private Student student;


    public Changetransportation(String transportationchange, String datec, String notes1) {
        this.transportationchange=transportationchange;
        this.datec = datec;
        this.notes1 = notes1;
        }

    public Changetransportation() {

    }

    public int getId() {
        return id;
        }

    public String getTransportationchange() {
        return transportationchange;
        }

    public void setTransportationchange(String transportationchange) { this.transportationchange = transportationchange; }

    public String getDatec() {
        return datec;
        }

    public void setDatec(String datec) {
        this.datec = datec;
        }

    public String getNotes1() {
        return notes1;
        }

    public void setNotes1(String notes1) {
        this.notes1 = notes1;
        }
}