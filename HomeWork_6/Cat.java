public class Cat {
    private String name; // поле, содержащее имя кота
    private int appetite; // аппетит кота (столько он съедает за раз)
    private double satiety; // сытость кота в % 

    public Cat(String name, int appetite, double satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        if (satiety < 100) {
            satiety = plate.eatFood(appetite, satiety);
        }
    }

    @Override
    public String toString() {
        return String.format("Имя кота - %s, его аппетит - %d, текущая сытость - %.2f%%", name, appetite, satiety);
    }
}
