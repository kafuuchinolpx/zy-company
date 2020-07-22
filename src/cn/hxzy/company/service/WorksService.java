package cn.hxzy.company.service;

import cn.hxzy.company.dao.WorksDao;
import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.entity.vo.PageObj;

import java.io.File;
import java.util.List;

public class WorksService {
    private WorksDao worksDao = new WorksDao();

    public List<Works> getAll() throws Exception {
        return worksDao.findAll();
    }

    public PageObj<Works> findAll(PageObj<Works> page) throws Exception {
        List<Works> all = worksDao.pageFindAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = worksDao.countAll();
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;
    }

    public Works getId(int id) throws Exception {
        return worksDao.newsId(id);
    }

    public void workAdd(Works works) throws Exception {
        worksDao.add(works);
    }

    public List<Works> worksGetAll() throws Exception {
        return worksDao.worksGetAll();
    }


    public List<Works> getByName(String name) throws Exception {
        return worksDao.worksByName(name);
    }

    public List<Works> findById(Integer id) throws Exception {
        return worksDao.worksFindById(id);
    }

    public List<Works> getByDate(String date) throws Exception {
        return worksDao.worksFindByDate(date);
    }

    public void newsUpdate(Works works) throws Exception {

        Works id = worksDao.findById(works.getId());
        System.out.println(id.getImage());
            String image = "C:/Users/Administrator/IdeaProjects/zy-company/out/artifacts/zy_company_war_exploded" + (id.getImage());
            File file = new File(image);
            if (file.exists()) {
                file.delete();
                System.out.println("文件已经被成功删除");
        }


        worksDao.update(works);
    }

    public Works getById(int id) throws Exception {
        return worksDao.worksById(id);
    }

    public void deleteById(int id) throws Exception {
        Works works = worksDao.findById(id);
        String image = "C:/Users/Administrator/IdeaProjects/zy-company/out/artifacts/zy_company_war_exploded" + (works.getImage());
        File file = new File(image);
        if (file.exists()) {
            file.delete();
            System.out.println("文件已经被成功删除");
        }
        worksDao.delete(id);
    }
}
