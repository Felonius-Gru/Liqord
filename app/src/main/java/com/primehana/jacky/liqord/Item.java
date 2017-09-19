package com.primehana.jacky.liqord;

/**
 * Created by jacky on 9/19/17.
 */

public class Item {
    public int m_quantity;
    public String str_name;
    public String m_liquor;
    public String num;
    public String str;
    public double price;

    public Item(int m_quantity, String str_name, String m_liquor, String num, String str, double price) {
        this.m_quantity = m_quantity;
        this.str_name = str_name;
        this.m_liquor = m_liquor;
        this.num = num;
        this.str = str;
        this.price = price;
    }
}
