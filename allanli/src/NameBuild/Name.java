package NameBuild;

import java.util.Random;

public class Name {
	private static String xings = 
			"赵 钱 孙 李 周 吴 郑 王 冯 陈 褚 卫 " + 
			"蒋 沈 韩 杨 朱 秦 尤 许 何 吕 施 张 " + 
			"孔 曹 严 华 金 魏 陶 姜 戚 谢 邹 喻 " + 
			"柏 水 窦 章 云 苏 潘 葛 奚 范 彭 郎 " +
			"万俟 司马 上官 欧阳 夏侯 诸葛 闻人 " +
			"东方 赫连 皇甫 尉迟 公羊";
			
    private static String mings = 
		    "碧凡、夏菡、曼香、若烟、半梦、雅绿、冰蓝、灵槐、平安、书翠、翠风、香巧、代云、"
		    + "友巧、听寒、梦柏、醉易、访旋、亦玉、凌萱、访卉、怀亦、笑蓝、春翠、靖柏、书雪、"
			+ "乐枫、念薇、靖雁、寻春、恨山、从寒、忆香、觅波、静曼、凡旋、新波、代真、新蕾、"
			+ "雁玉、冷卉、紫山、千琴、恨天、傲芙、盼山、怀蝶、冰兰、问旋、从南、白易、问筠、"				+ "如霜、半芹、寒雁、怜云、寻文、谷雪、乐萱、涵菡、海莲、傲蕾、青槐、冬儿、易梦、"
			+ "惜雪、宛海、之柔、夏青";
    /**
	 * 给定一个姓氏，随机生成一个总长度为length的名字，名字从mings里面挑字
	 * @param xing
	 * @param length
	 * @return
	 */			
    public static String build(String xing, int length){
    	String xingming=xing;
    	Random r=new Random();
    	while(xingming.length()<length){
    		int index=r.nextInt(mings.length());
        	String s=mings.substring(index, index+1);
        	if("、".equals(s)){
        		continue;
        	}else{
        		xingming+=s;
        	}
    	}
		return xingming;
    }
    public static String build(int length){
    	if(length<2){
    		System.out.println("名字长度不能小于2");
    		return null;
    	}
    	String []xingArr=xings.split(" ");
    	Random r=new Random();
    	int index=r.nextInt(xingArr.length);
    	String xing=xingArr[index];
    	return build(xing,length);
    }
    public static void main(String[] args) {
		System.out.println(build("张",3));
		System.out.println(build(3));
	}
}
