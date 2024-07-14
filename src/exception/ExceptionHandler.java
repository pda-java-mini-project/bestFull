package exception;

public class ExceptionHandler {
    public static void handleInvalidInputException(InvalidInputException exception) {
        System.out.println("error: " + exception.getMessage());
    }

    public static void handleMenuNotFoundException(MenuNotFoundException exception) {
        System.out.println("error: " + exception.getMessage());
    }
}
