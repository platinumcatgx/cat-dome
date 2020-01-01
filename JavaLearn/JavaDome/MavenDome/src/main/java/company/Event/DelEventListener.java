package company.Event;

public class DelEventListener implements EventListenerInfo{

    @Override
    public void handler(EventInfo object) {
        if(object.getDoType().equals("delete"))
            System.out.println("删除文章。。。。");
        //进行后续操作
    }
}

