package com.hongjianjie.notes.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hongjianjie.notes.dao.UserDao;
import com.hongjianjie.notes.entity.User;

/**
 * 管理员界面
 * @author JJ
 *
 */
public class AdminMainFrm extends JFrame {

	private JPanel contentPane;
	private JTable usertable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrm frame = new AdminMainFrm();
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
	public AdminMainFrm() throws Exception {
		setTitle("管理员界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
		);
		
		usertable = new JTable();
		usertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					usertableMousePressed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		usertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6635\u79F0", "\u8D26\u53F7", "\u7B14\u8BB0\u6807\u9898"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		usertable.getColumnModel().getColumn(0).setPreferredWidth(143);
		usertable.getColumnModel().getColumn(1).setPreferredWidth(142);
		usertable.getColumnModel().getColumn(2).setPreferredWidth(342);
		usertable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		scrollPane.setViewportView(usertable);
		contentPane.setLayout(gl_contentPane);
		
		DefaultTableModel dtm=(DefaultTableModel) usertable.getModel();
		dtm.setRowCount(0); // 清空表格
		UserDao userDao = new UserDao();
		ResultSet rs =  userDao.userList1();
		while(rs.next()) {
			Vector v=new Vector();
			v.add(rs.getString("petname"));
			v.add(rs.getString("accout"));
			v.add(rs.getString("notetitle"));
			dtm.addRow(v);
		}
		userDao.closeDao();
		this.setLocationRelativeTo(null);// 设置JFrame居中显示
		
	}

	
	//表格点击事件
	private void usertableMousePressed(MouseEvent ae) throws Exception {
		// TODO Auto-generated method stub
		int row=usertable.getSelectedRow();//鼠标点击后返回的行号
		User user = new User();
		user.setAccout((String)usertable.getValueAt(row, 1));
		UserDao userDao = new UserDao();
		User user1;
		user1 = userDao.userLoginWithAccout(user);
		userDao.closeDao();
		new UserIfromationFrm(user1).setVisible(true);
	}

}
