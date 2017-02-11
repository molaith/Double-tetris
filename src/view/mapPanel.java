package view;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

import javax.swing.*;

import shape.absShape;
import shape.shapeI;
import shape.shapeT;
import shape.shapeLeftL;
import shape.shapeRightL;
import shape.shapeLeftZ;
import shape.shapeRightZ;
import shape.shapeSquare;
public class mapPanel extends JPanel implements KeyListener,Runnable{
	public static final int ROWS = 18;//���޸�
	public static final int COLS = 24;//���޸�
	int interval=500;              //�̵߳����ػ淽����ʱ����//���޸�
	int pstate=0;       //���޸�
	int s;	            //��������
	int fenshu1;		//����1,2
	int fenshu2;
	public int style;
	test _testframe=null;
	
	public absShape[] dqfk=new absShape[2] ;        //�������������������,��ǰ����
    Image[] pic=new Image[2];                       //��������䷽��ͼƬ
    Image background;
    int[] shapestyle=new int[2];                    //����������״
    
    
    public int [][] map = new int[COLS][ROWS]; //24��,18��
	public void setDqfk(absShape setdqfk1,absShape setdqfk2){
		dqfk[0]=setdqfk1;
		dqfk[1]=setdqfk2;
	}
    
    public mapPanel(int style,test testframe){
	 	pic[0]=Toolkit.getDefaultToolkit().getImage("һ��.png");
	 	pic[1]=Toolkit.getDefaultToolkit().getImage("��һ��.png");
	 	background=Toolkit.getDefaultToolkit().getImage("����ͼƬ��.jpg");
		this.style=style; //��սģʽ������ģʽ
		this._testframe=testframe;
	 	
	 	for(int i=0;i<2;i++){
     	shapestyle[i]=(int)(Math.random()*6);
        switch(shapestyle[i]){       //���޸ĺ�Ϊһ������
                     case(0):
                        dqfk[i]=new shapeI(this);
              	     break;	
              	     case(1):
              	         dqfk[i]=new shapeLeftZ(this);
              	     break;
              	     case(2):
              	         dqfk[i]=new shapeRightZ(this);
              	     break;
              	     case(3):
              	         dqfk[i]=new shapeLeftL(this);;
              	     break;
              	     case(4):
              	         dqfk[i]=new shapeRightL(this);
              	     break;
              	     case(5):
              	         dqfk[i]=new shapeT(this);
              	     break;
              	     case(6):
              	         dqfk[i]=new shapeSquare(this);
              	     break;
              	} 
              	dqfk[i].setMap(map);
                dqfk[i].reset(i);
		}
	}        
			
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(background,0,0,630,500,this);
		//���������24*18�ĸ���
		g.setColor(Color.black);
		for(int i=0;i<25;i++){
	        g.drawLine(i*25,0,i*25,18*25);	
	    }
	    for(int j=0;j<19;j++){
	    	g.drawLine(0,j*25,24*25,j*25);
	    }
	    g.setColor(Color.red);
	    g.drawLine(12*25,0,12*25,18*25);
	    //���Ƶ�ǰ����
        g.setColor(Color.orange);
        for(int i=0;i<2;i++){
        	for (int j = 0; j<4; j++){  //���Ƶ�ǰ�����е�С���������е�ÿһ��С����
            int m = dqfk[i].smallblock[j].m;
            int n = dqfk[i].smallblock[j].n;
            //g.fill3DRect(m*25,n*25,25,25,true);
            g.drawImage(pic[i],m*25,n*25,25,25,this);
        }
        }
        
