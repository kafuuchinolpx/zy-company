package cn.hxzy.company.service;

import cn.hxzy.company.dao.UsersDao;
import cn.hxzy.company.entity.Members;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.vo.PageObj;

import java.util.List;

public class UsersService {
    UsersDao usersDao = new UsersDao();

    public Users login(String loginName, String loginPassword) throws Exception {
        Users users = usersDao.findByLoginName(loginName);
        if (users != null && users.getLoginPassword().equals(loginPassword)) {
            return users;
        }
        return null;
    }

    public void userAdd(Users users) throws Exception {
        usersDao.add(users);
    }

    public List<Users> getAll() throws Exception {
        return usersDao.findAll();
    }

    public Users getById(Integer id) throws Exception {
        return usersDao.findById(id);
    }

    public PageObj<Users> getByName(PageObj<Users> page, String loginName) throws Exception {
        List<Users> all = usersDao.nameFindAll(page.getPage(), page.getSize(), loginName);
        page.setList(all);
        long count = usersDao.countName(loginName);
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;

    }


    public PageObj<Users> findAll(PageObj<Users> page) throws Exception {
        List<Users> all = usersDao.pageFindAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = usersDao.countAll();
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;
    }


    public void deleteById(int id) throws Exception {
        usersDao.delete(id);
    }

    public void userUpdate(Users users) throws Exception {
        usersDao.update(users);
    }
}
