package WebSocket;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client {
    //1.以下为必须在外部声明的变量

    //1.1 UI组件
    JButton ConnectServer;//连接
    JButton DisconnectServer;//断开
    JButton SendMessageButton;//发送
    JTextField NickNameText;//昵称
    JTextField ServerIPAddressText;//服务器ip
    JTextField ServerPortText;//服务器端口
    JTextField InputContentText;//输入内容
    JList OnlineClientList;//在线列表
    JLabel ChatContentLabel;//聊天内容

    //1.2 socket相关
    Socket socket;//input和output是通过socket定义的，如果socket关闭了，其他两个也失效
    BufferedReader input;//input为服务器传来的数据
    PrintStream output;//output为向服务器输出的数据

    //1.3  用户昵称
    DefaultListModel<String> OnlineClientNickName;//在线用户昵称列表：向其中插入数据，自动将数据插入到JList中
    String ToTargetName = "ALL";//目标用户昵称：OnlineClientList的监听器对其修改

    //1.4客户端线程
    ClientThread cliendThread;

    //2.构造函数
    public Client() {
        //2.1 调用UI函数显示窗口
        CreateFrame();
    }

    //3.与连接服务器相关
    //3.1连接服务器
    public void ConnectServer() {
        //3.1.1 获取基本信息
        String ServerIPAddress = ServerIPAddressText.getText().trim();
        int ServerPort = Integer.parseInt(ServerPortText.getText().trim());
        String NickName = NickNameText.getText();

        try {
            //3.1.2 socket相关
            socket = new Socket(ServerIPAddress, ServerPort);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintStream(socket.getOutputStream());
            //3.1.2 在线列表添加所有人标签
            OnlineClientNickName.addElement("所有人");
            //3.1.3 向服务器发送本帐号登陆消息
            SendMessage("LOGIN@"+NickName);

            //3.1.4 为客户端建立线程
            cliendThread = new ClientThread();

        } catch (UnknownHostException e) {
            Error("Client：主机地址异常"+e.getMessage());
            return;
        } catch (IOException e) {
            Error("Client：连接服务器异常"+e.getMessage());
            return;
        }
    }
    //3.2 断开连接

    //3.3连接或断开时的按钮是否可点击设置


    //4. UI相关
    //4.1界面
    public void CreateFrame() {
        //4.1.1 总窗口
        JFrame ClientFrame = new JFrame("客户端");
        ClientFrame.setSize(800,600);//设置长宽，注意数值不需要引号
        ClientFrame.setLocationRelativeTo(null);//设置在屏幕中央显示
        ClientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭按钮，不设置也可以

        //4.1.2 客户端信息
        JPanel ClientIdPanel = new JPanel();
        ClientIdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));//4.2.1 设置客户端id栏的布局为浮动布局
        ClientIdPanel.setSize(800, 100);
        //4.1.2.2 昵称栏
        JLabel NickNameLabel = new JLabel("昵称");
        NickNameText = new JTextField(10);
        NickNameText.setText("jiangbowen");
        ClientIdPanel.add(NickNameLabel);
        ClientIdPanel.add(NickNameText);
        //4.1.2.3 服务器IP地址
        JLabel ServerIPAddressLabel = new JLabel("IP地址");
        ServerIPAddressText = new JTextField(10);
        ServerIPAddressText.setText("127.0.0.1");
        ClientIdPanel.add(ServerIPAddressLabel);
        ClientIdPanel.add(ServerIPAddressText);
        //4.1.2.4 端口号
        JLabel ServerPortLabel = new JLabel("端口");
        ServerPortText = new JTextField(10);
        ServerPortText.setText("8288");
        ClientIdPanel.add(ServerPortLabel);
        ClientIdPanel.add(ServerPortText);
        //4.1.2.5 连接服务器/断开连接
        ConnectServer = new JButton("连接");
        DisconnectServer = new JButton("断开");
        ClientIdPanel.add(ConnectServer);
        ClientIdPanel.add(DisconnectServer);
        //4.1.2.6 设置标题
        ClientIdPanel.setBorder(new TitledBorder("用户信息栏"));

        //4.1.3 好友列表
        JPanel FriendListPanel = new JPanel();
        FriendListPanel.setPreferredSize(new Dimension(200,400));
        FriendListPanel.setBorder(new TitledBorder("好友列表"));
        //4.1.3.1 好友列表内容
        OnlineClientNickName = new DefaultListModel<String>();
        OnlineClientList = new JList(OnlineClientNickName);
        FriendListPanel.add(OnlineClientList);

        //4.1.4 聊天内容面板
        JPanel ChatContentPanel = new JPanel();
        ChatContentPanel.setPreferredSize(new Dimension(490,400));
        ChatContentPanel.setBorder(new TitledBorder("聊天内容"));
        //4.1.4.1 声明聊天内容标签
        ChatContentLabel = new JLabel("<html>");
        ChatContentLabel.setPreferredSize(new Dimension(490,400));
        ChatContentPanel.add(ChatContentLabel);

        //4.1.5 输入内容面板
        JPanel InputContentPanel = new JPanel();
        InputContentPanel.setPreferredSize(new Dimension(600,100));
        //4.1.5.1 聊天输入框
        InputContentText = new JTextField();
        InputContentText.setPreferredSize(new Dimension(600,60));
        //4.1.5.2 发送按钮
        SendMessageButton = new JButton("发送");
        InputContentPanel.add(InputContentText);
        InputContentPanel.add(SendMessageButton);
        InputContentPanel.setBorder(new TitledBorder("输入内容"));

        //4.1.6 客户端整体布局
        ClientFrame.add(ClientIdPanel, BorderLayout.NORTH);
        ClientFrame.add(FriendListPanel, BorderLayout.WEST);
        ClientFrame.add(ChatContentPanel,BorderLayout.CENTER);
        ClientFrame.add(InputContentPanel,BorderLayout.SOUTH);

        //4.1.7设置可见
        ClientFrame.setVisible(true);	//设置可见必须在所有内容都add进Frame之后

        //4.1.8 添加监听事件
        AddActionListener();
    }
    //4.2 添加事件监听
    private void AddActionListener() {
        //4.2.1 点击连接
        ConnectServer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConnectServer();
            }
        });
        //4.2.2 点击断开
        DisconnectServer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        //4.2.3 点击发送
        SendMessageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = InputContentText.getText().trim();
                SendMessage("MESSAGE@"+ToTargetName+"@"+NickNameText.getText()+"@"+message);
            }
        });

        //4.2.4 检验目标发送者是谁
        OnlineClientList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = OnlineClientList.getSelectedIndex();
                if(index<0) {
                    Error("Client：检测到目标发送者下标为负数");
                    return;
                }
                if(index == 0) {
                    ToTargetName = "ALL";
                }else {
                    String ToClientNickName = (String)OnlineClientNickName.getElementAt(index);
                    ToTargetName = ToClientNickName;
                }
            }
        });
    }
    //4.3 输出错误（红色）
    private void Error(String message){
        //JLabel不支持\n换行，故添加html标签进行换行，没有</html>结束标签不影响显示
        ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='red'>"+message+"</span>"+"<br />");
    }

    //4.4 输出上线下线内容
    private void Log(String message){
        //JLabel不支持\n换行，故添加html标签进行换行，没有</html>结束标签不影响显示
        ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='blue'>"+message+"</span>"+"<br />");
    }
    //4.5 输出私聊内容
    private void Message(String message){
        //JLabel不支持\n换行，故添加html标签进行换行，没有</html>结束标签不影响显示
        ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='black'>"+message+"</span>"+"<br />");
    }
    //4.6 输出广播内容
    private void MessageTotal(String message){
        //JLabel不支持\n换行，故添加html标签进行换行，没有</html>结束标签不影响显示
        ChatContentLabel.setText(ChatContentLabel.getText()+"<span color='green'>"+message+"</span>"+"<br />");
    }


    //5. 客户端线程 内部类
    public class ClientThread implements Runnable{
        //与服务器建立连接时，新建客户端线程，否则无法接收信息
        //与服务器断开连接时，向服务器告知，杀掉客户端进程
        //客户端调用readline时会产生死锁，故需要新建一个线程
        boolean isRuning = true;
        //5.1 构造函数
        public ClientThread () {
            //5.1.1 开始本线程
            new Thread(this).start();
        }
        @Override
        //5.2 run函数会在线程开始时自动调用
        public void run() {
            while(isRuning) {//循环用于重复接收消息，客户端断开连接之前不停止
                // TODO Auto-generated method stub
                String message;
                try {
                    //5.2.1 在服务器传来的消息中读取下一行
                    //readline会产生死锁，如果没有下一条消息则继续等待
                    //正是因为死锁，才要新建一个客户端线程
                    message = input.readLine();
                    Tokenizer tokens = new Tokenizer(message, "@");//对原有消息进行分割
                    String MessageType = tokens.nextToken();

                    //5.2.2根据人为定义的传输协议对消息进行显示
                    switch(MessageType) {
                        case "LOGIN":{//其他用户上线
                            String LoginClientNickName = tokens.nextToken();
                            Log("上线通知：用户"+LoginClientNickName+"已上线");
                            OnlineClientNickName.addElement(LoginClientNickName);
                            break;
                        }

                        case "MESSAGE":{//聊天消息
                            String ToClientNickName = tokens.nextToken();
                            String FromClientNickName = tokens.nextToken();
                            String content = tokens.nextToken();
                            if("ALL".equals(ToClientNickName)) {
                                MessageTotal("来自"+FromClientNickName+ "对全体的消息："+content);
                            }else {
                                Message("来自"+FromClientNickName+ "对您的私聊消息："+content);
                            }
                            break;
                        }

                        case "LOGOUT":{//其他用户下线的消息

                            break;
                        }
                        default :{
                            Error("客户端接收消息格式错误");
                            break;
                        }
                    }
                    System.out.println("客户端接收到"+message);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Error("Client：客户端接收消息失败"+ e.getMessage());
                }
            }
        }
    }

    //6. 消息相关
    //6.1 发送消息
    public void SendMessage(String message) {
        output.println(message);
        output.flush();
    }

    //6.2 消息分割器（内部类）
    public class Tokenizer{
        String Tokens[];
        int TokenIndex = 0;
        //6.2.1 构造方法，把Message，按Delimiter进行分割
        public Tokenizer(String Message, String Delimiter) {
            Tokens = Message.split(Delimiter);
        }
        //6.2.2 获取下一项
        public String nextToken() {
            TokenIndex++;
            return Tokens[TokenIndex-1];
        }
    }

    public static void main(String srgs[]) {
        Client client = new Client();
    }
}
