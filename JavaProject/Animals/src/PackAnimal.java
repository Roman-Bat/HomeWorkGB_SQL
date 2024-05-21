import java.time.LocalDate;

class PackAnimal extends Animal {
    private boolean saddle;
    private int loadCapacity;

    public PackAnimal(String name, LocalDate birthDate, boolean saddle, int loadCapacity) {
        super(name, birthDate);
        this.saddle = saddle;
        this.loadCapacity = loadCapacity;
    }

    public boolean isSaddle() {
        return saddle;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
}