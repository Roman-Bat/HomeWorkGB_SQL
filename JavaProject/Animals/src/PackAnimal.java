import java.time.LocalDate;
/**
 * Класс PackAnimal представляет животное, которое может использоваться для перевозки грузов.
 * Этот класс является наследником класса Animal.
 */
public class PackAnimal extends Animal {
    /**
     * Флаг, указывающий, есть ли у животного седло.
     */
    private boolean saddle;

    /**
     * Грузоподъемность животного.
     */
    private int loadCapacity;

    /**
     * Создает новое животное для перевозки грузов с указанным именем, датой рождения, наличием седла и грузоподъемностью.
     *
     * @param name имя животного
     * @param birthDate дата рождения животного
     * @param saddle флаг, указывающий, есть ли у животного седло
     * @param loadCapacity грузоподъемность животного
     */
    public PackAnimal(String name, LocalDate birthDate, boolean saddle, int loadCapacity) {
        super(name, birthDate);
        this.saddle = saddle;
        this.loadCapacity = loadCapacity;
    }

    /**
     * Возвращает флаг, указывающий, есть ли у животного седло.
     *
     * @return флаг наличия седла
     */
    public boolean isSaddle() {
        return saddle;
    }

    /**
     * Возвращает грузоподъемность животного.
     *
     * @return грузоподъемность животного
     */
    public int getLoadCapacity() {
        return loadCapacity;
    }
}
