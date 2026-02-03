public class Main {
    public static void main(String[] args) {
        System.out.println("=== DataList direct ===");
        Application directApp = new Application(new DataList());
        directApp.run();

        System.out.println("=== DataListProxy with admin ===");
        User admin = new User("Alice", User.ROLE_ADMIN);
        Application adminApp = new Application(new DataListProxy(new DataList(), admin));
        adminApp.run();

        System.out.println("=== DataListProxy with manager ===");
        User manager = new User("Bob", User.ROLE_MANAGER);
        Application managerApp = new Application(new DataListProxy(new DataList(), manager));
        managerApp.run();

        System.out.println("=== DataListProxy with user ===");
        User user = new User("Charlie", User.ROLE_USER);
        Application userApp = new Application(new DataListProxy(new DataList(), user));
        userApp.run();
    }
}
