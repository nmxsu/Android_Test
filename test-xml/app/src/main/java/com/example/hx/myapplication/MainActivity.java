package com.example.hx.myapplication;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    /*
    在用户点击menu 按钮后会调用该方法，，我们可以在这个方法中加入自己的按钮控件
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,1,R.string.mp3list_undate);
        menu.add(1,2,2,R.string.mp3list_about);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        System.out.println("itemId----->"+item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
