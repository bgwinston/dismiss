package org.launchcode.dismissal1.models;

public class dismissal {
    public dismissal(String password) {
    }

    private String username;
    private String password;
    private String child;
    private Integer grade_level;
    private String teacher;

    public dismissal(String username, String password, String child, Integer grade_level, String teacher) {
        this.username = username;
        this.password = password;
        this.child = child;
        this.grade_level = grade_level;
        this.teacher = teacher;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public Integer getGrade_level() {
        return grade_level;
    }

    public void setGrade_level(Integer grade_level) {
        this.grade_level = grade_level;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}


