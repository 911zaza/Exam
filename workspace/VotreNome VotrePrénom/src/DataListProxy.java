import java.util.Arrays;

public class DataListProxy implements DataAccessObject {
    private final DataList dataList;
    private final User user;

    public DataListProxy(DataList dataList, User user) {
        this.dataList = dataList;
        this.user = user;
    }

    @Override
    public void insert(String element) {
        if (canInsert()) {
            dataList.insert(element);
        } else {
            deny("insert");
        }
    }

    @Override
    public void update(int index, String element) {
        if (canUpdate()) {
            dataList.update(index, element);
        } else {
            deny("update");
        }
    }

    @Override
    public String delete(int index) {
        if (canDelete()) {
            return dataList.delete(index);
        }
        deny("delete");
        return null;
    }

    @Override
    public String[] select(String keyword) {
        if (canSelect()) {
            return dataList.select(keyword);
        }
        deny("select");
        return new String[0];
    }

    @Override
    public String[] selectAll() {
        if (canSelectAll()) {
            return dataList.selectAll();
        }
        deny("selectAll");
        return new String[0];
    }

    private boolean canInsert() {
        return User.ROLE_ADMIN.equals(user.getRole());
    }

    private boolean canUpdate() {
        return User.ROLE_ADMIN.equals(user.getRole()) || User.ROLE_MANAGER.equals(user.getRole());
    }

    private boolean canDelete() {
        return User.ROLE_ADMIN.equals(user.getRole());
    }

    private boolean canSelect() {
        return User.ROLE_ADMIN.equals(user.getRole())
                || User.ROLE_MANAGER.equals(user.getRole())
                || User.ROLE_USER.equals(user.getRole());
    }

    private boolean canSelectAll() {
        return canSelect();
    }

    private void deny(String action) {
        System.out.println("Access denied for role '" + user.getRole() + "' on action: " + action);
        System.out.println("Current data snapshot: " + Arrays.toString(dataList.selectAll()));
    }
}
