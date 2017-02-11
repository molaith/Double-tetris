package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel {
	Image image=Toolkit.getDefaultToolkit().createImage("background1.png");
	
	JTextArea helpText=new JTextArea(1,50);
	
	CustomButton back = new CustomButton("���˵�");

	
	public HelpPanel(){
		GridBagLayout gbL=new GridBagLayout();
		GridBagConstraints gbC=new GridBagConstraints();
		setLayout(gbL);
		
		gbC.gridx=2;gbC.gridy=1;
	   	gbC.gridwidth=1;gbC.gridheight=1;
	   	
	 	gbC.insets=new Insets(10, 5, 5, 5);
	   	
	   
	   	helpText.setFont(new Font("����", Font.BOLD, 20));
	   	helpText.setLineWrap(true);
	   	helpText.append("����ŨŨ��ս�𲻶�\n\n");
	   	helpText.append("��Ϸ���ܣ�\n\n");
	   	helpText.append("����Ϸ��һ���ԡ������ǡ�Ϊ�����˫�˶���˹���顣��Ϸ��Ϊ����ģʽ������ģʽ�Ͷ�սģʽ����ѡ����Ϸģʽ������Ϸ��Ĭ��Ϊ��������ģʽ������ģʽ��������ʹ��ͬһ����ͬʱ�����������飬ÿ���˿���һ����������С����֣�������Ч���ܿ�������Ч��������Чһ����Ϊ����������������л�����սģʽ����սģʽΪ���������˷ֱ�����Լ��ķ��飬������С����֣�������Ч�Ĺ��ܡ�\n");
	   	helpText.append("��Ϸ����:\n\n");
	   	helpText.append("���1��   A����   D����  S��������\n");
	   	helpText.append("���2��   ������  ������  ����������\n\n");
	   	helpText.append("������Ч��Ҫ������Ч���ڵ�һ�вſɼ�����\n");
	   	helpText.setBackground(Color.CYAN.darker().darker());
	   	helpText.setForeground(Color.WHITE);
	   	gbL.setConstraints(helpText, gbC);
	   	add(helpText);
	   	
	   	gbC.ipadx=80;gbC.ipady=30;
	   	gbC.fill=GridBagConstraints.BOTH;
	   	gbC.gridx=2;gbC.gridy=3;
		gbL.setConstraints(back, gbC);
	   	add(back);
	   	validate();
	   	
	   	
	}
    protected void paintComponent(Graphics g) {
    	
	 g.drawImage(image, 0, 0, this);

	}
}
