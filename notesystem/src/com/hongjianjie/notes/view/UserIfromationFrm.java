package com.hongjianjie.notes.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.hongjianjie.notes.dao.UserDao;
import com.hongjianjie.notes.entity.User;
import com.hongjianjie.notes.util.StringUtil;
import javax.swing.ImageIcon;

/**
 * 用户信息界面
 * @author JJ
 *
 */
public class UserIfromationFrm extends JFrame {

	private JPanel contentPane;
	private JTextField accouttextField;
	private JTextField petnametextField;
	private JTextField passwordtextField;
	private JTextField notetitletextField;
	private JTextArea notetextArea;
	private JLabel lblNewLabel_4;
	private JRadioButton publicrdbtnNewRadioButton;
	private JRadioButton privaterdbtnNewRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField currentnotenumbertextField;
	private JTextField searchnotenumbertextField;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	int number;
	User user1 = new User();
	User user2 = new User();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserIfromationFrm frame = new UserIfromationFrm(null);
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
	public UserIfromationFrm(User user) {
		setTitle("用户信息");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("账号");
		lblNewLabel.setIcon(new ImageIcon(UserIfromationFrm.class.getResource("/images/accout.png")));
		
		JLabel lblNewLabel_1 = new JLabel("昵称");
		lblNewLabel_1.setIcon(new ImageIcon(UserIfromationFrm.class.getResource("/images/petname.png")));
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setIcon(new ImageIcon(UserIfromationFrm.class.getResource("/images/password1.png")));
		
		//accouttextField.setEditable(false);
		accouttextField = new JTextField();
		accouttextField.setEditable(false);
		accouttextField.setText((String)user.getAccout());
		accouttextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		accouttextField.setColumns(10);
		
		petnametextField = new JTextField();
		petnametextField.setText((String)user.getPetname());
		petnametextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		petnametextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setText((String)user.getPassword());
		passwordtextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		passwordtextField.setColumns(10);
		
		currentnotenumbertextField = new JTextField();
		currentnotenumbertextField.setEditable(false);
		currentnotenumbertextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		currentnotenumbertextField.setColumns(10);
		currentnotenumbertextField.setText(String.valueOf(user.getNotenumber()));//(String)user.getNotenumber()行不通
		if(!currentnotenumbertextField.getText().equals("1")) {
			accouttextField.setEditable(false);
			petnametextField.setEditable(false);
			passwordtextField.setEditable(false);
		}
		
		
		JLabel lblNewLabel_3 = new JLabel("笔记标题：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		notetitletextField = new JTextField();
		notetitletextField.setFont(new Font("宋体", Font.PLAIN, 14));
		notetitletextField.setColumns(10);
		notetitletextField.setText(user.getNotetitle());
		
		JButton btnNewButton = new JButton("修改信息");
		btnNewButton.setIcon(new ImageIcon(UserIfromationFrm.class.getResource("/images/revise.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				revise(ae,user) ;
			}
		});
		
		notetextArea = new JTextArea();
		notetextArea.setText("笔记");
		notetextArea.setText(user.getNote());
		
		lblNewLabel_4 = new JLabel("笔记是否公开：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		publicrdbtnNewRadioButton = new JRadioButton("公开");
		buttonGroup.add(publicrdbtnNewRadioButton);
		
		privaterdbtnNewRadioButton = new JRadioButton("私密");
		buttonGroup.add(privaterdbtnNewRadioButton);
		if(user.isIsopen()==true) {
			publicrdbtnNewRadioButton.setSelected(true);
		}else {
			privaterdbtnNewRadioButton.setSelected(true);
		}
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel("查看笔记篇数：");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_8 = new JLabel("当前为笔记篇数：");
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		
		searchnotenumbertextField = new JTextField();
		searchnotenumbertextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		searchnotenumbertextField.setColumns(10);
		
		//User user1 = new User();
		JButton btnNewButton_1 = new JButton("查看");
		btnNewButton_1.setIcon(new ImageIcon(UserIfromationFrm.class.getResource("/images/rearch1.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(StringUtil.isEmpty(searchnotenumbertextField.getText())) {
					JOptionPane.showMessageDialog(null,"查看笔记篇数不能为空！");
					return;
				}
				
				user1 = user;
				UserDao userDao = new UserDao();
				user1.setNotenumber(Integer.parseInt(searchnotenumbertextField.getText()));//Integer.parseInt(searchnotenumbertextField.getText())
				try {
					user2 = userDao.searchWithNoteNumber(user1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				userDao.closeDao();
				if(user2==null) {
					JOptionPane.showMessageDialog(null,"查看笔记篇数不存在！");
					return;
				}
				seenote(e,user2);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		btnNewButton_2 = new JButton("删除当前笔记");
		btnNewButton_2.setIcon(new ImageIcon(UserIfromationFrm.class.getResource("/images/delete.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletenote(e,user);
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		btnNewButton_3 = new JButton("发布新笔记");
		btnNewButton_3.setIcon(new ImageIcon(UserIfromationFrm.class.getResource("/images/add.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user1 = user;
				user1.setNotetitle(null);
				user1.setNote(null);
				UserDao userDao = new UserDao();
				try {
					number = userDao.postNote(user1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				userDao.closeDao();
				user1.setNotenumber(number);
				postnewnote(e,user1);
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(notetextArea, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(accouttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(55)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_4)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(publicrdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
													.addComponent(privaterdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_8, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
										.addComponent(petnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(notetitletextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(btnNewButton)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(currentnotenumbertextField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addComponent(searchnotenumbertextField, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(81)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(82)
									.addComponent(btnNewButton_2)))
							.addGap(134))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(accouttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_8)
						.addComponent(currentnotenumbertextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(petnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(notetitletextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_6)
										.addComponent(publicrdbtnNewRadioButton))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(privaterdbtnNewRadioButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(7)
									.addComponent(btnNewButton_1)))
							.addGap(1)
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(searchnotenumbertextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(notetextArea, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addComponent(btnNewButton_3)
					.addGap(444))
		);
		contentPane.setLayout(gl_contentPane);
		// 设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
}
/**
 * 删除笔记
 * @param e
 * @param user
 */
private void deletenote(ActionEvent e,User user) {
		// TODO Auto-generated method stub
	int n=JOptionPane.showConfirmDialog(null, "确定要删除该笔记吗？");
	if(n==0) {
		UserDao userDao = new UserDao();
		try {
			userDao.deleteNote(user);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		userDao.closeDao();
		this.dispose();
	}
	
		
	}

/**
 * 发布新笔记
 * @param e
 * @param user
 */
private void postnewnote(ActionEvent e, User user) {
		// TODO Auto-generated method stub
	new UserIfromationFrm(user).setVisible(true);
	}

private void seenote(ActionEvent e,User user1) {
		// TODO Auto-generated method stub
	new UserIfromationFrm(user1).setVisible(true);
	}

private void revise(ActionEvent ae,User user) {
	UserDao userDao = new UserDao();
	User user1 =new User();
	user1 = user;
	user1.setPassword(passwordtextField.getText());
	if(user.getPassword().isEmpty()) {
		JOptionPane.showMessageDialog(null, "密码不能为空！");
        return;
	}
	user1.setPetname(petnametextField.getText());
	if(user.getPetname().isEmpty()) {
		JOptionPane.showMessageDialog(null, "昵称不能为空！");
        return;
	}
	
	user1.setNotetitle(notetitletextField.getText());
	if(user.getNotetitle().isEmpty()) {
		JOptionPane.showMessageDialog(null, "笔记标题不能为空！");
        return;
	}
	
	user1.setNote(notetextArea.getText());
	if(user.getNote().isEmpty()) {
		JOptionPane.showMessageDialog(null, "笔记不能为空！");
        return;
	}
	
	if(publicrdbtnNewRadioButton.isSelected()) {
		user1.setIsopen(true);
	}else {
		user1.setIsopen(false);
	}
	try {
		if(userDao.update(user1)!=0) {
			JOptionPane.showMessageDialog(null, "修改成功");
		}
	} catch (HeadlessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}






