package jstx;

import javax.swing.*;

public class KaiShi {
    private JFrame frame;
    private JLabel labelUser;
    private JLabel labelPwd;
    private JTextArea textArea;
    private JCheckBox checkBoxJiZhu;
    private JCheckBox checkBoxWangJi;
    private JButton buttonOK;

    public KaiShi() {
        frame = new JFrame();
        labelUser = new JLabel();
        labelPwd = new JLabel();
        checkBoxJiZhu = new JCheckBox();
        checkBoxWangJi = new JCheckBox();
        buttonOK = new JButton();

        frame.setBounds(500,360,600,600);
        frame.setLayout(null);
        frame.setVisible(true);

        labelUser.setText("用户名");
        labelUser.setLocation(75,200);
        labelPwd.setText("密码");
        labelPwd.setLocation(75,400);

        checkBoxJiZhu.setLocation(75,500);
        checkBoxWangJi.setLocation(175,500);
    }


}
