package company.Event;

public class AddEventListener  implements EventListenerInfo {
    @Override
    public void handler(EventInfo eventInfo) {
        if (eventInfo.getDoType().equals("add")){
            System.out.println("新增文章...");
        }
    }
}