        //����map��Ϊ1��λ��,�ϰ���
        g.setColor(Color.cyan);
        for (int i = 0; i<24 ; i++){
            for (int j = 0; j < 18; j++) {
                if (map[i][j] == 1) {
                    g.fill3DRect(i * 25, j * 25, 25, 25, true);
                    g.drawImage(pic[0],i * 25, j * 25, 25, 25,this);
                }
            }
        }
	}
	
	public void keyPressed(KeyEvent e) {
		//1���ұߣ�0�����
        int key = e.getKeyCode();
          switch(key){
             case KeyEvent.VK_UP:
                 //��ת
                 if(dqfk[1].canTurn())
                     dqfk[1].turn();
                 this.repaint();         //����ˢ��
                 break;
             case KeyEvent.VK_DOWN:
                 //����
                 interval=100;
                 break;
             case KeyEvent.VK_LEFT:
                 if (dqfk[1].canMoveLeft())
                     dqfk[1].moveLeft();
                 this.repaint();        //����ˢ��
                 break;
             case KeyEvent.VK_RIGHT:
                 if (dqfk[1].canMoveRight())
                     dqfk[1].moveRight();
                 this.repaint();        //����ˢ��
                 break;
             case KeyEvent.VK_W:
                 	if(dqfk[0].canTurn())
                     dqfk[0].turn();
                 this.repaint();         //����ˢ��
                 break;
             case KeyEvent.VK_S:
                 	interval=100;
                 break;
             case KeyEvent.VK_A:
                 	 if (dqfk[0].canMoveLeft())
                     dqfk[0].moveLeft();
                 this.repaint();        //����ˢ��
                 break;
             case KeyEvent.VK_D:
                 	if (dqfk[0].canMoveRight())
                     dqfk[0].moveRight();
                 this.repaint();        //����ˢ��
                 break;
             default:
                 break;
           }
    }
    public void keyReleased(KeyEvent e) {
        //��ԭ�ٶ�
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_DOWN)
            interval= 500;
        if (key == KeyEvent.VK_S)
            interval = 500;
    }

    public int vanish(int a){		 //a��ʾ��߻����ұ�
    		int k=0;                 
    		int cols=COLS;           //����
    		int b=0;				 //������ʼ��
    		if(dqfk[0].style==0)     //����ģʽ,���޸ģ�styl��ӦΪdqfk
    		{
    			 b=0;
    			 cols=COLS;
    			 a=2;
    		}
    		else //(dqfk[1].style==1)   //��սģʽ
    		{
    			if(a==0)
    			{
    				b=0;
    				 cols=COLS/2;
    			}
    			else if(a==1)
    			{
    				 b=13;
    				 cols=COLS;
    			}
    		}
    				int lines = 0;
			for(int i = 0; i <ROWS ; i++){
				if(canvanish(i,a)){
					lines++;
					for(int j = i; j >=1; j--){
					for( k=b;k<cols;k++)
					{
						
						map[k][j]=map[k][j-1];
					}
					}
//					if(pstate==1)//�ǵ��ߵĻ���ִ�����к󣬽��е���Ч��
//					{
//					}
					for(int j =k; j < COLS;j++){
						map[j][0] = 0;//���wall[0]��ÿ��Ԫ��Ϊ��
					}
				}
			}
			return lines*10;
		}
		
			public boolean canvanish(int row,int a){
				int col=0;
				int k=COLS;				//a��ʾ����߻����ұ�
				if(a==0)
				{
					col=0;
					k=12;
				}
				else if(a==1)
				{
					col=12;
					k=COLS;
				}
			for( ; col < k; col++){
				//System.out.println(map[col][row]);
				if(map[col][row]==2)							//�ж�С�����Ƿ��ǵ���
				pstate=1;
				if(map[col][row] == 0){
						pstate=0;
					return false;
				}
			
			}
			
			return true;//����
		}
