package itacademy.reflection;

import java.util.Date;

public class SampleClass {

    private int id;
    private String name, surname, location, country;
    private Date today;


    public SampleClass(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLocation() {
        return location;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String toString(){
        return getName() + " " + getSurname() + " " + getLocation() + " " + getCountry();
    }
}
