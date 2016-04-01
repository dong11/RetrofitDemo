package com.dong.huang.retrofitdemo;

import java.util.List;

/**
 * Created by dong on 16/4/1.
 */
/*
{
    "errNum": 0,
    "errMsg": "success",
    "retData": {
        "telString": "15846530170",
        "province": "黑龙江",
        "carrier": "黑龙江移动"
    }
}
 */
public class JsonModel {

    private List<JsonInfo> list;

    private int pageSize;

    private int pageNo;

    private int pageCount;

    private int totalCount;

    private int skipCount;

    private double negativeRatio;

    private int startRow;

    private int endRow;

    public void setList(List<JsonInfo> list){
        this.list = list;
    }
    public List<JsonInfo> getList(){
        return this.list;
    }
    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }
    public int getPageSize(){
        return this.pageSize;
    }
    public void setPageNo(int pageNo){
        this.pageNo = pageNo;
    }
    public int getPageNo(){
        return this.pageNo;
    }
    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }
    public int getPageCount(){
        return this.pageCount;
    }
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }
    public int getTotalCount(){
        return this.totalCount;
    }
    public void setSkipCount(int skipCount){
        this.skipCount = skipCount;
    }
    public int getSkipCount(){
        return this.skipCount;
    }
    public void setNegativeRatio(double negativeRatio){
        this.negativeRatio = negativeRatio;
    }
    public double getNegativeRatio(){
        return this.negativeRatio;
    }
    public void setStartRow(int startRow){
        this.startRow = startRow;
    }
    public int getStartRow(){
        return this.startRow;
    }
    public void setEndRow(int endRow){
        this.endRow = endRow;
    }
    public int getEndRow(){
        return this.endRow;
    }

    @Override
    public String toString() {
        return "JsonModel{" +
                "list=" + list +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                ", skipCount=" + skipCount +
                ", negativeRatio=" + negativeRatio +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                '}';
    }
}
