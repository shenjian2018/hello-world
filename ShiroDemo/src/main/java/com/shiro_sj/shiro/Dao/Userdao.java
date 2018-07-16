package com.shiro_sj.shiro.Dao;

import java.util.List;

import com.shiro_sj.shiro.pojo.User;

public interface Userdao {

	List<String> queryRolesByUserName(String Username);

	User getPasswordByUserName(String Username);

}
