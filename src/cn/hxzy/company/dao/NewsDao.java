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

public class NewsDao extends BaseDao<News> {

    public News newsId(int id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `news`n LEFT JOIN `users`u ON n.`users_id`=u.id WHERE n.id = ?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        News news = null;
        if (resultSet.next()) {
            news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return news;
    }

    public List<News> newsGetAll() throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `news`n LEFT JOIN `users`u ON n.`users_id`=u.id ");
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public News newsById(Integer id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `news`n LEFT JOIN `users`u ON n.`users_id`=u.id WHERE n.id=?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        News news = null;
        if (resultSet.next()) {
            news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return news;
    }


    public List<News> newsByName(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `news`n LEFT JOIN `users`u ON n.`users_id`=u.id WHERE NAME LIKE ?");
        statement.setObject(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public List<News> newsFindById(Integer id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `news`n LEFT JOIN `users`u ON n.`users_id`=u.id WHERE u.id=?");
        statement.setObject(1, id);
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;

    }

    public List<News> newsFindByDate(String date) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT *  FROM `news`n LEFT JOIN `users`u ON n.`users_id`=u.id WHERE DATE=?");
        statement.setObject(1, date);
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public List<News> pageFindAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `news` n LEFT JOIN `users` u ON n.`users_id`=u.id LIMIT ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public List<News> nameFindAll(int page, int size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `news` n LEFT JOIN `users` u ON n.`users_id`=u.id WHERE  n.name LIKE ? LIMIT ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public long countName(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM `news` n LEFT JOIN `users` u ON n.`users_id`=u.id WHERE n.name LIKE ?");
        statement.setObject(1, "%" + name + "%");
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

    public List<News> idFindAll(int page, int size, int id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `news` n LEFT JOIN `users` u ON n.`users_id`=u.id WHERE u.id=? LIMIT ?,?");
        statement.setObject(1, id);
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public long countId(int id) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM `news` n LEFT JOIN `users` u ON n.`users_id`=u.id WHERE u.id=? ");
        statement.setObject(1, id);
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

    public List<News> dateFindAll(int page, int size, String date) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `news` n LEFT JOIN `users` u ON n.`users_id`=u.id WHERE  date LIKE ? LIMIT ?,?");
        statement.setObject(1, "%" + date + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<News> list = new ArrayList<>();
        while (resultSet.next()) {
            News news = new News(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("value"), resultSet.getDate("date"), resultSet.getInt("users_id"), resultSet.getString("login_name"));
            list.add(news);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public long countDate(String date) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM `news` n LEFT JOIN `users` u ON n.`users_id`=u.id WHERE date LIKE ?");
        statement.setObject(1, "%" + date + "%");
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

