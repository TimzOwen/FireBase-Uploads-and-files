package com.owen.firebaseupload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    private static final int PICK_IMAGE_REQUEST = 1;
    
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
        
            mButtonChoose = (Button)findViewById(R.id.btn_chooseFile);
        mButtonUpload = (Button)findViewById(R.id.btn_upload);
        mtxtViewShowUpload = (TextView)findViewById(R.id.tv_show_uploads);
        metFilename = (EditText)findViewById(R.id.et_choose_file_name);
        mImageView = (ImageView)findViewById(R.id.image_view);
        mProgressBar = (ProgressBar)findViewById(R.id.progress_Bar);

        mButtonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openImageChooser();

            }
        });

        mtxtViewShowUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void openImageChooser()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            mImageUri = data.getData();

//            Picasso.with(this).load(mImageUri).into(mImageView);
            mImageView.setImageURI(mImageUri);

        }
    }
    }
}
