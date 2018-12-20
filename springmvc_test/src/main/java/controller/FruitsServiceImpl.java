package controller;

import java.util.ArrayList;
import java.util.List;

import model.Fruits;
import org.springframework.util.StringUtils;
public class FruitsServiceImpl implements FruitsService{

    public List<Fruits> fruitsList=null;

    public List<Fruits> init(){
        if(fruitsList==null){
            //初始化数据
            fruitsList = new ArrayList<Fruits>();

            Fruits apple = new Fruits();
            apple.setId(1);
            apple.setName("apple");
            apple.setPrice(2.3);
            apple.setProducing_area("shandong");

            Fruits Banana = new Fruits();
            Banana.setId(2);
            Banana.setName("香蕉");
            Banana.setPrice(1.5);
            Banana.setProducing_area("shanghai");

            fruitsList.add(apple);
            fruitsList.add(Banana);
            return fruitsList;
        }else{
            return fruitsList;
        }
    }

    public List<Fruits> queryFruitsList(){
        init();
        return fruitsList;
    }

    public Fruits queryFruitById(Integer id) {
        init();
        Fruits fruits;
        for (int i = 0; i < fruitsList.size(); i++) {
            fruits=fruitsList.get(i);
            if(fruits.getId()==id){
                return fruits;
            }
        }
        return null;
    }

    public List<Fruits> queryFruitsByCondition(Fruits fruits){
        init();
        String name=fruits.getName();
        String area=fruits.getProducing_area();
        List<Fruits> queryList=new ArrayList<Fruits>();
        Fruits f;
        for (int i = 0; i < fruitsList.size(); i++)
        {
            f=fruitsList.get(i);
            //有一项符合条件就返回
           // System.out.println(f.getName()+"........"+f.getProducing_area());
            System.out.println(fruits.getName() + "...,,,"+area);
            if((!name.equals("")&&f.getName().contains(name))||
                    (!area.equals("")&&f.getProducing_area().contains(area)))
            {
            //    System.out.println(",,");
                queryList.add(f);
            }
        }
        return queryList.size()>0?queryList:null;
    }
}
