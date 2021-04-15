package com.hongjianjie.notes.view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hongjianjie.notes.entity.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

/**
 * 笔记详情界面
 * @author JJ
 *
 */
public class NoteFrm extends JFrame {

	private JPanel contentPane;
	private JTextField notetitletextField;
	private JTextField petnametextField;
	private JTextArea notetextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoteFrm frame = new NoteFrm(null);
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
	public NoteFrm(User user) {
		setTitle("笔记详情");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("笔记标题：");
		lblNewLabel.setIcon(new ImageIcon(NoteFrm.class.getResource("/images/title.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		notetitletextField = new JTextField();
		notetitletextField.setEditable(false);
		notetitletextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		notetitletextField.setColumns(10);
		notetitletextField.setText(user.getNotetitle());
		
		JLabel lblNewLabel_1 = new JLabel("用户昵称：");
		lblNewLabel_1.setIcon(new ImageIcon(NoteFrm.class.getResource("/images/accout.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		petnametextField = new JTextField();
		petnametextField.setEditable(false);
		petnametextField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		petnametextField.setColumns(10);
		petnametextField.setText(user.getPetname());
		
		notetextArea = new JTextArea();
		notetextArea.setEditable(false);
		notetextArea.setText(user.getNote());
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(notetextArea, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(12)
							.addComponent(notetitletextField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
							.addGap(51)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(16)
							.addComponent(petnametextField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
							.addGap(46))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(notetitletextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(petnametextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(notetextArea, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		// 设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
