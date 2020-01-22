package com.owen.firebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private static final int PICK_IMAGE_REQUEST= 1;

    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Button btnUpload;
    private Button btnChooseImage;
    private TextView tvShowUploads;
    private EditText etFileName;

    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.image_view);
        btnChooseImage = findViewById(R.id.btn_choose_Image);
        btnUpload = findViewById(R.id.btn_uploads);
        tvShowUploads = findViewById(R.id.tv_showUploads);
        etFileName =findViewById(R.id.et_file_name);

    }

    @Override
    public void onClick(View v) {
        if (v==btnChooseImage)
        {
            openFileChooser();
        }
        if (v==btnUpload)
        {

        }
        if (v==tvShowUploads)
        {

        }

    }
    public void openFileChooser()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData() != null)
        {
            mImageUri = data.getData();

            Picasso.get().load(mImageUri).into(mImageView);
//            mImageView.setImageURI(mImageUri);
        }
    }
}
