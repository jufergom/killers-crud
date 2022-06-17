import java.util.List;
import java.util.Scanner;

public class OptionsSource {

    private static KillerService killerService = new KillerServiceImpl();

    private final static Scanner scanner = new Scanner(System.in);

    public static void createKiller() {
        System.out.print("Enter killer's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter killer's hp: ");
        int hp = scanner.nextInt();
        System.out.print("Does your killer has equipped a mori? [Y/N]: ");
        char hasMori = scanner.next().charAt(0);
        scanner.nextLine();
        killerService.createKiller(new Killer(IdGenerator.getNextId(), name, hp, hasMori == 'y' || hasMori == 'Y'));
        System.out.println("Killer created successfully");
    }

    public static void listAllKillers() {
        List<Killer> killers = killerService.getAllKillers();
        for (Killer killer : killers) {
            System.out.println(killer.toString());
        }
    }

    public static void searchKillerById() {
        try {
            System.out.print("Enter killer's id: ");
            int id = scanner.nextInt();
            Killer killer = killerService.getKillerById(id);
            System.out.println(killer.toString());
        }
        catch(KillerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modifiyKiller() {
        try {
            Killer killer = new Killer();
            System.out.print("Enter killer's id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter killer's name: ");
            killer.setName(scanner.nextLine());
            System.out.print("Enter killer's hp: ");
            killer.setHp(scanner.nextInt());
            System.out.print("Does your killer has equipped a mori? [Y/N]: ");
            char hasMori = scanner.next().charAt(0);
            killer.setHasMori(hasMori == 'y' || hasMori == 'Y');
            scanner.nextLine();

            killerService.modifyKiller(id, killer);
            System.out.println("Killer modified successfully");
        }
        catch(KillerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteKiller() {
        try {
            System.out.print("Enter killer's id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            killerService.deleteKiller(id);
            System.out.println("Killer deleted successfully");
        }
        catch(KillerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exit() {
        System.exit(0);
    }
}
