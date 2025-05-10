import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController<T> {
    private List<T> entities;

    public AbstractController() {
        this.entities = new ArrayList<>();
    }
    public void addEntity(T entity) {
        this.entities.add(entity);
    }
    public void removeEntity(T entity) {
        this.entities.remove(entity);
    }
    public List<T> getEntities() {
        return entities;
    }
    public abstract void displayEntity(int id);
}
