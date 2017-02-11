package shape;

import view.mapPanel;

//С������
//���޸ģ�mappanel�����ù�������

public abstract class absShape{
	public SmallBlock [] smallblock=new SmallBlock[4];//С��������
	public int state;//״̬
	public int style;//��Ϸģʽ,0����ģʽ��1��սģʽ
	public int [][]map;
	int which;//������������Ǹ����������Ч
	absShape(mapPanel mappanel){
		for(int i=0;i<4;i++){
			smallblock[i]=new SmallBlock();
		}
		for(int i=0;i<4;i++){
        	smallblock[i].x=0;
        } 
		setStyle(mappanel);
	}
	public void setMap(int [][]map){
		this.map=map;
	}
	public void setStyle(mapPanel mappanel) {
		this.style=mappanel.style;
		
	}
	abstract public void reset(int k);//����,k=0Ϊ��k=1Ϊ��
	abstract public void turn();//��ת
	abstract public boolean canTurn();//�Ƿ�����ת
	//�Ƿ��������ƶ�
	public boolean canMoveLeft(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m-1;
			int n=smallblock[i].n;
			if(style==0)//����ģʽ
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//��սģʽ
			{
				if(m<11){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
						
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;			
				}
			
			}
		}
		if(i<4) return false;
		else return true;
	}
	//�Ƿ��������ƶ�
	public boolean canMoveRight(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m+1;
			int n=smallblock[i].n;
			if(style==0)//����ģʽ
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//��սģʽ
			{
				if(m<13){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;                               //���޸�
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;		
				}
				
			}
		}
		if(i<4) return false;          //���޸�
		else return true;
	}
	//�Ƿ�������
	public boolean canMoveDown(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m;
			int n=smallblock[i].n+1;
			if(style==0)//����ģʽ
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//��սģʽ
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					//m-=12;
					if(m<12||m>23||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//����
	public void moveLeft(){
		for(int i=0;i<4;i++){
			smallblock[i].m--;
		}
	}
	//����
	public void moveRight(){
		for(int i=0;i<4;i++){
			smallblock[i].m++;
		}
	}
	//����
	public void moveDown(){
		for(int i=0;i<4;i++){
			smallblock[i].n++;
		}
	}
}







/*public abstract class absShape{
	public SmallBlock [] smallblock=new SmallBlock[4];//С��������
	int state;//״̬
	int style=0;//��Ϸģʽ
	int [][]map;
	absShape(){
		for(int i=0;i<4;i++){
			smallblock[i]=new SmallBlock();
		}
	}
	public void setMap(int [][]map){
		this.map=map;
	}
	abstract public void reset(int k);//����,k=0Ϊ��k=1Ϊ��
	abstract public void turn();//��ת
	abstract public boolean canTurn();//�Ƿ�����ת
	
	//�Ƿ��������ƶ�
	public boolean canMoveLeft(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m-1;
			int n=smallblock[i].n;
			if(style==0)//����ģʽ
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//��սģʽ
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//�Ƿ��������ƶ�
	public boolean canMoveRight(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m+1;
			int n=smallblock[i].n;
			if(style==0)//����ģʽ
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//��սģʽ
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//�Ƿ�������
	public boolean canMoveDown(){
		int i;
		for(i=0;i<4;i++){
			int m=smallblock[i].m;
			int n=smallblock[i].n+1;
			if(style==0)//����ģʽ
			{
				if(m<0||m>23||n<0||n>17||map[m][n]==1)
					break;
			}
			else//��սģʽ
			{
				if(m<12){
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;
				}
				else{
					m-=12;
					if(m<0||m>11||n<0||n>17||map[m][n]==1)
						break;	
				}
				
			}
		}
		if(i<4) return false;
		else return true;
	}
	//����
	public void moveLeft(){
		for(int i=0;i<4;i++){
			smallblock[i].m--;
		}
	}
	//����
	public void moveRight(){
		for(int i=0;i<4;i++){
			smallblock[i].m++;
		}
	}
	//����
	public void moveDown(){
		for(int i=0;i<4;i++){
			smallblock[i].n++;
		}
	}
}
*/



