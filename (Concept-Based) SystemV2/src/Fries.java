public class Fries extends Food{
    Size size;
    Sauce sauce;

    public Fries(Size size, Sauce sauce) {
        this.size = size;
        this.sauce = sauce;
    }

    public Fries(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

}
