public interface DataAccessObject {
    void insert(String element);

    void update(int index, String element);

    String delete(int index);

    String[] select(String keyword);

    String[] selectAll();
}
