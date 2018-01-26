package com.example.dedaloc2.camerat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dedaloc2.camerat.view.BooksListActivity;


public class MainActivity extends AppCompatActivity {

    int permissionCheck;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissionCheck = -1;
                //ContextCompat.checkSelfPermission(this,
                //Manifest.permission.CAMERA);


    }

    public void cameraCall(View view) {
            //Toast.makeText(this,"Not permission granted", Toast.LENGTH_SHORT).show();
        takePicture();
    }

    public void servicesBooks(View view){
        Intent intent = new Intent(this, BooksListActivity.class);
        startActivity(intent);
    }

    public void takePicture(){

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)) {
                Toast.makeText(this,"Required to print your image", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);
                //takePicture();
            }
            else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                }else {
                    Toast.makeText(this,"Required to print your image", Toast.LENGTH_SHORT).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }


    public void deleteImage(View view) {
        ImageView imageView =  (ImageView)findViewById(R.id.imageView);
        if (imageView != null) imageView.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setVisibility(View.VISIBLE);
            final Bitmap imageBitMap = (Bitmap)extras.get("data");
            imageView.setImageBitmap(imageBitMap);

        }
    }


}
