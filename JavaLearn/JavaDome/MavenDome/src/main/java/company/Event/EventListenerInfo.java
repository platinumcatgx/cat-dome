package company.Event;

import java.util.EventListener;

public interface EventListenerInfo extends EventListener {
    public default void handler(EventInfo eventInfo){
        System.out.println(eventInfo.toString());
    }
}
