
public class main {
    public static void main(String args[]) {
        User user = new User(Budget.Poor, null, null, null);

        Restaurants[] restaurants = {new Panda_Express(), new Subway(), new Chick_Fila(), new Twisted_Taco()};
        Student_Center student_center = new Student_Center();
        student_center.setRestaurants(restaurants);

        System.out.println("Thats as far as we got : D");
    }
}
