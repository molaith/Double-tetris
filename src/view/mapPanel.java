package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.omg.CORBA.INTERNAL;

import shape.absShape;
import shape.shapeI;
import shape.shapeT;
import shape.shapeLeftL;
import shape.shapeRightL;
import shape.shapeLeftZ;
import shape.shapeRightZ;
import shape.shapeSquare;

public class mapPanel extends JPanel implements KeyListener, Runnable {
	public static final int ROWS = 18, COLS = 24;
	public static final int FastInterval = 100, SlowInterval = 500;

	private int interval = SlowInterval; // �̵߳����ػ淽����ʱ����
	private int vanishLines; // ��������
	private int score1; // ����1
	private int score2; // ����2
	private int style;
	private test _testframe = null;
	private boolean isPause = false;
	public absShape[] dqfk = new absShape[2]; // �������������������,��ǰ����
	private Image[] pic = new Image[2]; // ��������䷽��ͼƬ
	private Image background;

	public int[][] map = new int[COLS][ROWS]; // 24��,18��

	public void setDqfk(absShape setdqfk1, absShape setdqfk2) {
		dqfk[0] = setdqfk1;
		dqfk[1] = setdqfk2;
	}
	public void setPause(boolean isPause){
			this.isPause=isPause;
	}
	public int getInterval(){
		return interval;
	}
	public int getStyle(){
		return style;
	}

	public void setRandomShape(int i) {
		int shapeStyle = (int) (Math.random() * 6);// �����״
		switch (shapeStyle) { // ���޸ĺ�Ϊһ������
		case (0):
			dqfk[i] = new shapeI(this);
			break;
		case (1):
			dqfk[i] = new shapeLeftZ(this);
			break;
		case (2):
			dqfk[i] = new shapeRightZ(this);
			break;
		case (3):
			dqfk[i] = new shapeLeftL(this);
			break;
		case (4):
			dqfk[i] = new shapeRightL(this);
			break;
		case (5):
			dqfk[i] = new shapeT(this);
			break;
		case (6):
			dqfk[i] = new shapeSquare(this);
			break;
		}
		dqfk[i].setMap(map);
		dqfk[i].reset(i);
	}

