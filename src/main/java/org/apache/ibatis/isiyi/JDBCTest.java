package org.apache.ibatis.isiyi;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * jdbc 测试
 * <p></p>
 *
 * @version 1.0.0
 * @description: JDBCTest
 * @author: 向鹏飞
 * @since: 2021/12/6
 */
public class JDBCTest {

    @Test
    public void testJdbc() throws Exception {
        //加载MySql驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=Asia/Shanghai&amp;nullCatalogMeansCurrent=true", "root", "root");
        // sql
        String sql = "SELECT * FROM actor WHERE actor_id = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, 1);
        // 返回结果集
        ResultSet  resultSet = prepareStatement.executeQuery();
        while(resultSet.next()){
            int actorId = resultSet.getInt("actor_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            Timestamp lastUpdate = resultSet.getTimestamp("last_update");
            System.out.println("actorId:"+actorId +", firstName:"+ firstName +", lastName:"+ lastName +", lastUpdate:"+ lastUpdate);
        }
    }

}
