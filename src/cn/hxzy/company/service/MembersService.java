package cn.hxzy.company.service;

import cn.hxzy.company.dao.MembersDao;
import cn.hxzy.company.entity.Members;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.entity.vo.PageObj;

import java.io.File;
import java.util.List;

public class MembersService {
    private MembersDao membersDao = new MembersDao();

    public List<Members> getAll() throws Exception {
        return membersDao.findAll();
    }

    public PageObj<Members> findAll(PageObj<Members> page) throws Exception {
        List<Members> all = membersDao.pageFindAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = membersDao.countAll();
        page.setCount(count);
        System.out.println("一共有" + count + "条数据");
        Integer size = page.getSize();
        System.out.println("目前分页有" + size / 10 + "页");
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        System.out.println("当前已生成" + pageCount + "页");
        page.setPageCount((int) pageCount);
        return page;
    }

    public Members getById(int id) throws Exception {
        return membersDao.findById(id);
    }

    public List<Members> memberByName(String name) throws Exception {
        return membersDao.memberByName(name);
    }


    public List<Members> memberByWork(String work) throws Exception {
        return membersDao.memberByWork(work);
    }

    public void memberAdd(Members members) throws Exception {
        membersDao.add(members);
    }

    public void newsUpdate(Members members) throws Exception {

        Members id = membersDao.findById(members.getId());
            String image = "C:/Users/Administrator/IdeaProjects/zy-company/out/artifacts/zy_company_war_exploded" + (id.getImage());
            File file = new File(image);
            if (file.exists()) {
                file.delete();
                System.out.println("文件已经被成功删除");
        }
        membersDao.update(members);
    }

    public void deleteById(int id) throws Exception {

        Members name = membersDao.findById(id);
        String image = "C:/Users/Administrator/IdeaProjects/zy-company/out/artifacts/zy_company_war_exploded" + (name.getImage());
        File file = new File(image);
        if (file.exists()) {
            file.delete();
            System.out.println("文件已经被成功删除");
        }
        membersDao.delete(id);

    }
}
