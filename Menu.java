import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private String title;

    private List<Option> options;

    private final Scanner scanner;

    public Menu() {
        title = "Killers CRUD";
        options = new ArrayList<>(List.of(
            new Option("1. Create killer", OptionsSource::createKiller),
            new Option("2. List all killers", OptionsSource::listAllKillers),
            new Option("3. Search killer by id", OptionsSource::searchKillerById),
            new Option("4. Modify killer", OptionsSource::modifiyKiller),
            new Option("5. Delete killer", OptionsSource::deleteKiller),
            new Option("6. Exit", OptionsSource::exit)
        ));
        scanner = new Scanner(System.in);
    }

    public void executeMenu() {
        int selectedOption;
        while(true) {
            try {
                System.out.println(title);
                for (Option option : options) {
                    System.out.println(option.getText());
                }
                System.out.print("Select an option: ");
                selectedOption = scanner.nextInt();
                System.out.println();
                options.get(--selectedOption).getOptionCode().run();
            }
            catch(IndexOutOfBoundsException e) {
                System.err.println("Invalid option");
            }
            catch(InputMismatchException e) {
                System.err.println("Expected a number");
                scanner.nextLine();
            }
            System.out.println();
        }
    }
}