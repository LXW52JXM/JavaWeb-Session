package com.hieu.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CakeDb {
    private  static HashMap<String,Cake> cakeHashMap=new HashMap<>();
    static {
        cakeHashMap.put("1001",new Cake("1001","奶茶"));
        cakeHashMap.put("1002",new Cake("1002","蛋糕"));
        cakeHashMap.put("1003",new Cake("1003","水壶"));
        cakeHashMap.put("1004",new Cake("1004","冰淇淋"));
        cakeHashMap.put("1005",new Cake("1005","茶"));
        cakeHashMap.put("1006",new Cake("1006","可乐"));
    }

    /**
     * 获取全部信息
     * @return
     */
    public static Collection<Cake> getAll(){
        return cakeHashMap.values();
    }

    /**
     * 根据HashMap的键查找商品（键和商品id相同）
     * @param id
     * @return
     */
    public static Cake getCakeByID(String id){
        return cakeHashMap.get(id);
    }
}
