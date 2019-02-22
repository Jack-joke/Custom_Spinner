package com.example.dell.notmyapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class SpinnerAdapter extends BaseAdapter {
    Context myConText;
    int myLayout;
    List<Song> mylst;

    public SpinnerAdapter(Context conText, int layout, List<Song> mylst) {
        this.myConText = conText;
        this.myLayout = layout;
        this.mylst = mylst;
    }
    private class ViewHolder {
        private TextView ten, nam;
    }
    @Override
    public int getCount() {
        return mylst.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) myConText.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(myLayout, null);
            holder = new ViewHolder();
            //Ánh xạ
            holder.ten = view.findViewById(R.id.tv_ten);
            holder.nam = view.findViewById(R.id.tv_nam);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();
        //Gán giá trị từ List SV
        holder.ten.setText(mylst.get(i).getName());
        holder.nam.setText(mylst.get(i).getYear());
        return view;

    }
}
