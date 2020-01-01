package Socket;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Server {
    //1.v以下为必须在外部声明的变量
    //1.1 UI组件
    JButton StartServer;//开始服务器
    JButton StopServer;//停止服务器
    JButton SendMessageButton;//发送消息
    JTextField MaxNumberText;//最大连接人数
    JTextField ServerPortText;//监听端口
    JTextField InputContentText;//消息输入框
    JList OnlineClientList;//在线列表
    JLabel LogsLabel;//日志栏

    //1.2 socket相关
    ServerSocket serverSocket;//服务器的socket类型为 ServerSocket
    //这里必须要把serverThread线程在外部声明，否则会出现找不到类的报错

    //1.3 线程相关
    ServerThread1 serverThread;//服务器线程：这里的命名增加了1，怀疑系统中有和他同名的类
    ConcurrentHashMap<String, ClientThread> clientThreads;//所有client的Thread，key=clientNickName, value=clientThread
    //ConcurrentHashMap对于多线程可以不一次死锁掉全部线程
    //1.4 用户昵称
    DefaultListModel<String> OnlineClientNickName;//在线用户昵称，向其中插入数据，自动将数据插入到JList中
    String ToTargetName  = "ALL";//信息发送的目标用户昵称

    //2.构造函数
    public Server() {
        CreateFrame();
    }

    //3. 与服务器建立相关
    //3.1 开始运行服务器
    public void StartServer() {
        int ServerPort = Integer.parseInt(ServerPortText.getText().trim());
        try {
            //3.1.1 对相应端口建立socket
            serverSocket = new ServerSocket(ServerPort);

            //3.1.2 为服务器建立新的线程，在线程里面对socket进行监听
            serverThread = new ServerThread1();//如果不重新建立线程会导致服务器界面阻塞，无法点击

            //3.1.3新建存取每个客户端socket线程的map
            clientThreads = new ConcurrentHashMap<String,ClientThread>();

            //3.1.4 服务端在线用户列表显示ALL
            OnlineClientNickName.addElement("ALL");
        } catch (BindException e) {
            // TODO Auto-generated catch block
            Error("Server：端口异常"+e.getMessage());
        } catch(Exception e) {
            Error("Server：服务器启动失败");
        }
        Success("成功运行服务器");
    }
    //3.2 断开服务器


    //4. UI相关
    //4.1 生成界面窗口
    public void CreateFrame() {
        //4.1 生成一个JFrame窗体
        JFrame ServerFrame = new JFrame("服务器");
        //4.1.1设置长宽，注意数值不需要引号
        ServerFrame.setSize(800,600);
        //4.1.2设置在屏幕中央显示
        ServerFrame.setLocationRelativeTo(null);
        //4.1.3设置默认关闭按钮，不设置也可以
        ServerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //4.2 声明服务端信息栏
        JPanel ServerIdPanel = new JPanel();
        //4.2.1 设置服务端信息栏的布局为浮动布局
        ServerIdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ServerIdPanel.setSize(800, 100);
        //4.2.2 最大连接人数
        JLabel MaxNumberLabel = new JLabel("    最大连接人数");
        MaxNumberText = new JTextField(10);
        MaxNumberText.setText("10");
        ServerIdPanel.add(MaxNumberLabel);
        ServerIdPanel.add(MaxNumberText);
        //4.2.3 端口号
        JLabel ServerPortLabel = new JLabel("    端口");
        ServerPortText = new JTextField(10);
        ServerPortText.setText("8288");
        ServerIdPanel.add(ServerPortLabel);
        ServerIdPanel.add(ServerPortText);
        //4.2.5 启动/停止服务器
        StartServer = new JButton("启动");
        StopServer = new JButton("停止");
        ServerIdPanel.add(StartServer);
        ServerIdPanel.add(StopServer);
        //4.2.6 设置标题
        ServerIdPanel.setBorder(new TitledBorder("服务器信息栏"));

        //4.3 在线用户列表栏
        JPanel FriendListPanel = new JPanel();
        FriendListPanel.setPreferredSize(new Dimension(200,400));
        FriendListPanel.setBorder(new TitledBorder("好友列表"));
        //4.3.1 好友列表内容
        OnlineClientNickName = new DefaultListModel<String>();
        OnlineClientList = new JList(OnlineClientNickName);
        FriendListPanel.add(OnlineClientList);

        //4.4 日志面板
        JPanel LogsPanel = new JPanel();
        LogsPanel.setPreferredSize(new Dimension(590,400));
        LogsPanel.setBorder(new TitledBorder("日志内容"));
        //4.4.1 日志内容标签
        LogsLabel = new JLabel("<html>");
        LogsLabel.setPreferredSize(new Dimension(590,400));
        LogsPanel.add(LogsLabel);

        //4.5 声明输入内容面板
        JPanel InputContentPanel = new JPanel();
        InputContentPanel.setPreferredSize(new Dimension(600,100));
        //4.5.1 定义聊天输入框
        InputContentText = new JTextField();
        InputContentText.setPreferredSize(new Dimension(600,60));
        //4.5.2 发送按钮
        SendMessageButton = new JButton("发送");
        InputContentPanel.add(InputContentText);
        InputContentPanel.add(SendMessageButton);
        InputContentPanel.setBorder(new TitledBorder("输入内容"));

        //4.6 服务端整体布局
        ServerFrame.add(ServerIdPanel, BorderLayout.NORTH);
        ServerFrame.add(FriendListPanel, BorderLayout.WEST);
        ServerFrame.add(LogsPanel, BorderLayout.CENTER);
        ServerFrame.add(InputContentPanel,BorderLayout.SOUTH);

        //4.7 设置可见
        ServerFrame.setVisible(true);

        //4.8 添加监听事件
        AddActionListener();
    }
    //4.2添加监听
    private void AddActionListener() {
        StartServer.addActionListener(new ActionListener() {//启动服务器
            public void actionPerformed(ActionEvent e) {
                StartServer();
            }
        });
        StopServer.addActionListener(new ActionListener() {//停止服务器
            public void actionPerformed(ActionEvent e) {
                Log("Server：点击停止,暂没有作用");
            }
        });
        SendMessageButton.addActionListener(new ActionListener() {//发送消息
            public void actionPerformed(ActionEvent e) {
                String message = InputContentText.getText();
                if("ALL".equals(ToTargetName)) {
                    for(ConcurrentHashMap.Entry<String, ClientThread> entry: clientThreads.entrySet()) {
                        entry.getValue().SendMessage("MESSAGE@"+ToTargetName+"@SERVER@"+message);
                    }
                }else {
                    clientThreads.get(ToTargetName).SendMessage("MESSAGE@"+ToTargetName+"@SERVER@"+message);
                }
            }
        });
        OnlineClientList.addListSelectionListener(new ListSelectionListener() { //检验目标发送者是谁
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // TODO Auto-generated method stub
                int index = OnlineClientList.getSelectedIndex();
                if(index<0) {
                    Error("Server：消息目标用户下标错误");
                    return;
                }
                if(index == 0) {
                    ToTargetName = "ALL";
                }else {
                    String ToClientNickName = (String)OnlineClientNickName.getElementAt(index);
                    ToTargetName = ToClientNickName;
                }
                Success("成功修改消息目标用户为："+ToTargetName);
            }

        });
    }
    //4.3 输出消息内容
    private void Log(String message){
        //JLabel不支持\n换行，故添加html标签进行换行，没有</html>结束标签不影响显示
        LogsLabel.setText(LogsLabel.getText()+message+"<br />");
    }
    //4.4 输出错误信息
    private void Error(String message){
        //JLabel不支持\n换行，故添加html标签进行换行，没有</html>结束标签不影响显示
        LogsLabel.setText(LogsLabel.getText()+"<span color='red'>Error："+message+"</span>"+"<br />");
    }
    //4.4 输出成功信息
    private void Success(String message){
        //JLabel不支持\n换行，故添加html标签进行换行，没有</html>结束标签不影响显示
        LogsLabel.setText(LogsLabel.getText()+"<span color='green'>Success："+message+"</span>"+"<br />");
    }

    //5.服务器线程
    private class ServerThread1 implements Runnable{//在serverScoket.accept()的时候防止界面死锁
        //5.1 isRuning为true时，服务器不停的accept下一个连接
        boolean isRuning = true;
        //5.1构造函数
        public ServerThread1() {
            new Thread(this).start();
        }
        @Override
        //5.2线程开始后自动运行
        public void run() {
            //5.2.1 循环accept下一个socket连接
            while(isRuning) {
                if(!serverSocket.isClosed()) {
                    try {
                        Socket socket = serverSocket.accept();//这里要为每个即将连接的客户端新建一个socket，注：必须在try内部声明socket
                        ClientThread clientThread = new ClientThread(socket);//每接收到一个服务器请求，就为其新建一个客户线程
                        String ClientNickName = clientThread.getClientNickName();
                        clientThreads.put(ClientNickName, clientThread);//将每个客户端的线程都存在ConcurrentHashMap中
                        Success("为用户"+ClientNickName+"新建线程完毕");
                    } catch (IOException e) {
                        Error("Server：建立客户线程失败"+e.getMessage());
                    }
                }else {
                    Error("Server:服务器socket已关闭");
                }
            }
        }
    }

    //6.客户端线程
    public class ClientThread implements Runnable{//为每个客户端建立线程，并存在ConcurrentHashMap中，建立新的线程可防止等待用户输入时死锁
        //6.1 与该用户的socket相关输入输出
        private Socket socket;
        private BufferedReader input;
        private PrintStream output;

        //6.2 由于服务器主线程需要以客户端姓名为key，故需要调用getClientNickName()返回昵称
        private String ClientNickName;

        //6.3用于区分第一次连接和之后接收的消息
        boolean isRuning = false;

        //6.4 构造函数
        public ClientThread(Socket clientSocket) {
            this.socket = clientSocket;
            isRuning = Initialize();
            new Thread(this).start();
        }
        //6.5 第一次生成线程时（用户刚登陆时）调用
        public synchronized boolean Initialize() {
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintStream(socket.getOutputStream());
                //6.5.1 接收用户的输入数据
                String clientInputStr;
                clientInputStr = input.readLine();//readline运行时阻塞，故须建立客户端线程
                Log("Client："+clientInputStr);
                //6.5.2 检验信息头是否为LOGIN，是则向所有其他用户转发
                Tokenizer tokens = new Tokenizer(clientInputStr,"@");
                String MessageType = tokens.nextToken();
                if("LOGIN".equals(MessageType)) {
                    ClientNickName = tokens.nextToken();
                    OnlineClientNickName.addElement(ClientNickName);//服务端在线用户列表显示该用户昵称
                    Broadcast(clientInputStr);//向所有已登陆用户广播该用户登陆的信息
                    for(ConcurrentHashMap.Entry<String, ClientThread> entry: clientThreads.entrySet()) {
                        SendMessage("LOGIN@"+entry.getKey());
                    }
                }else {
                    Error("Server:初次接收的消息不为LOGIN");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Error("Server：Initialize无法读取下一行 "+e.getMessage());
            }
            Success("用户线程初始化完毕");
            return true;
        }
        @Override
        //6.6 线程开始时自动调用该方法
        public void run() {
            while(isRuning) {
                try {
                    //6.6.1接收用户的输入数据
                    String clientInputStr;
                    clientInputStr = input.readLine();
                    Log("Server："+clientInputStr);

                    //6.6.2按信息头部分类处理
                    Tokenizer tokens = new Tokenizer(clientInputStr,"@");
                    String MessageType = tokens.nextToken();
                    switch(MessageType) {
                        case "MESSAGE":{//消息
                            String ToClientNickName = tokens.nextToken();
                            if(ToClientNickName.equals("ALL")) {
                                //对消息进行广播转发
                                Broadcast(clientInputStr);
                                tokens.nextToken();
                                Log("Server：已将消息广播转发，消息内容为"+tokens.nextToken());
                            }else {
                                //对消息进行一对一的转发
                                clientThreads.get(ToClientNickName).SendMessage(clientInputStr);
                                Log("Server: 已将来自"+tokens.nextToken()+"的消息"+tokens.nextToken()+"转发给"+ToClientNickName);
                            }
                            break;
                        }
                        case "LOGOUT":{//登出
                            Broadcast(clientInputStr);
                            Log("Server：用户"+tokens.nextToken()+"退出");
                            break;
                        }
                        default : {
                            Error("Server: 服务器收到的消息格式错误");
                            break;
                        }
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Error("Server：run无法读取下一行 "+e.getMessage());
                }
            }

        }
        //6.7 返回该用户昵称
        public String getClientNickName() {
            return ClientNickName;
        }
        //6.8 发送消息
        public void SendMessage(String Message) {
            output.println(Message);
            output.flush();
        }
        //6.9 向全体在线账号发送消息
        public void Broadcast(String Message) {
            for(ConcurrentHashMap.Entry<String, ClientThread> entry: clientThreads.entrySet()) {
                entry.getValue().SendMessage(Message);
            }
        }

    }

    //7. 消息分割器
    public class Tokenizer{
        String Tokens[];
        int TokenIndex = 0;
        //7.1 将消息Message按照Delimiter分割
        public Tokenizer(String Message, String Delimiter) {
            Tokens = Message.split(Delimiter);
        }
        //7.2 返回下一个内容
        public String nextToken() {
            TokenIndex++;
            return Tokens[TokenIndex-1];
        }
    }

    public static void main(String arg[]) {
        Server server = new Server();
    }
}
