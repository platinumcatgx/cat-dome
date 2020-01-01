package company.Event;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class EventSource {
    private Collection listeners;

    //给事件源注册监听器
    public void addDoListener(EventListenerInfo eventListenerInfo){
        if (listeners==null)
            listeners = new HashSet();
        listeners.add(eventListenerInfo);
    }

    //给事件源注销监听器
    public void DelDoListeners(EventListenerInfo eventListenerInfo){
        if (listeners==null)
            return;
        listeners.remove(eventListenerInfo);
    }

    //触发删除事件
    public void fireDelEvent(){
        if(listeners==null)
            return;
        EventInfo ei = new DelEvent(this);
        notifies(ei);
    }

    //触发新建事件
    public void fireAddEvent(){
        if(listeners==null)
            return;
        EventInfo ei = new AddEvent(this);
        notifies(ei);
    }

    //触发修改事件
    public void fireModifyEvent(){
        if(listeners==null)
            return;
        EventInfo ei = new ModifyEvent(this);
        notifies(ei);
    }


    //当该事件源上有事件发生时，通知该事件源上的所有的监听器做出相应的反应
    public void notifies(EventInfo eventInfo){
        Iterator it = listeners.iterator();
        while (it.hasNext()){
            ((EventListenerInfo)it.next()).handler( eventInfo);
        }
    }
}
