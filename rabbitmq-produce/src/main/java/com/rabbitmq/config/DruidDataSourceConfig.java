package com.rabbitmq.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <br>
 * 标题: Druid数据源配置<br>
 * 描述: Druid数据源配置<br>
 * 时间: 2018/10/06<br>
 *
 * @author shenjian
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig {

	@Bean
	public DataSource dataSource(DruidDataSourceSettings druidSettings) throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(druidSettings.getDriverClassName());
		dataSource.setUrl(druidSettings.getUrl());
		dataSource.setUsername(druidSettings.getUsername());
		dataSource.setPassword(druidSettings.getPassword());

		dataSource.setInitialSize(druidSettings.getInitialSize());
		dataSource.setMinIdle(druidSettings.getMinIdle());
		dataSource.setMaxActive(druidSettings.getMaxActive());
		dataSource.setTimeBetweenEvictionRunsMillis(druidSettings.getTimeBetweenEvictionRunsMillis());
		dataSource.setMinEvictableIdleTimeMillis(druidSettings.getMinEvictableIdleTimeMillis());
		dataSource.setValidationQuery(druidSettings.getValidationQuery());

		dataSource.setTestWhileIdle(druidSettings.getTestWhileIdle());
		dataSource.setTestOnBorrow(druidSettings.getTestOnBorrow());
		dataSource.setTestOnReturn(druidSettings.getTestOnReturn());
		dataSource.setPoolPreparedStatements(druidSettings.getPoolPreparedStatements());
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidSettings.getMaxOpenPreparedStatements());

		dataSource.setFilters(druidSettings.getFilters());
		dataSource.setConnectProperties(druidSettings.getConnectionProperties());
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DruidDataSourceSettings druidSettings) throws Exception {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(this.dataSource(druidSettings));
		return manager;
	}
}