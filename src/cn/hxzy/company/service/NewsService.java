package cn.hxzy.company.service;

import cn.hxzy.company.dao.NewsDao;
import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.vo.PageObj;

import java.util.List;

public class NewsService {
    private NewsDao newsDao = new NewsDao();

    public List<News> getAll() throws Exception {
        return newsDao.findAll();
    }

    public News getAllById(int id) throws Exception {
        return newsDao.newsId(id);
    }


    public PageObj<News> findAll(PageObj<News> page) throws Exception {
        List<News> all = newsDao.pageFindAll(page.getPage(),page.getSize());
        page.setList(all);
        long count = newsDao.countAll();
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;
    }


    public void newsAdd(News news) throws Exception {
        newsDao.add(news);
    }

    public void deleteById(int id) throws Exception {
        newsDao.delete(id);
    }

    public News getById(int id) throws Exception {
        return newsDao.newsById(id);
    }

    public PageObj<News> getByName(PageObj<News> page, String name) throws Exception{
        List<News> all = newsDao.nameFindAll(page.getPage(), page.getSize(), name);
        page.setList(all);
        long count = newsDao.countName(name);
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;
    }

    public PageObj<News> findByUsersId(PageObj<News> page,Integer id) throws Exception{
        List<News> all = newsDao.idFindAll(page.getPage(), page.getSize(), id);
        page.setList(all);
        long count = newsDao.countId(id);
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;
    }

    public PageObj<News> getByDate(PageObj<News> page,String date) throws Exception{
        List<News> all = newsDao.dateFindAll(page.getPage(), page.getSize(), date);
        page.setList(all);
        long count = newsDao.countDate(date);
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;
    }

    public void newsUpdate(News news) throws Exception{
        newsDao.update(news);
    }
}
