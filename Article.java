package edu.xcdq.shop;

/**
 * @author hongxiaozheng
 * @date 2021/4/6 16:24
 */

/**
 * 商品物件类
 * 自定义类 Article
 */
public class Article {
    //名字 单价 库存 已卖数量
    public String name;
    public double price;
    public int amount;
    public int number;

    public void print(int index){
        System.out.println(index + "\t" + name + "\t"+ price + "\t" + amount + "\t" + number);
    }


    public void setArticle(String mingzi , double danjia , int kucun , int yishuo){
        name = mingzi;
        price = danjia;
        amount = kucun;
        number = yishuo;
    }





}
