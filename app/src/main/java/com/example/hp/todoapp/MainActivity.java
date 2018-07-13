package com.example.hp.todoapp;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView itemArrayList;
    ListView list;
    ArrayAdapter<TodoApp> adapter;
    TodoProvider provider;
    private ArrayList<listview> ItemArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        provider = new TodoProvider(this);

        //list.setAdapter(new TodoAdapter(provider));
        getList();
        list = (ListView) findViewById(R.id.lv);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                setContentView(R.layout.activity_listview);
                Toast.makeText(getApplicationContext(), "task", Toast.LENGTH_SHORT).show();

            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Task completed", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(), Additem.class);
                startActivity(i1);
            }

        });
    }


    void getList() {


        try {
            ItemArraylist= new ArrayList<listview>();

            SQLiteDatabase db = this.openOrCreateDatabase("Todos.db", MODE_PRIVATE, null);
            Cursor c = db.rawQuery("select * from Todos", null);
            int index1 = c.getColumnIndex("title");
            int index2 = c.getColumnIndex("sampletext");
            provider.createTodo(c.getString(index1), c.getString(index2));
            c.moveToFirst();
            String title;

            while (c != null) {
                Log.i("Title: ", c.getString(index1));
                Log.i("Description: ", c.getString(index2));


                for (int i = 0; i < itemArrayList.setAdapter(0); i++) {
                    title=itemArrayList.get(i)Title;
                }
                );
                adapter.add();
                c.moveToNext();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            int simple_list_item_1 = 0;
            adapter = new <TodoApp>(MainActivity, simple_list_item_1, itemArrayList)

            list.setAdapter(adapter);

            adapter.notifyDataSetChanged();

        }


    }
}








