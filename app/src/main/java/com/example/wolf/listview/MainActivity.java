package com.example.wolf.listview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(new ColorsAdapter(this));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private static class ColorsAdapter extends BaseAdapter{

        private static final int MAX_ELEMENTS = 255 ;
        private Integer[] colors;

        private LayoutInflater mInflater;


        private ColorsAdapter(Context context){

            mInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            Random random = new Random();
            colors = new Integer[1000];
            for (int i = 0; i < colors.length; i++) {
                colors[i] = Color.rgb(random.nextInt(MAX_ELEMENTS),
                        random.nextInt(MAX_ELEMENTS),
                                random.nextInt(MAX_ELEMENTS));
            }

        }

        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public Object getItem(int position) {
            return colors[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null){
                convertView = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            }
            TextView mainView = (TextView) convertView;
            mainView.setBackgroundColor(colors[position]);
            return mainView;
        }
    }
}
