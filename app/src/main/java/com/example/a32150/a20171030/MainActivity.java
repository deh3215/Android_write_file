package com.example.a32150.a20171030;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button btn_read, btn_write;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //File F = getFilesDir();
        //Log.d("File", F.getAbsoluteFile());

        btn_read = (Button)findViewById(R.id.btn_read);
        btn_write = (Button)findViewById(R.id.btn_write);
        tv=(TextView)findViewById(R.id.textView);

        btn_read.setOnClickListener(listener);
        btn_write.setOnClickListener(listener);
    }

    OnClickListener listener = new OnClickListener()    {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if(id == R.id.btn_read) {

                    fileRead();

            }   else if(id == R.id.btn_write)   {

                    fileWrite();

            }
        }
    };


    void fileRead() {

        char ch[] = new char[100];
        try {
            String path = "/data/data/com.example.a32150.a20171030/files/mydata.txt";
            int len = 0;
            StringBuilder sb = new StringBuilder();
            FileReader fr = new FileReader(path);
            while ((len = fr.read(ch)) > 0) {
                sb.append(new String(ch, 0, len));
            }
            System.out.println("讀出的字串"+sb);
            tv.setText(sb);
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found !");
        } catch (IOException ex) {
            System.out.println("IO error !");
        }

    }

    void fileWrite()   {

        File f = getFilesDir();
        File myfile = new File(f.getAbsolutePath() + f.separator + "mydata.txt");
        try {
            FileWriter fw = new FileWriter(myfile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("xxxxxxxxxxxx");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
