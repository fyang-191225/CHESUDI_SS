package com.ams.carsys.info.service.bo;

import com.ams.carsys.order.service.bo.SelectOrder;


import java.util.List;

/**
 * @author FYY
 * @date 2019/11/6 0006 下午 17:39
 */
/*
* Page :
* 表示分页查询需要的参数
*/
public class Page {
    /* result ： 查询出的符合分页查询条件的结果 */
    private List<SelectOrder> result;

    /* total: 查询出的符合分页查询条件的结果的 总个数 */
    private Integer total;

    /* pageNum：页码 即第几页 */
    private Integer pageNum;

    /* pageSize： 每页有多少行 */
    private Integer pageSize;

    /* startIndex：每一页从那条数据开始 */
    private Integer startIndex;

    /* pages: 共多少页 */
    private Integer pages;

    public Page() {
    }

    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.startIndex = (this.pageNum - 1) * this.pageSize;
    }

    public List<SelectOrder> getResult() {
        return result;
    }

    public void setResult(List<SelectOrder> result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        /* 计算出共多少页： 总计/每页的个数 */
        this.pages = total/pageSize;
        /* 判断：
        * 如果有余数加一页；没有余数不加
        *  */
        if (total%pageSize != 0) {
            pages = pages + 1;
        }
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public String toString() {
        return "Page{" +
                "result=" + result +
                ", total=" + total +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", pages=" + pages +
                '}';
    }
}
