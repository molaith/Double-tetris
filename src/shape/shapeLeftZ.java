package shape;

import view.mapPanel;

public class shapeLeftZ extends absShape{              //����
	 public shapeLeftZ(mapPanel mappanel) {
			super(mappanel);
		}
	public void reset(int k){              //ʵ�ִӻ����м̳������ĳ��󷽷�
        //��state��һ�������
        state = (int)(Math.random()*2);

        //����state��С�������鸳ֵ
        if (state == 0){                //����
                smallblock[0].m = 5+k*12;
                smallblock[0].n = 0;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 0;
                smallblock[2].m = 6+k*12;
                smallblock[2].n = 1;
                smallblock[3].m = 7+k*12;
                smallblock[3].n = 1;
        }
        else {                          //����
                smallblock[0].m = 6+k*12;
                smallblock[0].n = 0;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 1;
                smallblock[2].m = 5+k*12;
                smallblock[2].n = 1;
                smallblock[3].m = 5+k*12;
                smallblock[3].n = 2;
        }
    }
    public void turn(){               //ʵ�ִӻ���̳������ĳ��󷽷�
        if (state == 0)  {   //��->��
            int m = smallblock[0].m + 1;
            int n = smallblock[0].n;
                smallblock[0].m = m;
                smallblock[0].n = n;
                smallblock[1].m = m;
                smallblock[1].n = n+1;
                smallblock[2].m = m-1;
                smallblock[2].n = n+1;
                smallblock[3].m = m-1;
                smallblock[3].n = n+2;
            state = 1;

        }else {              //��->��
            int m = smallblock[0].m - 1;
            int n = smallblock[0].n;
                smallblock[0].m = m;
                smallblock[0].n = n;
                smallblock[1].m = m+1;
                smallblock[1].n = n;
                smallblock[2].m = m+1;
                smallblock[2].n = n+1;
                smallblock[3].m = m+2;
                smallblock[3].n = n+1;
            state = 0;
        }
    }

    public boolean canTurn() {
    	if(state==0){             //����
    		int m=smallblock[0].m;
    		int n=smallblock[0].n+1;
    		if(map[m][n]==0&&map[m][n+1]==0)
    			return true;
    		else 
    			return false;
    	}
    	else {        //����
    		int m=smallblock[0].m-1;
    		int n=smallblock[1].n;
    		if(m+2<24&&map[m][n]==0&&map[m+2][n+1]==0)
    			return true;
    		else
    			return false;
    	}
    	
    }
}

