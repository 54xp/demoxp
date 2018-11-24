package com.xp.biz;

import java.util.List;

import com.xp.bean.User;
import com.xp.bean.columns;
import com.xp.dao.dbhelper.DBHelper;

public class categoryBiz {

	public List<columns> findAll() {
		return DBHelper.select("select * from columns", columns.class);
	}

	public void add(columns columns) {
		String sql = "insert into columns(columnName,aliasName,"
				+ "keyWords,description) values(?,?,?,?)";
		DBHelper.insert(sql, columns.getColumnName(),columns.getAliasName(),
				columns.getKeyWords(),columns.getDescription());
	}
}
