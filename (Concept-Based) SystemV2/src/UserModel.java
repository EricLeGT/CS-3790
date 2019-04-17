public class UserModel {
    Restaurant preferred;
    Reason reason;
    double degree;

    public UserModel(Restaurant preferred, Reason reason, double degree) {
        this.preferred = preferred;
        this.reason = reason;
        this.degree = degree;
    }

    public Restaurant getRestaurantChosen() {
        return preferred;
    }

    public double getDegree() {
        return degree;
    }
}
