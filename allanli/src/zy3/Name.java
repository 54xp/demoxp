package zy3;

import java.util.Random;

public class Name {
	private static String xings = 
			"�� Ǯ �� �� �� �� ֣ �� �� �� �� �� " + 
			"�� �� �� �� �� �� �� �� �� �� ʩ �� " + 
			"�� �� �� �� �� κ �� �� �� л �� �� " + 
			"�� ˮ � �� �� �� �� �� �� �� �� �� " +
			"��ٹ ˾�� �Ϲ� ŷ�� �ĺ� ��� ���� " +
			"���� ���� �ʸ� ξ�� ����";
			
    private static String mings = 
		    "�̷������ա����㡢���̡����Ρ����̡��������黱��ƽ������䡢��硢���ɡ����ơ�"
		    + "���ɡ��������ΰء����ס��������������桢�ûܡ����ࡢЦ�������䡢���ء���ѩ��"
			+ "�ַ㡢��ޱ�����㡢Ѱ������ɽ���Ӻ������㡢�ٲ����������������²������桢���١�"
			+ "������ܡ���ɽ��ǧ�١����졢��ܽ����ɽ�����������������������ϡ����ס����ޡ�"			
			+ "��˪�����ۡ����㡢���ơ�Ѱ�ġ���ѩ�����桢���ա����������١��໱�����������Ρ�"
			+ "ϧѩ���𺣡�֮�ᡢ����";

    public static String build(String xing, int length){
		Random r=new Random();
		String xingming=xing;
		while(xingming.length()<length){
			int index=r.nextInt(mings.length());
			String s=mings.substring(index, index+1);
			if("��".equals(s)){
				continue;
			}else{
				xingming+=s;
			}
		}
    	return xingming;
    	
    }
}

