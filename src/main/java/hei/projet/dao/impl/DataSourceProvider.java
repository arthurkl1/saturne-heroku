package hei.projet.dao.impl;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {
	
	private static MysqlDataSource dataSource;

	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("saturne"); //A changer nom schema
			dataSource.setUser("root");//A changer
			dataSource.setPassword("hei2016-2017");//A changer
		}
		return dataSource;
	}

}
