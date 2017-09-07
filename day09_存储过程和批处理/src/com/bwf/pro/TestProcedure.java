package com.bwf.pro;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.jdbc.StreamingNotifiable;

public class TestProcedure {

	public static void main(String[] args) {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into user values (?,?,?,?)";
		
	}
}
