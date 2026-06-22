package polymorphism;



class Shape{
    public Shape() {
    }

    void area(){
        System.out.println("Calculating area");

    }
}
class Circle extends Shape{
    private final int radius;

    Circle(int radius){
        this.radius= radius;
    }
    void area(){
        System.out.println("Circle area: " + (3.14 * radius *radius));
    }
}
class Rectangle extends Shape{

    private final double length;
    private final double width;

    Rectangle(int length, int width) {

        this.length= length;
        this.width= width;
    }

    void area(){
        System.out.println("Rectangle area: " + (length * width));
    }
}
class Triangle extends Shape{

    private final int base;
    private final int height;

    Triangle(int base, int height) {
        this.base=base;
        this.height=height;
    }


    void area(){
        System.out.println("Triangle area: " + (0.5 * base * height));
    }
}

public class ShapeCalculator {

    public static void main(String[] args){
        Shape[] shapes= {new Circle(5), new Rectangle(4,6), new Triangle(3,8)};
        for(Shape s: shapes){
            s.area();
        }
    }


}
