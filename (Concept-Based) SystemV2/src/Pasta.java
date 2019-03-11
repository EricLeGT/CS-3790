public class Pasta extends Food{

    PastaSauce pastaSauce;
    PastaType pastaType;

    public Pasta(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }

    public void setPastaType(PastaType pastaType) {
        this.pastaType = pastaType;
    }

    public PastaSauce getPastaSauce() {
        return pastaSauce;
    }

    public void setPastaSauce(PastaSauce pastaSauce) {
        this.pastaSauce = pastaSauce;
    }

    public PastaType getPastaType() {
        return pastaType;
    }

}
