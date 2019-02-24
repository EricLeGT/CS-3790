import java.util.Scanner;

public class main {
    public static void main(String args[]) {

        System.out.println("Setting up a new User and asking for parameters");
        User user = new User();

        System.out.println("Instantiating Restaurants into Student Center");
        Student_Center student_center = new Student_Center();
        student_center.setPanda(new Panda_Express());
        student_center.setSubway(new Subway());
        student_center.setChickFila(new Chick_Fila());
        student_center.setTwistedTaco(new Twisted_Taco());

        user.sendUserToResturant(student_center);
        System.out.println("Sending User to " + user.chosenRestaurant);

        System.out.println("User is choosing an item");
        user.chooseItem();
        user.eat();


        System.out.println("Thats as far as we got : D");
    }
}
