package com.neuedu.bean;

import java.util.List;

public class Page {
    /**
     * 实现分页功能
     */
    private Integer count;  //总数
    private Integer pageCount = 4;  //一页中显示数据的条数
    private Integer pageNum; //页数
    private Integer currentPage;//当前的页数
    private List content;//当前页面显示的数据


    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        if(count % pageCount == 0){
            pageNum = count/pageCount;
        }else {
            pageNum = (count/pageCount)+1;
        }
        this.count = count;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}
