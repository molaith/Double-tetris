package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayControl extends JPanel {
	     
	
	   JLabel score1=new JLabel("���1");
	   JLabel score2=new JLabel("���2");
	   CustomButton pause=new CustomButton("��ͣ");
	   CustomButton restart = new CustomButton("����");
	   CustomButton back=new CustomButton("���˵�");
	   CustomButton exit = new CustomButton("�˳���Ϸ");
	   test _testFrame;
	  
	   public PlayControl(test tTest) {
		this._testFrame=tTest;
		   
		score1.setFont(new Font("΢���ź�", Font.BOLD, 20));
		score2.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		pause.setFont(new Font("΢���ź�", Font.BOLD, 20));
		restart.setFont(new Font("΢���ź�", Font.BOLD, 20));
		back.setFont(new Font("΢���ź�", Font.BOLD, 20));
		exit.setFont(new Font("΢���ź�", Font.BOLD, 20));
		
		pause.setPreferredSize(new Dimension(100, 50));
		restart.setPreferredSize(new Dimension(100, 50));
		back.setPreferredSize(new Dimension(100, 50));
		exit.setPreferredSize(new Dimension(100, 50));
		
		add(score1);
		add(pause);
		add(restart);
		add(back);
		add(exit);
		add(score2);
		
		
		
	}

	
}
