package org.launchcode.dismissal1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Early Pick Up table
@Entity
public class early {
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

    public early(String timeofpickup, String dateofpickup, String notes) {
        this.timeofpickup = timeofpickup;
        this.dateofpickup = dateofpickup;
        this.notes = notes;

    }

    public early(){
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

