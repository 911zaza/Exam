import java.util.Objects;

public class User {
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_MANAGER = "manager";
    public static final String ROLE_USER = "user";

    private static int counter = 0;

    private final int id;
    private String name;
    private String role;

    public User() {
        this("", ROLE_USER);
    }

    public User(String name, String role) {
        this.id = ++counter;
        this.name = name;
        setRole(role);
    }

    public User(String data) {
        String[] parts = data.split(";");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        int parsedId = Integer.parseInt(parts[0].trim());
        String parsedName = parts[1].trim();
        String parsedRole = parts[2].trim();
        validateRole(parsedRole);
        this.id = parsedId;
        this.name = parsedName;
        this.role = parsedRole;
        if (parsedId > counter) {
            counter = parsedId;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        validateRole(role);
        this.role = role;
    }

    private static void validateRole(String role) {
        if (!ROLE_ADMIN.equals(role) && !ROLE_MANAGER.equals(role) && !ROLE_USER.equals(role)) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}
