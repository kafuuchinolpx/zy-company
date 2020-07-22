package cn.hxzy.company.dao;

import cn.hxzy.company.entity.Users;
import cn.hxzy.company.util.DBUtil;
import cn.hxzy.company.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDao extends BaseDao<Users> {
    public Users findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from users where login_name = ?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        Users users = null;
        if (resultSet.next()) {
            users = new Users(resultSet.getInt("id"), resultSet.getString("login_name"), resultSet.getString("login_password"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return users;
    }


    public List<Users> pageFindAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * from `users` LIMIT ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<Users> list = new ArrayList<>();
        while (resultSet.next()) {
            Users users = new Users(resultSet.getInt("id"), resultSet.getString("login_name"), resultSet.getString("login_password"));
            list.add(users);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public List<Users> nameFindAll(int page, int size, String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `users` WHERE login_name LIKE ? LIMIT ?,?");
        statement.setObject(1, "%" + loginName + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<Users> list = new ArrayList<>();
        while (resultSet.next()) {
            Users users = new Users(resultSet.getInt("id"), resultSet.getString("login_name"), resultSet.getString("login_password"));
            list.add(users);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public long countName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM `users` WHERE login_name LIKE ?");
        statement.setObject(1, "%" + loginName + "%");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            long aLong = resultSet.getLong(1);
            resultSet.close();
            statement.close();
            DataSource.closeConnection(connection);
            return aLong;
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return 0;
    }
}
