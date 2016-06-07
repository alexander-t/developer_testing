package shop.inventory;

public class Inventory {

    // This method simulates a repository method that would look in some kind
    // of persistent storage.
    public static Book getBookByTitle(String title) {
        switch (title) {
            case "Developer Testing":
                return new Book("Developer Testing", 20);
            case "TDD from scratch":
                return new Book("TDD from scratch", 15);
            case "Refactoring":
                return new Book("Refactoring", 30);
            default:
                throw new IllegalArgumentException(String
                        .format("Can't find book with title '%s'", title));
        }
    }

    public static Training getTraining(String name) {
        return new Training("TDD for Dummies", 999);
    }
}