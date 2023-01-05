import java.util.Scanner;

public class SomePassword {

    public static boolean someMet(String login, String password, String confirmPassword) {
        boolean result = false;
        try {
            if (login.matches("[a-zA-Z0-9]*") && login.length() <= 20) {
                if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,20}$") && password.length() <= 20 && password.equals(confirmPassword)) {
                    System.out.println("Пароль и логин введены верно!");
                    result = true;
                } else {
                    throw new WrongPasswordException();
                }
            } else {
                throw new WrongLoginException();
            }
        } catch (WrongLoginException e) {
            System.out.println("Некорректный ввод логина!");
        } catch (WrongPasswordException e) {
            System.out.println("Некорректный ввод пароля!");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = sc.nextLine();
        System.out.println("Введите пароль: ");
        String password = sc.nextLine();
        System.out.println("Подтвердите пароль: ");
        String confirmPassword = sc.nextLine();
        someMet(login, password, confirmPassword);


    }
}