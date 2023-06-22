public class Plate {
    private int food;

    public Plate(int food) {
        if (food < 0) {
            throw new IllegalArgumentException("food must be positive");
        }
        this.food = food;
    }

    public void increaseFood(int food) {
        if (food > 0) {
            this.food += food;
        }
    }

    public double eatFood(int appetite, double satiety) {
        int canEat = (int) ((100 - satiety) / 100 * appetite);
        if (this.food >= canEat) {
            this.food -= canEat;
            return 100;
        }
        double outSatiety = (double) this.food/appetite * 100 + satiety;
        this.food = 0;
        return outSatiety;
    }

    @Override
    public String toString() {
        return String.format("Остаток еды в тарелке - %d", food);
    }
}
