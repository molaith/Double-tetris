package shape;

import view.mapPanel;

public class shapeSquare extends absShape{              //����
	 public shapeSquare(mapPanel mappanel) {
			super(mappanel);
		}
	public void reset(int k){              //ʵ�ִӻ����м̳������ĳ��󷽷�
        //��state��һ�������
                smallblock[0].m = 5+k*12;
                smallblock[0].n = 0;
                smallblock[1].m = 6+k*12;
                smallblock[1].n = 0;
                smallblock[2].m = 5+k*12;
                smallblock[2].n = 1;
                smallblock[3].m = 6+k*12;
                smallblock[3].n = 1;
    }
    public void turn(){               //ʵ�ִӻ���̳������ĳ��󷽷�
        
    }

    public boolean canTurn() {
    return true;
}
}
