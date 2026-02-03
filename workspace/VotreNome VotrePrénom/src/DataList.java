import java.util.List;
import java.util.Vector;

public class DataList implements DataAccessObject {
    private final List<String> data = new Vector<>();

    @Override
    public void insert(String element) {
        data.add(element);
    }

    @Override
    public void update(int index, String element) {
        data.set(index, element);
    }

    @Override
    public String delete(int index) {
        return data.remove(index);
    }

    @Override
    public String[] select(String keyword) {
        List<String> results = new Vector<>();
        for (String element : data) {
            if (element.contains(keyword)) {
                results.add(element);
            }
        }
        return results.toArray(new String[0]);
    }

    @Override
    public String[] selectAll() {
        return data.toArray(new String[0]);
    }
}
