package implementations;

import interfaces.Display;

import java.util.Objects;

public class Employee implements Display {
    private int ID;
    private String name;
    private int age;
    private String position;

    public Employee(){

    }
    public Employee(int ID){
        this.ID = ID;
    }
    public Employee(int ID, String name, int age, String position){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.position = position;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String toString(){
        return "ID:"+ ID + ", name: "+ name + ", age: "+ age + ", Position: "+ position;
    }
    @Override
    public void displayInformation() {
        System.out.println("This is employee with ID = "+ ID +", and name is "+ name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

}