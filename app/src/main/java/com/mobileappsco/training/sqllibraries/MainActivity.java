package com.mobileappsco.training.sqllibraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etEdition;
    TextView txtView1;
    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etEdition = (EditText) findViewById(R.id.etEdition);
        txtView1 = (TextView) findViewById(R.id.txtView1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new DownloadImageTask(this, imageView1).execute("http://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS");
        Glide.with(this)
                .load("http://www.parkeasier.com/wp-content/uploads/2015/05/REL-Android.png")
                .into(imageView2);
    }

    public void readBookDB(View view) {
        /*Book book = Book.findById(Book.class, 1);
        txtView1.setText("Title: "+book.title+
        "\nEdition: "+book.edition);*/
        List<Book> books = Book.listAll(Book.class);
        txtView1.setText("");
        for (Book book : books) {
            txtView1.setText(txtView1.getText().toString()+
                        "Title: "+book.title+
                        "\nEdition: "+book.edition+"\n\n");
        }
    }

    public void saveBook(View view) {
        Book book = new Book(etTitle.getText().toString(),
                            etEdition.getText().toString());
        book.save();
    }
}
