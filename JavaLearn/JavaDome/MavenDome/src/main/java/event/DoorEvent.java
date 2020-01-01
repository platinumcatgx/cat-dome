package event;

import java.util.*;

/**
 * 事件对象
 */
public class DoorEvent extends EventObject {
    private static final long serialVersionUID = 6496098798146410884L;

    private boolean doorState = true;// 表示门的状态，有“开”和“关”两种

    public DoorEvent(Object source, boolean doorState) {
        super(source);
        this.doorState = doorState;
    }

    public boolean isDoorState() {
        return doorState;
    }

    public void setDoorState(boolean doorState) {
        this.doorState = doorState;
    }
}

/**
 * 监听接口
 */
interface DoorListener extends EventListener{
    public void doorEvent(DoorEvent event);
}

/**
 * 门1监听接口实现，做具体的动作开门，关门
 */
class DoorListener1 implements DoorListener{

    public void doorEvent(DoorEvent event) {
        if(event.isDoorState()==true)
            System.out.println("开门");
        else
            System.out.println("关门");
    }
}
/**
 * 门2监听接口实现，做具体的动作开门，关门
 */
class DoorListener2 implements DoorListener {


    public void doorEvent(DoorEvent event) {
        // TODO Auto-generated method stub
        if (event.isDoorState()==true ) {
            System.out.println("门2打开，同时打开走廊的灯");
        } else {
            System.out.println("门2关闭，同时关闭走廊的灯");
        }
    }

}

/**
 * 事件源对象，在这里你可以把它想象成一个控制开门关门的遥控器，
 * (如果是在swing中，就类似一个button)
 */
class DoorManager {
    private Collection listeners;

    /**
     * 添加事件
     * @param listener
     *            DoorListener
     */
    public void addDoorListener(DoorListener listener) {
        if (listeners == null) {
            listeners = new HashSet();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     * @param listener
     *            DoorListener
     */
    public void removeDoorListener(DoorListener listener) {
        if (listeners == null)
            return;
        listeners.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, true);
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed() {
        if (listeners == null)
            return;
        DoorEvent event = new DoorEvent(this, false);
        notifyListeners(event);
    }

    /**
     * 通知所有的DoorListener
     */
    private void notifyListeners(DoorEvent event) {
        Iterator iter = listeners.iterator();
        while (iter.hasNext()) {
            DoorListener listener = (DoorListener) iter.next();
            listener.doorEvent(event);
        }
    }
}

class DoorMain {
    public static void main(String[] args) {
        DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener1());// 给门1增加监听器
        manager.addDoorListener(new DoorListener2());// 给门2增加监听器
        // 开门
        manager.fireWorkspaceOpened();
        System.out.println("我已经进来了");
        // 关门
        manager.fireWorkspaceClosed();
    }
}
