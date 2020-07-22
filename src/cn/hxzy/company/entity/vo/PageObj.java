package cn.hxzy.company.entity.vo;

import java.util.List;

public class PageObj<T> {
    private List<T> list;
    private Integer page = 1;
    private Integer size = 8;
    private Long count;
    private Integer pageCount;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PageObj{" +
                "list=" + list +
                ", page=" + page +
                ", size=" + size +
                ", count=" + count +
                ", pageCount=" + pageCount +
                '}';
    }
}
