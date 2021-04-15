package edu.xcdq.shop;

import java.util.Scanner;

/**
 * @author hongxiaozheng
 * @date 2021/4/6 16:38
 */
public class ArticleManage {
    ArticleSet articleSet = new ArticleSet();

    //仓库初始化，放入一些商品
    public void initial(){
        Article xiaomi11 = new Article();
        /*xiaomi11.name = "小米11";
        xiaomi11.number = 30;
        xiaomi11.amount = 0;
        xiaomi11.price = 1999;*/
        xiaomi11.setArticle("名字",22221.00,0,0);

        Article xiaomi11Pro = new Article();
        xiaomi11Pro.setArticle("小米11Pro",2999,20,0);

        Article xiaomiUltra = new Article();
        xiaomiUltra.setArticle("小米至尊版",3999,20,0);

        articleSet.articles[0] = xiaomi11;
        articleSet.articles[1] = xiaomi11Pro;
        articleSet.articles[2] = xiaomiUltra;
        
        
        
    }
    
    
    //启动菜单
    public void startMenu(){
        boolean flag = true;  //是否继续操作
        do {
            System.out.println("**************************");
            System.out.println("1 查看商品信息");
            System.out.println("2 新增商品信息");
            System.out.println("3 删除商品信息");
            System.out.println("4 卖出商品");
            System.out.println("5 商品销售排行榜");
            System.out.println("6 退出");
            System.out.println("**************************");
            System.out.println("请输入功能编号");

            Scanner scanner = new Scanner(System.in);
            int funNo =  scanner.nextInt();
            switch (funNo){
                case 1:
                    System.out.println("查看商品信息");
                    chakan();
                    break;
                case 2:
                    System.out.println("2 新增商品信息");
                    add();
                    break;
                case 3:
                    System.out.println("3 删除商品信息");
                    delete();
                    break;
                case 4:
                    System.out.println("卖出商品");
                    saleOut();
                    break;
                case 5:
                    System.out.println("排行榜");
                    leadeBand();
                    break;
                case 6:
                    System.out.println("谢谢，已退出");
                    System.out.println("系统已关闭");
                    flag = false;
                    break;
                default:
                    System.out.println("你输入的功能编号有误，请重新选择");
                    break;

            }
        }while (flag);
        
    }

    private void chakan() {  //查看商品信息
        System.out.println("编号\t名字\t单价\t库存\t已售");
        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i]!= null){
                articleSet.articles[i].print(i+1);
            }

        }
    }

    private void add() {   //新增商品信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品的名称：");
        String name = scanner.next();
        System.out.println("请输入单价：");
        double price = scanner.nextDouble();
        System.out.println("请输入库存：");
        int count = scanner.nextInt();
        System.out.println("请输入已卖数量：");
        int number = scanner.nextInt();

        Article newArticle = new Article();
        newArticle.setArticle(name,price,count,number);

        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i] == null){
                articleSet.articles[i] = newArticle;  // 把新建的对象放在数组中的第一个空位置
                break; //后续的空位置直接跳过
            }

        }

    }

    private void delete() {  //删除商品信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的商品编号：");
        int bianhao = scanner.nextInt();
        boolean flag = true;
        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i]!= null && (i+1) == bianhao){
                int j = i;
                while (articleSet.articles[j+1]!=null ){
                    //后面的元素向前移动
                    articleSet.articles[j] = articleSet.articles[j+1];
                    j++;
                }
                articleSet.articles[j] = null;
                flag = true;
                break; //后续的空数组元素没有必要执行
            }else {
                flag = false;
            }

        }
        if (flag){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }

    private void saleOut() {   //卖出商品
        /*
            接收用户的输入，找到要卖出的商品在数组中的位置，修改对应的库存
            sout(请输入要销售的商品名称：)
            sc = new Scanner()
            for()
            if(元素不为空null &&[i].name equals (name)) //在数组的有值的元素中  找到售出商品名字相同的位置
                sout(输入卖出的数量：)
                sc。nextInt()
                if(卖出的数量<库存[i].amount )
                库存[i].amount = [i].amount - 卖出数量
                售出[i]number = [i].numder + 卖出数量
                sout(卖出成功)
            break;

         */
        System.out.println("请输入要售卖的商品名称：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < articleSet.articles.length; i++) {
            if ((articleSet.articles[i].name).equals(name)){
                System.out.println("请输入你要售卖的数量：");
                int shoumai = scanner.nextInt();
                if (shoumai < articleSet.articles[i].amount){
                    articleSet.articles[i].amount = articleSet.articles[i].amount - shoumai;
                    articleSet.articles[i].number = articleSet.articles[i].number + shoumai;
                }
                System.out.println("售卖成功");
                break;
            }
        }
    }

    private void leadeBand() {    //销量排行榜
        /*
            for ()  所有元素全部参与排序
                for () 当前元素只和后面的元素比较
                    if (当前元素<后续的元素)
                        往后排
         */

        //排序
        for (int i = 0; i < articleSet.articles.length - 1; i++) {
            for (int j = 0; j < articleSet.articles.length - i - 1; j++) {
                if (articleSet.articles[j] != null && articleSet.articles[j+1] != null){  //数组中不为null才能参与排序
                    if (articleSet.articles[j].number < articleSet.articles[j+1].number){

                        Article newTemp = articleSet.articles[j];  //新定义一个临时变量，实现两个数据的交换位置
                        articleSet.articles[j] = articleSet.articles[j+1];
                        articleSet.articles[j+1] = newTemp;
                    }

                }

            }


        }
        //打印结果
        for (int i = 0; i < articleSet.articles.length; i++) {
            if (articleSet.articles[i] != null){
                System.out.println((i+1)+"\t" + articleSet.articles[i].name + "\t" + articleSet.articles[i].number );
            }

        }




    }










}
