package com.dong.huang.retrofitdemo;

/**
 * Created by dong on 16/4/1.
 */
/*
"retData": {
        "telString": "15846530170",
        "province": "黑龙江",
        "carrier": "黑龙江移动"
    }
 */
public class JsonInfo {
    private int id;

    private String smallImg;

    private String title;

    private String h5Img;

    private String dateShow;

    private String summary;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setSmallImg(String smallImg){
        this.smallImg = smallImg;
    }
    public String getSmallImg(){
        return this.smallImg;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setH5Img(String h5Img){
        this.h5Img = h5Img;
    }
    public String getH5Img(){
        return this.h5Img;
    }
    public void setDateShow(String dateShow){
        this.dateShow = dateShow;
    }
    public String getDateShow(){
        return this.dateShow;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }
    public String getSummary(){
        return this.summary;
    }

    @Override
    public String toString() {
        return "JsonInfo{" +
                "id=" + id +
                ", smallImg='" + smallImg + '\'' +
                ", title='" + title + '\'' +
                ", h5Img='" + h5Img + '\'' +
                ", dateShow='" + dateShow + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
