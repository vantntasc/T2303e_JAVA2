package org.aptech.t2303e.connectionpool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDataSource {
    private static HikariConfig config = new HikariConfig();

    private static HikariDataSource ds;

    static {
        config.setDriverClassName(DbConfiguration.DB_DRIVER);
        config.setJdbcUrl(DbConfiguration.CONNECTION_URL);
        config.setUsername(DbConfiguration.USER_NAME);
        config.setPassword(DbConfiguration.PASSWORD);
        config.setMinimumIdle(DbConfiguration.DB_MIN_CONNECTIONS);
        config.setMaximumPoolSize(DbConfiguration.DB_MAX_CONNECTIONS);
        // Some additional properties
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    private HikariCPDataSource() {
        super();
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.err.println(conn);
            if(conn != null){
                System.err.println("connection ok");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
