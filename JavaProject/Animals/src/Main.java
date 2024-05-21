import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Класс Main содержит основной цикл программы и методы для работы с животными.
 */
public class Main {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private List<Animal> animals = new ArrayList<>();
    private int animalCount = 0;

    public static void main(String[] args) {
        Main registry = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучение новым командам");
            System.out.println("4. Список животных по дате рождения");
            System.out.println("5. Вывести количество созданных животных");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registry.addAnimal(scanner);
                    break;
                case 2:
                    registry.printCommands(scanner);
                    break;
                case 3:
                    registry.addCommand(scanner);
                    break;
                case 4:
                    registry.printAnimalsByBirthDate(scanner);
                    break;
                case 5:
                    registry.printAnimalCount();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
            scanner.nextLine(); // прочитать символ перевода строки
        }
    }
    /**
     * Метод для добавления нового животного в реестр.
     *
     * @param scanner объект Scanner для чтения данных из консоли
     */
    public void addAnimal(Scanner scanner) {
        System.out.println("Введите имя животного:");
        String name = scanner.next();
        scanner.nextLine(); // читаем и игнорируем символ перевода строки

        boolean isDateValid = false;
        LocalDate birthDate = null; // объявляем переменную birthDate до блока while
        while (!isDateValid) {
            System.out.println("Введите дату рождения животного (формат: dd.MM.yyyy):");
            String birthDateString = scanner.nextLine();

            if (birthDateString.trim().isEmpty()) { // проверяем, является ли строка пустой после удаления пробелов
                System.out.println("Некорректная дата. Попробуйте снова:");
                continue;
            }

            try {
                birthDate = LocalDate.parse(birthDateString, DATE_FORMATTER);
                isDateValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Некорректная дата. Попробуйте снова:");
            }
        }

        // выводим запрос на выбор типа животного после ввода даты рождения
        System.out.println("Выберите тип животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осёл");

        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // читаем и игнорируем символ перевода строки

        Animal animal;
        switch (typeChoice) {
            case 1:
                System.out.println("Введите команду для собаки:");
                String command = scanner.nextLine();
                animal = new Pet(name, birthDate, command);
                break;
            case 2:
                System.out.println("Введите команду для кошки:");
                command = scanner.nextLine();
                animal = new Pet(name, birthDate, command);
                break;
            case 3:
                animal = new Pet(name, birthDate, "бегать по колесу");
                break;
            case 4:
                System.out.println("У лошади седло? (1 - да, 0 - нет)");
                boolean saddle = scanner.nextInt() == 1;
                System.out.println("Введите грузоподъёмность лошади:");
                int loadCapacity = scanner.nextInt();
                scanner.nextLine(); // читаем и игнорируем символ перевода строки
                animal = new PackAnimal(name, birthDate, saddle, loadCapacity);
                break;
            case 5:
                System.out.println("У верблюда седло? (1 - да, 0 - нет)");
                saddle = scanner.nextInt() == 1;
                System.out.println("Введите грузоподъёмность верблюда:");
                loadCapacity = scanner.nextInt();
                scanner.nextLine(); // читаем и игнорируем символ перевода строки
                animal = new PackAnimal(name, birthDate, saddle, loadCapacity);
                break;
            case 6:
                System.out.println("У осла седло? (1 - да, 0 - нет)");
                saddle = scanner.nextInt() == 1;
                System.out.println("Введите грузоподъёмность осла:");
                loadCapacity = scanner.nextInt();
                scanner.nextLine(); // читаем и игнорируем символ перевода строки
                animal = new PackAnimal(name, birthDate, saddle, loadCapacity);
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
                return;
        }

        animals.add(animal);
        animalCount++;
        System.out.println("Животное успешно добавлено.");
    }

    /**
     * Метод для вывода списка команд, которые могут выполнять животные.
     *
     * @param scanner объект Scanner для чтения данных из консоли
     */
    public void printCommands(Scanner scanner) {
        List<String> commands = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal instanceof Pet) {
                Pet pet = (Pet) animal;
                String command = pet.getCommand();
                if (!commands.contains(command)) {
                    commands.add(command);
                }
            }
        }

        if (commands.isEmpty()) {
            System.out.println("У животных нет команд.");
        } else {
            System.out.println("Животные могут выполнять следующие команды:");
            for (String command : commands) {
                System.out.println(command);
            }
        }
    }
    /**
     Метод для обучения животного новой команде.
     @param scanner объект Scanner для чтения данных из консоли
     */
    public void addCommand(Scanner scanner) {
        // выводим запрос на выбор типа животного
        System.out.println("Выберите животное, которому хотите добавить новую команду:");
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            System.out.println((i + 1) + ". " + animal.getName() + " (" + animal.getClass().getSimpleName() + ")");
        }

        int choice = scanner.nextInt();
        if (choice < 1 || choice > animals.size()) {
            System.out.println("Некорректный выбор. Попробуйте снова.");
            return;
        }

        Animal animal = animals.get(choice - 1);
        if (animal instanceof Pet) {
            Pet pet = (Pet) animal;

            System.out.println("Введите новую команду для " + pet.getName() + " (" + pet.getClass().getSimpleName() + "):");
            scanner.nextLine(); // пропускаем символ перевода строки
            String newCommand = scanner.nextLine();
            while (newCommand.isEmpty()) {
                System.out.println("Команда не может быть пустой. Попробуйте снова:");
                newCommand = scanner.nextLine();
            }

            pet.addCommand(newCommand);
            System.out.println("Команда успешно добавлена.");
        } else {
            System.out.println("Животное не может выполнять команды.");
        }
    }

    /**

     Метод для вывода списка животных, родившихся в указанную дату.
     @param scanner объект Scanner для чтения данных из консоли */
    public void printAnimalsByBirthDate(Scanner scanner) {
        System.out.println("Введите дату (формат: dd.MM.yyyy):");
        String dateString = scanner.next();
        scanner.nextLine();
        LocalDate date = null;
        while (date == null) {
            try {
                date = LocalDate.parse(dateString, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Некорректная дата. Попробуйте снова:");
                dateString = scanner.nextLine();
            }
        }

        List<Animal> animalsByBirthDate = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getBirthDate().isEqual(date)) {
                animalsByBirthDate.add(animal);
            }
        }

        if (animalsByBirthDate.isEmpty()) {
            System.out.println("Животные, родившиеся в указанную дату, не найдены.");
            return;
        }

        System.out.println("Список животных, родившихся в указанную дату:");
        for (Animal animal : animalsByBirthDate) {
            System.out.println(animal.getName());
        }
    }
    /**
    Метод для вывода общего количества созданных животных.
     */
    public void printAnimalCount() {
        System.out.println("Общее количество созданных животных: " + animalCount);
    }
    /**

     Метод для поиска животного по имени.
     @param name имя животного
     @return объект Animal, если животное найдено, или null, если животное не найдено */
    private Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }
}
