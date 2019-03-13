package com.owen.firebaseupload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    private Button mButtonUpload, mButtonChoose;
    private TextView mtxtViewShowUpload;
    private EditText metFilename;
    private ImageView mImageView;
    private ProgressBar mMrogressBar;

    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
