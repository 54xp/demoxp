package com.xp.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xp.bean.User;
import com.xp.dao.dbhelper.DBHelper;



public class UserBiz {
	/**
	 * 	登陆方法
	 * @param username
	 * @param userpwd
	 * @return 返回登陆成功的用户对象
	 * @throws BizException 
 	 */
	public User login(String username,String userpwd) throws BizException {
		if(username == null || username.trim().isEmpty()){
			throw new BizException("请填写用户名!");
		}
		if(userpwd == null || userpwd.trim().isEmpty()) {
			throw new BizException("请填写密码!");
		}
		// 查询数据库判断用户是否存在
		String sql = "select * from user where account=? and pwd=?";
		return DBHelper.unique(sql, User.class, username,userpwd);
	}

	public List<User> findAll() {
		return DBHelper.select("select * from user", User.class);	
	}

	public void add(User user,String repwd) throws BizException{
		if(user.getName() == null || user.getName().trim().isEmpty()) {
			throw new BizException("请填写用户名");
		}
		if(user.getTel() == null || user.getTel().trim().isEmpty()){
			throw new BizException("请填写电话号码");
		}	
	
	String sql = "insert into user (name,account,tel,pwd) values(?,?,?,?)";
	DBHelper.insert(sql,user.getName(),user.getAccount(),
			user.getTel(),user.getPwd());
	}
	/**
	 * 根据用户对象的属性值，查询用户
	 * @param user
	 * @return
	 */
	public Object find(User user) {
		String sql = "select * from user where 1=1 ";
		ArrayList<Object>params = new ArrayList<Object>();
		if(user.getAccount()!=null && user.getAccount().trim().isEmpty() == false) {
			sql+= "and account like concat('%',?,'%')";  //concat只用于mysql数据库
			params.add(user.getAccount());
		}
		if(user.getName()!=null && user.getName().trim().isEmpty() == false) {
			sql+= "and name like ?";
			params.add("%"+user.getName()+"%");	//适用oracle与mysql
		}
		if(user.getTel()!=null && user.getTel().trim().isEmpty() == false) {
			sql+= "and tel like ?";
			params.add("%"+user.getTel()+"%");
		}
		return DBHelper.select(sql, params);
	}

	public User findById(String id) {		
		return DBHelper.unique("select * from user where id=?",User.class,id);
	}

	public void save(User user) throws BizException{
		if(user.getName() == null || user.getName().isEmpty()) {
			throw new BizException("请填写用户名");
		}
		if(user.getAccount()== null || user.getAccount().isEmpty()) {
			throw new BizException("请填写账号");
		}
		if(user.getTel()== null || user.getTel().isEmpty()) {
			throw new BizException("请填写电话");
		}
		String sql = "update user set name=?,account=?,tel=? where id=?";
		DBHelper.update(sql, user.getName(),user.getAccount(),user.getTel(),user.getId());
	}

	public void delete(String id) throws BizException{
		if("".equals(id) || id== null) {
			throw new BizException("删除失败");
		}
		String sql = "delete from user where id =?";
		DBHelper.update(sql, id);
	}	
}
