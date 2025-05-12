import java.util.List;

/**
 * Abstract class that represents a generic controller for managing entities.
 * Provides basic functionality for adding, removing, and retrieving entities.
 * This class must be extended to define specific behavior for displaying entities.
 *
 * @param <T> The type of entities managed by the controller.
 */
public abstract class AbstractController<T> {
    private List<T> entities;

    /**
     * Constructs a new AbstractController with a list of entities.
     * @param entities The list of entities to be managed by the controller.
     */
    public AbstractController(List<T> entities) {
        this.entities = entities;
    }

    /**
     * Adds an entity to the list of entities.
     * @param entity The entity to be added.
     */
    public void addEntity(T entity) {
        this.entities.add(entity);
    }

    /**
     * Removes an entity from the list of entities.
     * @param entity The entity to be removed.
     */
    public void removeEntity(T entity) {
        this.entities.remove(entity);
    }

    /**
     * @return The list of entities managed by the controller.
     */
    public List<T> getEntities() {
        return entities;
    }

    /**
     * Abstract method to display a specific entity.
     * This method must be implemented by subclasses to define how an entity is displayed.
     * @param entity The entity to be displayed.
     */
    public abstract void displayEntity(T entity);
}
