package java_revision.Oops.encapsulation;



class Student{
    private String name;
    private int age;
    private double marks;

    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name== null){
            System.out.println("Invalid name");
            return;
        }
        this.name=name;
    }
    public int getAge(){return age;}
    public void setAge(int age){
        if(age<1 || age>30){System.out.println("Invalid age"); return;}
        this.age=age;
    }
    public double getMarks(){return marks;}
    public void setMarks(double marks){
        if (marks<0 || marks>100){System.out.println("Invalid marks"); return;}
        this.marks=marks;
    }
}

public class Students {
    public static void main(String args[]) {
        Student stud = new Student();
        stud.setName(null);
        stud.setAge(88);
        stud.setMarks(180.0);
        stud.setName("Shivam");
        stud.setAge(21);
        stud.setMarks(98);
        System.out.println(stud.getName()+", " +stud.getAge()+ ", "+ stud.getMarks());
    }



}
