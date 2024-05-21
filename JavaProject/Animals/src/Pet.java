import java.time.LocalDate;

class Pet extends Animal {
    private String command;

    public Pet(String name, LocalDate birthDate, String command) {
        super(name, birthDate);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void addCommand(String newCommand) {
        command += ", " + newCommand;
    }
}
