public class Main {
    public static void main(String[] args) {
        String login = "java_skypo";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        System.out.println(checkLogIn(login, password, confirmPassword));
    }

    private static boolean checkLogIn(String login, String password, String confirmPassword) {
        boolean checkLog = login.matches("\\w+");
        boolean checkPassword = password.matches("\\w+");
        boolean userInfo = checkLog && checkPassword;
        try {
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
            return userInfo;
        } catch (WrongLoginException e) {
            System.out.println("Логин превышает 20 символов");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Пароли не совпадают");
            return false;
        } finally {
            System.out.println("Проверка завершена");
        }
    }
}