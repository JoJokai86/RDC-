package com.hongjianjie.notes.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hongjianjie.notes.dao.UserDao;
import com.hongjianjie.notes.entity.User;

/**
 * 用户主界面
 * @author JJ
 *
 */
public class UserMainFrm extends JFrame {

	private JPanel contentPane;
	private JTextField petnametextField;
	private JTable usertable;
	private JTextField searchtextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton notetitlerdbtnNewRadioButton;
	private JRadioButton petnamerdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainFrm frame = new UserMainFrm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public UserMainFrm(User user) throws Exception {
		setTitle("用户主界面");
		setBounds(100, 100, 712, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("个人信息");
		btnNewButton_1.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/base.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new UserIfromationFrm(user).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("当前用户");
		lblNewLabel_2.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/account.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		petnametextField = new JTextField();
		petnametextField.setColumns(10);
		petnametextField.setText(user.getPetname());
		petnametextField.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("搜索方式：");
		lblNewLabel.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/searchtype.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		petnamerdbtnNewRadioButton = new JRadioButton("用户昵称");
		buttonGroup.add(petnamerdbtnNewRadioButton);
		
		notetitlerdbtnNewRadioButton = new JRadioButton("笔记标题");
		buttonGroup.add(notetitlerdbtnNewRadioButton);
		notetitlerdbtnNewRadioButton.setSelected(true);
		
		searchtextField = new JTextField();
		searchtextField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon(UserMainFrm.class.getResource("/images/search.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					search(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 469, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(22)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(petnametextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(notetitlerdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(21)
													.addComponent(btnNewButton))
												.addComponent(petnamerdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))))
									.addGap(239)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addGap(24))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(petnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(notetitlerdbtnNewRadioButton)
								.addComponent(petnamerdbtnNewRadioButton))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
		);
		
		usertable = new JTable();
		usertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					notetableMousePressed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		usertable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		usertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u6635\u79F0", "\u7B14\u8BB0\u6807\u9898"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		usertable.getColumnModel().getColumn(0).setPreferredWidth(135);
		usertable.getColumnModel().getColumn(1).setPreferredWidth(520);
		scrollPane.setViewportView(usertable);
		contentPane.setLayout(gl_contentPane);
		
		DefaultTableModel dtm=(DefaultTableModel) usertable.getModel();
		dtm.setRowCount(0); // 设置成0行，清空表格
		UserDao userDao = new UserDao();
		ResultSet rs =  userDao.userList();
		while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("petname"));
			v.add(rs.getString("notetitle"));
			dtm.addRow(v);
		}//用迭代器进行遍历，线程安全
		userDao.closeDao();
		this.setLocationRelativeTo(null);// 设置JFrame居中显示
	}

	/**
	 * 通过昵称或者笔记标题进行搜索
	 * @param ae
	 * @throws Exception
	 */
	private void search(ActionEvent ae) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		User user1 = new User();
		user1 = null;
		UserDao userDao = new UserDao();
		if(searchtextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "用户昵称或笔记标题不能为空！");
            return;
		}
		if(petnamerdbtnNewRadioButton.isSelected()) {
			user.setPetname(searchtextField.getText());
			 user1 = userDao.userLoginWithPetname(user);
			if(user1 == null) {
				JOptionPane.showMessageDialog(null, "该用户昵称不存在！");
	            return;
			}else {
				new NoteFrm(user1).setVisible(true);
			}
		}else if(notetitlerdbtnNewRadioButton.isSelected()){
			user.setNotetitle(searchtextField.getText());
			user1 = userDao.searchWithNotetitle(user);
			if(user1 == null) {
				JOptionPane.showMessageDialog(null, "该笔记标题不存在！");
	            return;
			}else {
				new NoteFrm(user1).setVisible(true);
			}
		}
	}

	/**
	 * 鼠标点击事件
	 * @param ae
	 * @throws Exception
	 */
	private void notetableMousePressed(MouseEvent ae) throws Exception {
		// TODO Auto-generated method stub
		int row=usertable.getSelectedRow();//鼠标点击后返回的行号
		User user = new User();
		user.setPetname((String)usertable.getValueAt(row, 0));
		user.setIsopen(true);
		UserDao userDao = new UserDao();
		User user1;
		user1 = userDao.userLoginWithPetname(user);
		userDao.closeDao();
		new NoteFrm(user1).setVisible(true);
		
	}
}
