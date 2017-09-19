package com.primehana.jacky.liqord;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by jacky on 9/19/17.
 */

public class ItemAdapter extends BaseAdapter {

    private Context m_context;
    private ArrayList<Item> m_items;
    private LayoutInflater m_inflater;

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.m_context = context;
        this.m_items = items;
        m_inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (m_items.size() < 0)
            return 0;
        return m_items.size();
    }

    public Object getItem(int position) {
        return m_items.get(position);
    }

    public long getItemId(int position) {
        return  position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View v = convertView;

        if (v == null) {
            v = m_inflater.inflate(R.layout.review_item, null);
        } else {
            holder = (ViewHolder) v.getTag();
        }


        TextView tt1 = (TextView) v.findViewById(R.id.textView11);
        TextView tt2 = (TextView) v.findViewById(R.id.textView10);
        TextView tt3 = (TextView) v.findViewById(R.id.textView9);
        TextView tt4 = (TextView) v.findViewById(R.id.textView8);
        TextView tt5 = (TextView) v.findViewById(R.id.textView7);
        TextView tt6 = (TextView) v.findViewById(R.id.textView6);

        tt1.setText(Integer.toString(m_items.get(position).m_quantity));
        tt2.setText(m_items.get(position).str_name);
        tt3.setText(m_items.get(position).m_liquor);
        tt4.setText(m_items.get(position).num);
        tt5.setText(m_items.get(position).str);
        tt6.setText("$" + Double.toString(m_items.get(position).price));

        return v;
    }

    static class ViewHolder {
        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;
        TextView text5;
        TextView text6;
    }
}
