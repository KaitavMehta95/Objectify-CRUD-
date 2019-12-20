package model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Employee {

    @Id
    public Long Id;
    String fname;
    String lname;

    public Employee(){};

    public Employee(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
