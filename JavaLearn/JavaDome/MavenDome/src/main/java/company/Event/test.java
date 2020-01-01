package company.Event;

public class test {

    public static void main(String[] args) {
        EventSource es = new EventSource();      //一个博客事件源
        EventSource es2 = new EventSource();     //另一个博客的事件源

        //给每个事件源增加监听器
        es.addDoListener(new AddEventListener());
        es.addDoListener(new DelEventListener());
        es.addDoListener(new ModifyEventListener());

        es2.addDoListener(new AddEventListener());
        es2.addDoListener(new DelEventListener());
        es2.addDoListener(new ModifyEventListener());

        //事件发生
        es.fireAddEvent();
        es.fireModifyEvent();
        es.fireDelEvent();

        es2.fireAddEvent();
        es2.fireModifyEvent();
        es2.fireDelEvent();
    }
}