package com.xp.dao.dbhelper;


import com.xp.bean.columns;


public class Test {
	
	public static void main(String[] args) {
		
		//DBHelper helper = new DBHelper();
		
		System.out.println(DBHelper.select("select * from columns"));

		System.out.println(DBHelper.select("select * from columns where aliasName=?","web"));

		columns col = DBHelper.unique("select * from columns where aliasName=?", columns.class,"web");
		System.out.println(col);
		
	}

}
