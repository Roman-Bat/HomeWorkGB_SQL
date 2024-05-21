import java.time.LocalDate;

/**
 * Класс Animal представляет животное.
 * Этот класс является абстрактным, поэтому нельзя создавать объекты типа Animal.
 */
public abstract class Animal {
    /**
     * Имя животного.
     */
    private String name;

    /**
     * Дата рождения животного.
     */
    private LocalDate birthDate;

    /**
     * Создает новое животное с указанным именем и датой рождения.
     *
     * @param name имя животного
     * @param birthDate дата рождения животного
     */
    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает имя животного.
     *
     * @return имя животного
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает дату рождения животного.
     *
     * @return дата рождения животного
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }
}
