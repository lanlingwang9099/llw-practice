package com.lin.community.entity;

//封装分页相关信息
public class Page {
    //私有属性需生成get set访问
    private int current=1; //当前页码  默认为1
    private int limit=10;  //每页上限
    private int rows; //数据总数  除limit就是总页数
    private String path; //分页地址链接

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1)
        this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1&&limit<=100)
        this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0)
        this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOffset(){
        return (current-1)*limit;
    }

    public int getTotal(){
        if(rows%limit==0)return rows/limit;
        return rows/limit+1;
    }

    public int getFrom(){  //获取起始页码
        if(current<=2)return 1;
        return current-2;
    }
    public int getTo(){  //获取结束页码
        int total=getTotal();
        if(current>=total-2)return total;
        else return current+2;
    }

//    @Override
//    public String toString() {
//        return "Page{" +
//                "current=" + current +
//                ", limit=" + limit +
//                ", rows=" + rows +
//                ", path='" + path + '\'' +
//                '}';
//    }
}
