package com.resolveit.dao;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.resolveit.resource.AccountType;
import com.resolveit.resource.Login;

public class ResolveItDAO {

	DataSource dataSource;
	
	public ResolveItDAO(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void createLoginAccount(Login loginInfo) throws SQLException {
		int isBiz = loginInfo.getAccountType().equals(AccountType.SERVICE) ? 1 : 0;
		String sql = "insert into UserInfo (name, password, business_acct) values (?, ?, ?)";
		Connection conn = dataSource.getConnection();
			
		PreparedStatement loginStmt = conn.prepareStatement(sql);
		loginStmt.setString(1, loginInfo.getName());
		loginStmt.setString(2, loginInfo.getPassword().getBytes(StandardCharsets.UTF_8).toString());
		loginStmt.setInt(3, isBiz);
			
		loginStmt.execute();
		conn.close();
	}
}
