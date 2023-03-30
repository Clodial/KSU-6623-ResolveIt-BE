package com.resolveit.dao;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.resolveit.resource.AccountType;
import com.resolveit.resource.Login;

public class ResolveItDAO {

	DataSource dataSource;
	
	public ResolveItDAO(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public Login createLoginAccount(Login loginInfo) throws SQLException {
		Connection conn = null;
		try {
			int isBiz = loginInfo.getAccountType().equals(AccountType.SERVICE) ? 1 : 0;
			String sql = "insert into UserInfo (name, password, business_acct) values (?, ?, ?)";
			String returnSql = "SELECT user_ID, name, business_acct from UserInfo WHERE name=?";
			conn = dataSource.getConnection();
				
			PreparedStatement loginStmt = conn.prepareStatement(sql);
			loginStmt.setString(1, loginInfo.getName());
			loginStmt.setString(2, loginInfo.getPassword());
			loginStmt.setInt(3, isBiz);
				
			loginStmt.execute();
			
			PreparedStatement newUserStmt = conn.prepareStatement(returnSql);
			newUserStmt.setString(1,  loginInfo.getName());
			ResultSet newUser = newUserStmt.executeQuery();
			newUser.next();
			AccountType rspType = newUser.getInt(3) == 1 ? AccountType.SERVICE : AccountType.CUSTOMER;
			String userId = newUser.getString(1);
			String userName = newUser.getString(2);
			
			return new Login(userId, userName, null, rspType);
		} catch (SQLException e) {
			throw e;
		} finally {
			conn.close();
		}
	}
	
	public Login retrieveLoginAccount(String name, String password) throws SQLException {
		Connection conn = null;
		try {
			String loginSql = "SELECT user_ID, name, business_acct from UserInfo WHERE name=? AND password=?";
			conn = dataSource.getConnection();
			
			PreparedStatement loginStmt = conn.prepareStatement(loginSql);
			loginStmt.setString(1,  name);
			loginStmt.setString(2, password);
			ResultSet user = loginStmt.executeQuery();
			user.next();
			AccountType rspType = user.getInt(3) == 1 ? AccountType.SERVICE : AccountType.CUSTOMER;
			String userId = user.getString(1);
			String userName = user.getString(2);
			
			return  new Login(userId, userName, null, rspType);
		} catch (SQLException e) {
			throw e;
		} finally {
			conn.close();
		}
	}
}