	public mapPanel(int style, test testframe) {
		pic[0] = Toolkit.getDefaultToolkit().getImage("A.png");
		pic[1] = Toolkit.getDefaultToolkit().getImage("B.png");
		background = Toolkit.getDefaultToolkit().getImage("PlayBackgound.jpg");
		this.style = style; // ��սģʽ������ģʽ
		this._testframe = testframe;

		for (int i = 0; i < 2; i++) {
			setRandomShape(i);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, 630, 500, this);
		// ���������24*18�ĸ���
		g.setColor(Color.black);
		for (int i = 0; i < 25; i++) {
			g.drawLine(i * 25, 0, i * 25, 18 * 25);
		}
		for (int j = 0; j < 19; j++) {
			g.drawLine(0, j * 25, 24 * 25, j * 25);
		}
		g.setColor(Color.red);
		g.drawLine(12 * 25, 0, 12 * 25, 18 * 25);
		// ���Ƶ�ǰ����
		g.setColor(Color.orange);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) { // ���Ƶ�ǰ�����е�С���������е�ÿһ��С����
				int m = dqfk[i].smallblock[j].m;
				int n = dqfk[i].smallblock[j].n;
				// g.fill3DRect(m*25,n*25,25,25,true);
				g.drawImage(pic[i], m * 25, n * 25, 25, 25, this);
			}
		}

		// ����map��Ϊ1��λ��,�ϰ���
		g.setColor(Color.cyan);
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 18; j++) {
				if (map[i][j] == 1) {
					g.fill3DRect(i * 25, j * 25, 25, 25, true);
					g.drawImage(pic[0], i * 25, j * 25, 25, 25, this);
				}
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		// 1���ұߣ�0�����
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			// ��ת
			if (dqfk[1].canTurn())
				dqfk[1].turn();
			this.repaint(); // ����ˢ��
			break;
		case KeyEvent.VK_DOWN:
			// ����
			interval = FastInterval;
			break;
		case KeyEvent.VK_LEFT:
			if (dqfk[1].canMoveLeft())
				dqfk[1].moveLeft();
			this.repaint(); // ����ˢ��
			break;
		case KeyEvent.VK_RIGHT:
			if (dqfk[1].canMoveRight())
				dqfk[1].moveRight();
			this.repaint(); // ����ˢ��
			break;
		case KeyEvent.VK_W:
			if (dqfk[0].canTurn())
				dqfk[0].turn();
			this.repaint(); // ����ˢ��
			break;
		case KeyEvent.VK_S:
			interval = FastInterval;
			break;
		case KeyEvent.VK_A:
			if (dqfk[0].canMoveLeft())
				dqfk[0].moveLeft();
			this.repaint(); // ����ˢ��
			break;
		case KeyEvent.VK_D:
			if (dqfk[0].canMoveRight())
				dqfk[0].moveRight();
			this.repaint(); // ����ˢ��
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// ��ԭ�ٶ�
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_DOWN)
			interval = SlowInterval;
		if (key == KeyEvent.VK_S)
			interval = SlowInterval;
	}

	public int vanish(int playArea) { // a��ʾ��߻����ұ�
		int end = COLS; // ������ֹ��
		int start = 0; // ������ʼ��
		if (style == 0) // ����ģʽ,���޸ģ�styl��ӦΪdqfk
		{
			start = 0;
			end = COLS;
			playArea = 2;
		} else // (dqfk[1].style==1) //��սģʽ
		{
			if (playArea == 0) {
				start = 0;
				end = COLS / 2;
			} else if (playArea == 1) {
				start = 13;
				end = COLS;
			}
		}
		int lines = 0;
		for (int i = 0; i < ROWS; i++) {
			if (canvanish(i, playArea)) {// PlayArea����Ϊ0��ߣ�1�ұߣ�2��ʾ����ģʽ��ͬ�Ʒ�
				lines++;
				for (int j = i; j >= 1; j--) {
					for (int k = start; k < end; k++) {
						map[k][j] = map[k][j - 1];
					}
				}
			}
		}
		return lines * 10; // ���ط���������*10
	}

	// �ж��Ƿ�������
	public boolean canvanish(int row, int PlayArea) {
		int start = 0; // start��ʾ�ж�������ʼλ��
		int end = COLS; // isRight��ʾ����߻����ұ�
		if (PlayArea == 0) {// PlayArea����Ϊ0��ߣ�1�ұߣ�2��ʾ����ģʽ��ͬ�Ʒ�
			start = 0;
			end = 12;
		} else if (PlayArea == 1) {
			start = 12;
			end = COLS;
		}
		for (; start < end; start++) {
			if (map[start][row] == 0) {// ��һ���пո񣬲�������
				return false;
			}
		}
		return true;// ��һ���޿ո�������
	}

	public boolean gameover() throws InterruptedException // ��Ϸ����
	{
		for (int i = 0; i < COLS; i++)
			if (map[i][0] == 1) {
				_testframe.overDialog.setVisible(true);
				_testframe.t.destroy();
				return false;
			}
		return true;
	}

	public void run() {
		boolean isGameContinuing = true; // ��Ϸ�Ƿ����
		while (true) {
			if (isPause) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				for (int i = 0; i < 2; i++) {
					if (i == 1)
						isGameContinuing = true;
					if (dqfk[i].canMoveDown())
						dqfk[i].moveDown(); // �Զ�����
					else {
						// ���ص�ǰ������ĸ�С���������λ����Ϣ����ά������
						for (int j = 0; j < 4; j++) {
							int m = dqfk[i].smallblock[j].m;
							int n = dqfk[i].smallblock[j].n;
							map[m][n] = 1;
						}

						vanishLines = vanish(i);
						if (dqfk[0].style == 0) // ����ģʽ�Ļ���������һ���
						{
							score1 += vanishLines;
							score2 += vanishLines;
							this._testframe.control.score1.setText(score1 + "");
							this._testframe.control.score2.setText(score2 + "");
						} else // ��սģʽ�ֿ���
						{
							if (i == 0)
								score1 += vanishLines;
							else
								score2 += vanishLines;
							this._testframe.control.score1.setText(score1 + "");
							this._testframe.control.score2.setText(score2 + "");
						}

						try {
							isGameContinuing = gameover();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (isGameContinuing != false) // ��Ϸδ����,���¶�λһ������ķ���
							setRandomShape(i);
					}
				}
				this.repaint();
				try {
					Thread.sleep(interval);
				} catch (InterruptedException ex) {
				}
			}

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}