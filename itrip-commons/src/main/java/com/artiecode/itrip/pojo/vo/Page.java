
package com.artiecode.itrip.pojo.vo;

import java.util.List;

/**
 * <p>分页处理类 .</p>
 *
 * @version v1.0
 * @author XX
 * @date Sep 21, 2011
 *
 */
public class Page<T> {
    private Integer curPage;
    /**
     * 总记录数 .
     */
    private Integer total;
    /**
     * 每页行数 .
     */
    private Integer pageSize;
    /**
     * 页面的总数  .
     */
    private Integer pageCount;
    /**
     * 结果集中数据的起始位置  .
     */
    private Integer beginPos;
    /**
     * List 集合.
     */
    private List<T> rows;

    public Page() {

    }
    /**
     * 当前页面 .
     * 页面的大小 .
     * @param curpage .
     * @param pagesize .
     */
    public Page(int curpage, Integer pagesize) {
        this.curPage = curpage;
        this.pageSize = pagesize;
    }
    /**
     * @param curpage .
     * @param total .
     * @param pagesize .
     */
    public Page(int curpage,Integer pagesize,Integer total) {
        super();
        this.curPage = curpage;//当前页码
        this.total = total;//总记录数
        this.pageSize = pagesize;//页码容量
        //总页数=总记录数total/pageSize（+1）
        this.pageCount = (total + this.pageSize - 1) /this.pageSize;
        //下标起始位置：(curPage-1)*pageSize
        this.beginPos = (curPage-1)*pageSize;
    }
    /**
     * 总页面数 .
     * @return Integer .
     */
    public Integer getPageCount() {
        return pageCount;
    }
    /**
     *  得到页面的当前位置 .
     * @return Integer .
     */
    public Integer getBeginPos() {
        return beginPos;
    }
    /**
     * @param curPage
     *            the curPage to set
     */
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    /**
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @param rowCount
     *            the rowCount to set
     */
    public void setRowCount(Integer rowCount) {
        this.total = rowCount;
    }

    /**
     * @param beginPos
     *            the beginPos to set
     */
    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
