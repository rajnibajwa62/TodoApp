package com.example.hp.todoapp;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;



class TodoProvider {
    public final String LOG_TAG = "TodoProvider.java";
    private SQLiteDatabase db;
    private TodoDBHelper dbHelper;


    public TodoProvider(Context context) {
        dbHelper=new TodoDBHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }


    public void createTodo(String TodoTitle,String TodoSample){

        ContentValues contentValues=new ContentValues();
        contentValues.put("COLUMN_TODO_TITLE",TodoTitle);
        contentValues.put("COLUMN_TODO_SAMPLE_TEXT",TodoSample);
        db.insert("Todos",null,contentValues);
    }

    public List<TodoApp> getTodos(){





        ArrayList<TodoApp> todoList=new ArrayList<TodoApp>();
        String []tableCol={"id","title","sampletext"};
        Cursor cursor=db.query("Todos",tableCol,null,null,null,null,null);
        cursor.moveToFirst();

        //result iterate
        while (!cursor.isAfterLast()) {
            TodoApp t = new TodoApp();
            t.setId(cursor.getInt(0));
            t.setTitle(cursor.getString(1));
            t.setDescription(cursor.getString(2));


            todoList.add(t);
            cursor.moveToNext();
        }
        return todoList;
    }

}

