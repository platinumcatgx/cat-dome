package company.Event;

public class ModifyEventListener implements EventListenerInfo{

    @Override
    public void handler(EventInfo object) {
        if(object.getDoType().equals("modify"))
            System.out.println("修改文章。。。。");
        //进行后续操作
    }
}