//   public void speffects(int k)						//����Ч������
//		{
//			switch(k){
//			case 1: 
//				speffect1();			//����
//				break;
//				case 2:
//					speffect2();    		//����
//					break;
//					case 3:
//						speffect3();
//						break;
//						case 4:
//							speffect4();
//							break;
//							default:
//								break;
//			}}
//   public void speffect1()			//����һ��				
//					{	
//			for(int i=0;i<ROWS-1;i++)
//				for(int j=0;j<COLS;j++)
//				{
//					map[j][i]=map[j][i+1];
//				}
//			for(int i=0;i<COLS;i++)
//			{
//				int a=(int)(Math.random()*10);
//				if(a>5)
//				{
//					map[i][ROWS-1]=0;
//				}
//				else
//				{map[i][ROWS-1]=1;
//				}
//					
//			}}	
//		
//   public void speffect2()									//ը�����������������������
//			{
//				for(int i=ROWS-4;i>=0;i--)
//				for(int j=0;j<COLS;j++)
//				{
//					map[j][i+3]=map[j][i];
//				}
//				
//			}
//   public void speffect3()        							//���ģʽ
//				{
//				}
//   public void speffect4()  								//��Чĳĳ
//				{
//				}
   public int gameover() throws InterruptedException                                //��Ϸ����
				{
					int count1=0;
					int count2=0;
					for(int i=5;i<8;i++)					//���޸�
						for(int j=0;j<3;j++)
						{
							if(map[i][j]==1)
							count1++;	
						}
			       for(int i=17;i<20;i++)
						for(int j=0;j<3;j++)
						{
							if(map[i][j]==1)
							count2++;	
						}
					if(count1>4||count2>4){
						_testframe.overDialog.setVisible(true);
						_testframe.t.destroy();
						}
						return 1;
				}                              
   public void run() {
    	int x=0;                                      //���޸���Ϸ�Ƿ����
        while (true){
        	for(int i=0;i<2;i++){ 
        		if(i==1) x=1;
        		if (dqfk[i].canMoveDown())
                    dqfk[i].moveDown();              //�Զ�����
                else {
                //���ص�ǰ������ĸ�С���������λ����Ϣ����ά������
                   for (int j = 0; j<4; j++){
                      int m = dqfk[i].smallblock[j].m;
                      int n = dqfk[i].smallblock[j].n;
                      map[m][n] = 1;
                   }   
                   
                  s=vanish(i);
                  if(dqfk[0].style==0)			//����ģʽ�Ļ���������һ���
                  {
                	  fenshu1+=s;
                	  fenshu2+=s;
                	  this._testframe.control.score1.setText(fenshu1+"");
                	  this._testframe.control.score2.setText(fenshu2+"");
                  }
                  else						//��սģʽ�ֿ���
                  {
                  if(i==0)
                	  fenshu1+=s;
                  else
                	  fenshu2+=s;
                  this._testframe.control.score1.setText(fenshu1+"");
            	  this._testframe.control.score2.setText(fenshu2+"");
                  }
                	  
                  try {
					x=gameover();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  if(x!=0)   //��Ϸδ����
               //���¶�λһ������ķ���
		          shapestyle[i]=(int)(Math.random()*6);
		          switch(shapestyle[i]){   //���޸ĺ�Ϊһ������
                     case(0):
                        dqfk[i]=new shapeI(this);
              	     break;	
              	     case(1):
              	         dqfk[i]=new shapeLeftZ(this);
              	     break;
              	     case(2):
              	         dqfk[i]=new shapeRightZ(this);
              	     break;
              	     case(3):
              	         dqfk[i]=new shapeLeftL(this);
              	     break;
              	     case(4):
              	         dqfk[i]=new shapeRightL(this);
              	     break;
              	     case(5):
              	         dqfk[i]=new shapeT(this);
              	     break;
              	     case(6):
              	         dqfk[i]=new shapeSquare(this);
              	     break;
              	}
                //dqfk[i]=new shapeI(this);
              	dqfk[i].setMap(map);
                dqfk[i].reset(i); 
              }
            }
            this.repaint();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException ex) {
            }
    }
  }

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
//public int keyPressedTest(KeyEvent e) {
//	//1���ұߣ�0�����
//	int returnValue;
//    int key = e.getKeyCode();
//      switch(key){
//         case KeyEvent.VK_UP:
//             //��ת
//             if(dqfk[1].canTurn()){
//            	 dqfk[1].turn();
//            	 
//             }
//                 
//             this.repaint();         //����ˢ��
//             
//             break;
//         case KeyEvent.VK_DOWN:
//             //����
//             interval=100;
//             returnValue=0;
//             break;
//         case KeyEvent.VK_LEFT:
//             if (dqfk[1].canMoveLeft()){
//            	 dqfk[1].moveLeft();
//            	 return 1;
//             }
//             this.repaint();        //����ˢ��
//             returnValue=2;
//             break;
//         case KeyEvent.VK_RIGHT:
//             if (dqfk[1].canMoveRight())
//                 dqfk[1].moveRight();
//             this.repaint();        //����ˢ��
//             break;
//         case KeyEvent.VK_W:
//             	if(dqfk[0].canTurn())
//                 dqfk[0].turn();
//             this.repaint();         //����ˢ��
//             break;
//         case KeyEvent.VK_S:
//             	interval=100;
//             	returnValue=0;
//             break;
//         case KeyEvent.VK_A:
//             	 if (dqfk[0].canMoveLeft())
//                 dqfk[0].moveLeft();
//             this.repaint();        //����ˢ��
//             break;
//         case KeyEvent.VK_D:
//             	if (dqfk[0].canMoveRight())
//                 dqfk[0].moveRight();
//             this.repaint();        //����ˢ��
//             break;
//         default:
//             break;
//       }
//}
} 