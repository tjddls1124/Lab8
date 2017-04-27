package com.example.lab8;

/**
 * Created by 최웅순 on 2017-04-27.
 */

public class Fruit {
    static public String[] fruit = {"아보카도","바나나","체리","크렌베리","포도","키위","오렌지","수박"};
    static public int[] fruit_imgno = {R.drawable.abocado,R.drawable.banana,
            R.drawable.cherry,R.drawable.cranberry,R.drawable.grape,R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};

    public String name;
    public int imgno;


    public Fruit(String name, int imgno) {
        this.name = name;
        this.imgno = imgno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgno() {
        return imgno;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }
}
