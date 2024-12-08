package hust.soict.dsai.application;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.media.*;
import hust.soict.dsai.store.Store;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        addSampleMedia(store);

        while (isRunning) {
            displayMainMenu();
            int userChoice = getUserInput(scanner, 0, 3);

            switch (userChoice) {
                case 1:
                    displayStoreMenu(store, cart, scanner);
                    break;
                case 2:
                    modifyStore(store, scanner);
                    break;
                case 3:
                    manageCart(cart, scanner);
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Unexpected error occurred.");
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n===== Main Menu =====");
        System.out.println("1. View Store");
        System.out.println("2. Update Store");
        System.out.println("3. View Cart");
        System.out.println("0. Exit");
        System.out.println("=====================");
        System.out.print("Please select an option (0-3): ");
    }

    private static int getUserInput(Scanner scanner, int min, int max) {
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
        } while (choice < min || choice > max);
        return choice;
    }

    private static void displayStoreMenu(Store store, Cart cart, Scanner scanner) {
        System.out.println("\n=== Store ===");
        store.displayItems();
        System.out.println("\n1. View Media Details");
        System.out.println("2. Add Media to Cart");
        System.out.println("3. Play Media");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choose an option: ");

        int choice = getUserInput(scanner, 0, 3);

        switch (choice) {
            case 1:
                viewMediaDetails(store, scanner);
                break;
            case 2:
                addMediaToCart(store, cart, scanner);
                break;
            case 3:
                playMediaFromStore(store, scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice! Returning to Store Menu.");
        }
    }

    private static void viewMediaDetails(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            System.out.println(media);
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    private static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to add: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
            System.out.println("Added \"" + media.getTitle() + "\" to the cart.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    private static void playMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void modifyStore(Store store, Scanner scanner) {
        System.out.println("\n1. Add Media");
        System.out.println("2. Remove Media");
        System.out.print("Choose an option: ");

        int choice = getUserInput(scanner, 1, 2);

        switch (choice) {
            case 1:
                addMediaToStore(store, scanner);
                break;
            case 2:
                removeMediaFromStore(store, scanner);
                break;
        }
    }

    private static void addMediaToStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        System.out.print("Enter the category of the media: ");
        String category = scanner.nextLine();
        System.out.print("Enter the cost of the media: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Clear buffer

        Media newMedia = new Media(0, title, category, cost); // Example for simplicity
        store.addMedia(newMedia);
        System.out.println("Added \"" + newMedia.getTitle() + "\" to the store.");
    }

    private static void removeMediaFromStore(Store store, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        boolean success = store.removeByTitle(title);

        if (success) {
            System.out.println("Removed \"" + title + "\" from the store.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    private static void manageCart(Cart cart, Scanner scanner) {
        System.out.println("\n=== Cart ===");
        cart.displayItems();
        System.out.println("\n1. Remove Media");
        System.out.println("2. Place Order");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choose an option: ");

        int choice = getUserInput(scanner, 0, 2);

        switch (choice) {
            case 1:
                removeMediaFromCart(cart, scanner);
                break;
            case 2:
                placeOrder(cart);
                break;
            case 0:
                break;
        }
    }

    private static void removeMediaFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        boolean success = cart.removeByTitle(title);

        if (success) {
            System.out.println("Removed \"" + title + "\" from the cart.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    private static void placeOrder(Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty. Cannot place an order.");
        } else {
            cart.placeOrder();
            System.out.println("Order placed successfully!");
        }
    }

    private static void addSampleMedia(Store store) {
        store.addMedia(new Media(1, "Sample DVD", "Category 1", 19.99f));
        store.addMedia(new Media(2, "Sample Book", "Category 2", 9.99f));
    }
}
