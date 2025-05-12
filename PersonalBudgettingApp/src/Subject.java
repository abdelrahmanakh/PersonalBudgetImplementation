/**
 * The Subject interface defines the methods for an object that maintains a list of its dependents (observers),
 * and notifies them of any state changes.
 * This follows the observer design pattern, where the subject maintains a list of observers
 * that are notified when the subject’s state changes.
 */
public interface Subject {
    /**
     * Adds an observer to the list of observers.
     * @param o The observer to be added.
     */
    void addObserver(Observer o);

    /**
     * Removes an observer from the list of observers.
     * @param o The observer to be removed.
     */
    void removeObserver(Observer o);

    /**
     * Notifies all registered observers about a change in the subject's state.
     * This method should be called when the subject’s state changes.
     */
    void notifyObservers();
}
