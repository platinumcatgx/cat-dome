package company.Event;

import java.util.EventObject;

public class ModifyEvent extends EventObject implements EventInfo{
    private final String doType="modifyt";
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ModifyEvent(Object source) {
        super(source);
    }

    @Override
    public String getDoType() {
        return doType;
    }

    @Override
    public String toString() {
        return doType;
    }
}
