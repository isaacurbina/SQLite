package com.mobileappsco.training.sqllibraries;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by admin on 3/1/2016.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    private ProgressDialog mDialog;
    private ImageView bmImage;
    private Context mContext;

    public DownloadImageTask(Context mContext, ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected void onPreExecute() {
        //mDialog = ProgressDialog.show(mContext,"Please wait...", "Retrieving data ...", true);
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", "image download error");
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        //set image of your imageview
        bmImage.setImageBitmap(result);
        //close
        //mDialog.dismiss();
    }
}
