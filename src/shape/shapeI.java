package shape;

import view.mapPanel;

public class shapeI extends absShape{              //����
    public shapeI(mapPanel mappanel) {
		super(mappanel);
	}
	
	public void reset(int k){              //ʵ�ִӻ����м̳������ĳ��󷽷�
        //��state��һ�������
        state = (int)(Math.random()*2);

        //����state��С�������鸳ֵ
        if (state == 0){                //���Űڷ�
            for (int i = 0; i<4; i++){
                smallblock[i].m = 4+i+k*12;
                smallblock[i].n = 0;
            }
        }
        else {                          //���Űڷ�
            for (int i = 0; i<4; i++){
                smallblock[i].m = 5+k*12;
                smallblock[i].n = i;
            }
        }
    }
    public void turn(){               //ʵ�ִӻ���̳������ĳ��󷽷�
        if (state == 0)  {   //��->��
            int m = smallblock[0].m + 1;
            int n = smallblock[0].n - 1;
            for (int i = 0; i<4; i++){
                smallblock[i].m = m;
                smallblock[i].n = n+i;
            }
            state = 1;

        }else {              //��->��
            int m = smallblock[0].m - 1;
            int n = smallblock[0].n + 1;
            for (int i = 0; i<4; i++){
                smallblock[i].m = m + i;
                smallblock[i].n = n;
            }
            state = 0;
        }
    }

    public boolean canTurn() {
    	if(state==0){             //���Űڷ�
    		int m=smallblock[1].m;
    		int n=smallblock[1].n-1;
    		if(map[m][n]==0&&map[m][n+2]==0&&map[m][n+3]==0)
    			return true;
    		else 
    			return false;
    	}
    	else if(state==1){        //���Űڷ�
    		int m=smallblock[1].m-1;
    		int n=smallblock[1].n;
    		if(m>-1&&m+3<24&&map[m][n]==0&&map[m+2][n]==0&&map[m+3][n]==0)
    			return true;
    		else
    			return false;
    	}
    	return false;
    }
}

