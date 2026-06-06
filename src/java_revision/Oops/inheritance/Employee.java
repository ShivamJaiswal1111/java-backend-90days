package java_revision.Oops.inheritance;

class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    String getInfo() {
        return "Name: "+ name + ", age: " + age;
    }
}
class Employeee extends Person{
    String company;
    double salary;

    Employeee(String name, int age, String company, double salary){
        super(name, age);
        this.company=company;
        this.salary=salary;


    }
    String getInfo(){
        return super.getInfo() +", Company: "+ company+ ", Salary: "+ salary;
    }
}

class Manager extends Employeee{
    String department;

    Manager(String name, int age, String company, double salary, String department){
        super(name, age, company, salary);
        this.department=department;
    }
    String getInfo(){
        return super.getInfo()+", Department: "+ department;
    }
}

public class Employee {
    public static void main(String[] args)

    {
        Manager manage = new Manager("Shivam", 21, "Google", 150000, "Engineering");
        System.out.println(manage.getInfo());
    }
}

