/*package com.example.ronik.myticketproject1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<OneTableRawData> infoArray;

    public SpinnerAdapter(Context c, ArrayList<OneTableRawData> myInfoArray){
        context=c;
        infoArray=myInfoArray;
    }

    @Override
    public int getCount() {
        return infoArray.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView==null){
            LayoutInflater inflater = ((AppCompatActivity)context).getLayoutInflater();
            view=inflater.inflate(R.layout.activity_main,null,true);
        }else{
            view = (View)convertView;
        }

        TextView question = (TextView) view.findViewById(R.id.textView);
        TextView correctAnswer = (TextView) view.findViewById(R.id.rb0);
        TextView wrongAnswer0 = (TextView) view.findViewById(R.id.rb1);
        TextView wrongAnswer1 = (TextView) view.findViewById(R.id.rb2);
        TextView wrongAnswer2 = (TextView) view.findViewById(R.id.rb3);

        question.setText(((OneTableRawData) infoArray.get(position)).);
    }
}

*/


