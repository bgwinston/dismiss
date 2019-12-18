package org.launchcode.dismissal1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//Early Pick Up table
@Entity
public class Early {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max= 8, message = "Enter time in hh:mm:ss format.")
    private String timeofpickup;

    @NotNull
    @Size(min = 3, max= 8, message = "Enter date in mm:dd:yyyy format.")
    private String dateofpickup;

    @NotNull
    @Size(min = 1, message= "Write a note for your records.")
    private String notes;

    //@ManyToMany(mappedBy = "early1")
    //private List<Student> students;

    public Early(String timeofpickup, String dateofpickup, String notes) {
        this.timeofpickup = timeofpickup;
        this.dateofpickup = dateofpickup;
        this.notes = notes;

    }

    public Early(){
    }

    public String getTimeofpickup() {
        return timeofpickup;
    }

    public void setTimeofpickup(String timeofpickup) {
        this.timeofpickup = timeofpickup;
    }

    public String getDateofpickup() {
        return dateofpickup;
    }

    public void setDateofpickup(String dateofpickup) {
        this.dateofpickup = dateofpickup;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

