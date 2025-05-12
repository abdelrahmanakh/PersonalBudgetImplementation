/**
 * The Observer interface defines the method for receiving updates from a subject.
 * Implementing this interface allows objects to register as observers and be notified
 * when a change occurs in the subject's state.
 */
public interface Observer {
    /**
     * This method is called when the subject's state changes.
     * It is used to update the observer with the latest information.
     */
    void update(String title);
}
