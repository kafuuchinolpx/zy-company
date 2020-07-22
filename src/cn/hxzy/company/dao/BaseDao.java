package cn.hxzy.company.dao;


import cn.hxzy.company.util.DBUtil;
import cn.hxzy.company.util.DataSource;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

public class BaseDao<T> {
    /**
     * 获取类泛型T的类型
     *
     * @return
     */
    public Class getTClass() {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    public List<T> findAll() throws Exception {
        Connection connection = DataSource.getConnection();
        List<T> select = DBUtil.select(connection, "", null, getTClass());
        DataSource.closeConnection(connection);
        return select;
    }
    public T findById(Integer id) throws Exception {
        Connection connection = DataSource.getConnection();
        Object obj = DBUtil.selectOne(connection, id, getTClass());
        DataSource.closeConnection(connection);
        return (T) obj;
    }


    public long countAll() throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "", null, getTClass());
        DataSource.closeConnection(connection);
        return count;
    }

    public void add(T t) throws Exception {
        Connection connection = DataSource.getConnection();
        DBUtil.insert(connection, t);
        DataSource.closeConnection(connection);
    }

    public void update(T t) throws Exception {
        Connection connection = DataSource.getConnection();
        DBUtil.update(connection, t);
        DataSource.closeConnection(connection);
    }

    public void delete(int id) throws Exception {
        Connection connection = DataSource.getConnection();
        DBUtil.delete(connection, id, getTClass());
        DataSource.closeConnection(connection);
    }
}
