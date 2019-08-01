package com.test.demo.test.apiDemo.customComponent.demo;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DEV002 on 2018/6/25.
 */

public class CustomCompoundControls extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new SpeechAdapter(this));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        ((SpeechAdapter)getListAdapter()).toggle(position);
    }

    class SpeechAdapter extends BaseAdapter{

        private Context mContext;

        public SpeechAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return ListData.TITLES.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public void toggle(int position) {
            Toast.makeText(mContext,"我是" + ListData.TITLES[position],Toast.LENGTH_SHORT).show();
//            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SpeechView sv;
            if(convertView == null){
                sv = new SpeechView(mContext,ListData.TITLES[position],ListData.DIALOGUE[position]);
            }else{
                sv = (SpeechView)convertView;
                sv.getTitle().setText(ListData.TITLES[position]);
                sv.getDialogue().setText(ListData.DIALOGUE[position]);
            }
            return sv;
        }
    }


    class SpeechView extends LinearLayout{

        private TextView mTitle;
        private TextView mDialogue;

        public SpeechView(Context mContext, String title, String s) {
            super(mContext);
            this.setOrientation(LinearLayout.VERTICAL);
            mTitle = new TextView(mContext);
            mTitle.setText(title);
            addView(mTitle,new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            mDialogue = new TextView(mContext);
            mDialogue.setText(s);
            addView(mDialogue,new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        }

        public TextView getTitle() {
            return mTitle;
        }

        public void setTitle(TextView mTitle) {
            this.mTitle = mTitle;
        }

        public TextView getDialogue() {
            return mDialogue;
        }

        public void setDialogue(TextView mDialogue) {
            this.mDialogue = mDialogue;
        }
    }

}
