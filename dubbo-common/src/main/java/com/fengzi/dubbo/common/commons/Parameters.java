package com.fengzi.dubbo.common.commons;

import lombok.Data;

import java.util.Set;

/**
 * 用于接收常用参数实体
 */
@Data
public class Parameters<T> {

    /**
     * 当前页码
     */
    private Integer pageNum;

    private Integer page;


    /**
     * 每页数量
     */
    private Integer pageSize;

    private Integer limit;

    /**
     * 其实位置
     */
    private Integer pageStart;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 类型搜索
     */
    private Integer searchType;

    /**
     * 状态搜索
     */
    private Integer codeEnum;

    /**
     * 搜索关键词
     */
    private String searchName;

    /**
     * 泛型对象
     */
    private T t;


    /**
     * 是否进行 count 查询
     */
    private Boolean isSearchCount = true;

    /**
     * set集合
     */
    private Set ids;

    /**
     * 状态集合
     */
    private Set statuses;

    /**
     * 不包含该id
     */
    private Long notId;

    public Integer getPageNum() {
        if (this.pageNum == null) {
            return this.page;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (this.pageSize == null) {
            return this.limit;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
