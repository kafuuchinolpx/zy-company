package cn.hxzy.company.dao;

import cn.hxzy.company.entity.Members;
import cn.hxzy.company.entity.News;
import cn.hxzy.company.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembersDao extends BaseDao<Members> {

    public List<Members> memberByName(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `members` WHERE NAME LIKE ?");
        statement.setObject(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        List<Members> list = new ArrayList<>();
        while (resultSet.next()) {
            Members news = new Members(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("image"), resultSet.getString("work"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public List<Members> memberByWork(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `members` WHERE WORK LIKE ?");
        statement.setObject(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        List<Members> list = new ArrayList<>();
        while (resultSet.next()) {
            Members news = new Members(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("image"), resultSet.getString("work"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public List<Members> pageFindAll(int page, int size) throws Exception{
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * from `members` LIMIT ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<Members> list = new ArrayList<>();
        while (resultSet.next()) {
            Members news = new Members(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("image"), resultSet.getString("work"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }
}
