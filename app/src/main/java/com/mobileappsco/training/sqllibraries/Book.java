package com.mobileappsco.training.sqllibraries;

import com.orm.SugarRecord;

/**
 * Created by admin on 3/1/2016.
 */
public class Book extends SugarRecord {
    String title;
    String edition;

    public Book(){
    }

    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }
}
