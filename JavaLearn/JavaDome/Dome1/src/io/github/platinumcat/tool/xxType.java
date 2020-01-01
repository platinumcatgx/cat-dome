package io.github.platinumcat.tool;

public enum xxType {
    message_success{//登陆成功
        public int getNum(){
            return 1;
        }
    },
    message_login_fail{//登陆失败
        public int getNum(){
            return 2;
        }
    },
    message_common_message{//普通数据包
        public int getNum(){
            return 3;
        }
    },
    message_get_OnlineFriend{//请求在线好友
        public int getNum(){
            return 4;
        }
    },
    message_receive_OnlineFriend{//返回在线好友
        public int getNum(){
            return 5;
        }
    },
    message_receive_QQNumNoExist{//注册QQ号码成功
        public int getNum(){
            return 6;
        }
    },
    message_receive_QQNumYesExist{//注册QQ号码失败
        public int getNum(){
            return 7;
        }
    }
}
