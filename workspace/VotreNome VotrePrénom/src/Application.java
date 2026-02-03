import java.util.Arrays;

public class Application {
    private final DataAccessObject dataAccessObject;

    public Application(DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    public void run() {
        System.out.println("--- insert ---");
        dataAccessObject.insert("Java");
        dataAccessObject.insert("Spring");

        System.out.println("--- update ---");
        dataAccessObject.update(1, "Spring Boot");

        System.out.println("--- select keyword 'Java' ---");
        System.out.println(Arrays.toString(dataAccessObject.select("Java")));

        System.out.println("--- selectAll ---");
        System.out.println(Arrays.toString(dataAccessObject.selectAll()));

        System.out.println("--- delete ---");
        System.out.println(dataAccessObject.delete(0));
    }
}
