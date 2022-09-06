package model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String birthDay;
    private String adddress;
    private String phone;
    private String email;
    private String classRoom;

    public Student() {
    }

    public Student(int id, String name, String birthDay, String adddress, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.adddress = adddress;
        this.phone = phone;
        this.email = email;
    }

    public Student(int id, String name, String birthDay, String adddress, String phone, String email, String classRoom) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.adddress = adddress;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}


