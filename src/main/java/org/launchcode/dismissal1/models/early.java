package org.launchcode.dismissal1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

//Early Pick Up table
@Entity
public class early {
    @Id
    @GeneratedValue
    private int id;

    //@NotNull
    @Size(min = 3, max= 8, message = "Enter time in hh:mm:ss format.")
    private String time;

    //@NotNull
    @Size(min = 3, max= 8, message = "Enter date in mm:dd:yyyy format.")
    private String date;

    //@NotNull
    @Size(min = 1, message= "Write a note for your records.")
    private String notes;

    //@Size(min = 3)
    //format of date and time of submission
    //private LocalDateTime submission=LocalDateTime.now();
    //DateTimeFormatter forsubmission = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    //private String formattedDate = submission.format(forsubmission);

    public early(String time, String date, String notes) {
        this.time = time;
        this.date = date;
        this.notes = notes;
        //this.formattedDate = formattedDate;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //public LocalDateTime getSubmission() {
     //   return submission;
    //}

    //public void setSubmission(LocalDateTime submission) {
     //   this.submission = submission;
    //}

    //public DateTimeFormatter getForsubmission() {
    //    return forsubmission;
    //}

    //public void setForsubmission(DateTimeFormatter forsubmission) {
     //   this.forsubmission = forsubmission;
    //}

    //public String getFormattedDate() {
        //return formattedDate;
   // }

    //public void setFormattedDate(String formattedDate) {
      //  this.formattedDate = formattedDate;
    //}
}

