
import Controller.Handler;
import View.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {

    Handler handler;

    public FileHandler() {
        handler = new Handler();
    }

    public void displayMainMenu() {
        Menu<String> mainMenu = new Menu<>("File Processing", new String[]{
            "Find person info",
            "Copy text to new file",
            "Exit"
        }) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> {
                        try {
                            handler.findInfo();
                        } catch (Exception ex) {
                            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    case 2 -> {
                        try {
                            handler.copyToNewFile();
                        } catch (Exception ex) {
                            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    case 3 ->
                        System.exit(0);
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        mainMenu.run();
    }

    public static void main(String[] args) {
        FileHandler main = new FileHandler();
        main.displayMainMenu();
    }
}
