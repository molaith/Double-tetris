package shape;

import view.mapPanel;

public class shapeRightL extends absShape{              //����
	 public shapeRightL(mapPanel mappanel) {
			super(mappanel);
		}
	public void reset(int k){              //ʵ�ִӻ����м̳������ĳ��󷽷�
        //��state��һ�������
        state = (int)(Math.random()*4);

        //����state��С�������鸳ֵ
        
        // *
        // *
        //** 
        if (state == 0){                
                smallblock[0].m = 6+k*12;
                smallblock[0].n = 0;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 1;
                smallblock[2].m = 6+k*12;
                smallblock[2].n = 2;
                smallblock[3].m = 5+k*12;
                smallblock[3].n = 2;
        }
        //*
        //* * *
        else if(state==1){                          
                smallblock[0].m = 7+k*12;
                smallblock[0].n = 2;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 2;
                smallblock[2].m = 5+k*12;
                smallblock[2].n = 2;
                smallblock[3].m = 5+k*12;
                smallblock[3].n = 1;
        }
        // * *
        // *
        // *
        else if(state==2){                          
                smallblock[0].m = 6+k*12;
                smallblock[0].n = 2;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 1;
                smallblock[2].m = 6+k*12;
                smallblock[2].n = 0;
                smallblock[3].m = 7+k*12;
                smallblock[3].n = 0;
        }
        //  *
        //***
        
        else if(state==3){                          
                smallblock[0].m = 5+k*12;
                smallblock[0].n = 1;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 1;
                smallblock[2].m = 7+k*12;
                smallblock[2].n = 1;
                smallblock[3].m = 7+k*12;
                smallblock[3].n = 2;
        }
    }
    public void turn(){               //ʵ�ִӻ���̳������ĳ��󷽷�
        if (state == 0)  {   //
            int m = smallblock[0].m + 1;
            int n = smallblock[0].n + 1;
                smallblock[0].m = m;
                smallblock[0].n = n;
                smallblock[1].m = m-1;
                smallblock[1].n = n;
                smallblock[2].m = m-2;
                smallblock[2].n = n;
                smallblock[3].m = m-2;
                smallblock[3].n = n-1;
            state = 1;
        }
        else if(state==1){              
            int m = smallblock[0].m - 1;
            int n = smallblock[0].n + 1;
                smallblock[0].m = m;
                smallblock[0].n = n;
                smallblock[1].m = m;
                smallblock[1].n = n-1;
                smallblock[2].m = m;
                smallblock[2].n = n-2;
                smallblock[3].m = m+1;
                smallblock[3].n = n-2;
            state = 2;
        }
        else if(state==2){              
            int m = smallblock[0].m - 1;
            int n = smallblock[0].n - 1;
                smallblock[0].m = m;
                smallblock[0].n = n;
                smallblock[1].m = m+1;
                smallblock[1].n = n;
                smallblock[2].m = m+2;
                smallblock[2].n = n;
                smallblock[3].m = m+2;
                smallblock[3].n = n+1;
            state = 3;
        }
        else if(state==3){              
            int m = smallblock[0].m + 1;
            int n = smallblock[0].n - 1;
                smallblock[0].m = m;
                smallblock[0].n = n;
                smallblock[1].m = m;
                smallblock[1].n = n+1;
                smallblock[2].m = m;
                smallblock[2].n = n+2;
                smallblock[3].m = m-1;
                smallblock[3].n = n+2;
            state = 0;
        }
    }

    public boolean canTurn() {
    	if(state==0){             
    		int m=smallblock[0].m+1;
    		int n=smallblock[0].n+1;
    		if(m<24&&map[m][n]==0&&map[m-2][n]==0&&map[m-2][n-1]==0)
    			return true;
    		else 
    			return false;
    	}
    	else if(state==1) {        
    		int m=smallblock[0].m-1;
    		int n=smallblock[0].n+1;
    		if(map[m][n]==0&&map[m][n-2]==0&&map[m+1][n-2]==0)
    			return true;
    		else
    			return false;
    	}
    	else if(state==2) {        
    		int m=smallblock[0].m-1;
    		int n=smallblock[0].n-1;
    		if(m>-1&&map[m][n]==0&&map[m+2][n]==0&&map[m+2][n+1]==0)
    			return true;
    		else
    			return false;
    	}
    	else if(state==3) {        
    		int m=smallblock[0].m+1;
    		int n=smallblock[0].n-1;
    		if(map[m][n]==0&&map[m][n+2]==0&&map[m-1][n+2]==0)
    			return true;
    		else
    			return false;
    	}
    	return false;
    }
}

