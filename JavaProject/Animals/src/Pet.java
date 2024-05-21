import java.time.LocalDate;
/**
 * Класс Pet представляет домашнего питомца, который может выполнять команды.
 * Этот класс является наследником класса Animal.
 */
public class Pet extends Animal {
    /**
     * Команда, которую может выполнять питомец.
     */
    private String command;

    /**
     * Создает нового питомца с указанным именем, датой рождения и командой.
     *
     * @param name имя питомца
     * @param birthDate дата рождения питомца
     * @param command команда, которую может выполнять питомец
     */
    public Pet(String name, LocalDate birthDate, String command) {
        super(name, birthDate);
        this.command = command;
    }

    /**
     * Возвращает команду, которую может выполнять питомец.
     *
     * @return команда питомца
     */
    public String getCommand() {
        return command;
    }

    /**
     * Добавляет новую команду к существующим командам питомца.
     *
     * @param newCommand новая команда, которую нужно добавить
     */
    public void addCommand(String newCommand) {
        command += ", " + newCommand;
    }
}
