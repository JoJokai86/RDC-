package com.hongjianjie.notes.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.hongjianjie.notes.dao.AdminDao;
import com.hongjianjie.notes.dao.UserDao;
import com.hongjianjie.notes.entity.Admin;
import com.hongjianjie.notes.entity.User;
import com.hongjianjie.notes.entity.UserType;
import com.hongjianjie.notes.util.StringUtil;

/**
 * 登录界面设计:包括管理员，用户登录和用户注册
 * @author JJ
 *
 */
public class LoginFrm extends JFrame {

    private JPanel contentPane;
    private JTextField account;
    private JPasswordField password;
    private JComboBox userType;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrm frame = new LoginFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginFrm() {
        setTitle("注册登录界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 637, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("    本地笔记系统");
        lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/notebook.png")));
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));

        JLabel lblNewLabel_1 = new JLabel("账 号:");
        lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/account.png")));
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        account = new JTextField();
        account.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("密 码：");
        lblNewLabel_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/password.png")));
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        password = new JPasswordField();

        JLabel lblNewLabel_3 = new JLabel("用户类型:");
        lblNewLabel_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userType.png")));
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        userType = new JComboBox();
        userType.setModel(new DefaultComboBoxModel(new UserType[] {UserType.USERLOGIN,UserType.USERREGIST,UserType.ADMIN}));
        userType.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        JButton loginButton = new JButton("登录/注册");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	try {
					loginAct(ae);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/land.png")));

        JButton resertButton = new JButton("重置");
        resertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                resertValue(ae);
            }
        });
        resertButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));
        resertButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(203)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(160)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(lblNewLabel_2)
                                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(password, 192, 192, 192)
                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1)
                                                                .addGap(17)
                                                                .addComponent(account, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))))
                                .addGap(247))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(156)
                                .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(7)
                                .addComponent(userType, 0, 168, Short.MAX_VALUE)
                                .addGap(249))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(128)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addGap(85)
                                .addComponent(resertButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(169, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(32)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(27)
                                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(32)
                                                                .addComponent(account, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(59)
                                                .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(46)
                                                                .addComponent(lblNewLabel_3))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(44)
                                                                .addComponent(userType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(201)
                                                .addComponent(lblNewLabel_2)))
                                .addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(resertButton))
                                .addGap(38))
        );
        contentPane.setLayout(gl_contentPane);

        this.setLocationRelativeTo(null);// 设置JFrame居中显示
    }

    /**
     * 登录操作
     * @param ae
     * @throws Exception
     */
    protected void loginAct(ActionEvent ae) throws Exception {
		// TODO Auto-generated method stub
    	String account = this.account.getText().toString();
    	String password=new String(this.password.getPassword());
    	UserType selectedItem = (UserType)userType.getSelectedItem();
		if(StringUtil.isEmpty(account)) {
			JOptionPane.showMessageDialog(this,"账号不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this,"密码不能为空");
			return;
		}
		
		if("用户注册".equals(selectedItem.getName())) {
			UserDao userDao = new UserDao();
			User user =new User();
			user.setAccout(account);
			user.setPassword(password);
			//user.setNotenumber(1);
			try {
				userDao.add(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userDao.closeDao();
			JOptionPane.showMessageDialog(this, "注册成功");
		}else if("用户登录".equals(selectedItem.getName())) {
			UserDao userDao = new UserDao();
			User user1 = new User();
			user1.setAccout(account);
			user1.setPassword(password);
			User user2 = new User();
			user2 = userDao.userLogin(user1);
			userDao.closeDao();
			if(user2 == null) {
				JOptionPane.showMessageDialog(this, "账号或密码错误！");
				return;
			}
			this.dispose();
			new UserMainFrm(user2).setVisible(true);
		}else {
			AdminDao adminDao = new AdminDao();
			Admin admin1 = new Admin();
			admin1.setAccout(account);
			admin1.setPassword(password);
			Admin admin2 = new Admin();
			admin2 = adminDao.adminLogin(admin1);
			adminDao.closeDao();
			if(admin2 == null) {
				JOptionPane.showMessageDialog(this, "账号或密码错误！");
				return;
			}
			this.dispose();
			new AdminMainFrm().setVisible(true);
		}
	}
/**
 * 重置事件
 * @param ae
 */
	protected void resertValue(ActionEvent ae) {
        // TODO Auto-generated method stub
        account.setText("");
        password.setText("");
        userType.setSelectedIndex(0);
    }
}
