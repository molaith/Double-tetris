package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

public class GameOverDialog extends JDialog implements ActionListener{
    CustomButton over=new CustomButton("��Ϸ�������������");
    public GameOverDialog() {
		super();
		add(over);
		over.setFont(new Font("΢���ź�", Font.BOLD, 20));
		setVisible(false);
		setSize(400, 400);
		over.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		
	}
    
    
    
}
