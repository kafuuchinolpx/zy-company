package cn.hxzy.company.dao;

import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorksDao extends BaseDao<Works> {


    public Works newsId(int id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `works`w LEFT JOIN `users`u ON w.`users_id`=u.id WHERE w.id = ?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        Works works = null;
        if (resultSet.next()) {
            works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return works;
    }

    public List<Works> worksGetAll() throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `works`w LEFT JOIN `users`u ON w.`users_id`=u.id ");
        ResultSet resultSet = statement.executeQuery();
        List<Works> list = new ArrayList<>();

        while (resultSet.next()) {
            Works works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(works);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public Works worksId(int id) throws Exception {//根据id查询
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `works`w LEFT JOIN `users`u ON w.`users_id`=u.id WHERE w.id = ?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        Works works = null;
        if (resultSet.next()) {
            works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return works;
    }


    public List<Works> worksByName(String name) throws Exception {//根据名字模糊查询
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `works`w LEFT JOIN `users`u ON w.`users_id`=u.id WHERE NAME LIKE ?");
        statement.setObject(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        List<Works> list = new ArrayList<>();
        while (resultSet.next()) {
            Works works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(works);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public List<Works> worksFindById(Integer id) throws Exception {//根据发布人id查询
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `works`w LEFT JOIN `users`u ON w.`users_id`=u.id WHERE u.id=?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        List<Works> list = new ArrayList<>();
        while (resultSet.next()) {
            Works works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(works);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public List<Works> worksFindByDate(String date) throws Exception {//根据发布时间查询
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `works`w LEFT JOIN `users`u ON w.`users_id`=u.id WHERE DATE=?");
        statement.setObject(1, date);
        ResultSet resultSet = statement.executeQuery();
        List<Works> list = new ArrayList<>();
        while (resultSet.next()) {
            Works works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(works);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public Works worksById(int id) throws Exception { //根据id查询返显

        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `works`w LEFT JOIN `users`u ON w.`users_id`=u.id WHERE w.id=?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        Works works = null;
        if (resultSet.next()) {
            works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return works;

    }





    public List<Works> pageFindAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `works` w LEFT JOIN `users` u ON w.`users_id`=u.id LIMIT ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<Works> list = new ArrayList<>();
        while (resultSet.next()) {
            Works works = new Works(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("image"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(works);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }
}
