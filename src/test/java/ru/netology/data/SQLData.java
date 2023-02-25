package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLData {
    private static QueryRunner runner = new QueryRunner();

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection(
                System.getProperty("db.url"),
                System.getProperty("db.user"),
                System.getProperty("db.password"));
    }
    @SneakyThrows
    public static void cleanDataBase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM order_entity");
    }
    public static String getStatusDebitCard() {
        var dataSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        try (var conn = getConn()) {
            var status = runner.query(conn, dataSQL, new ScalarHandler<String>());
            return status;
            } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static String getStatusCreditCard() {
        var dataSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        try (var conn = getConn()) {
            var status = runner.query(conn, dataSQL, new ScalarHandler<String>());
            return status;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}