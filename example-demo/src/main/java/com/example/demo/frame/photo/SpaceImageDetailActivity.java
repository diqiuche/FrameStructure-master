package com.example.demo.frame.photo;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;

import com.common.bean.paramsBean.PhotoParams;
import com.common.ui.base.activity.BaseActivity;
import com.common.view.imageview.SmoothImageView;
import com.fans.loader.FanImageLoader;

import uk.co.senab.photoview.PhotoViewAttacher;

public class SpaceImageDetailActivity extends BaseActivity implements PhotoViewAttacher.OnPhotoTapListener{

    SmoothImageView imageView = null;
    private PhotoParams mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatas = (PhotoParams) getIntent().getParcelableExtra("bean");
        imageView = new SmoothImageView(this);
        imageView.setOnPhotoTapListener(this);
        imageView.setOriginalInfo(mDatas.getWidth(), mDatas.getHeight(), mDatas.getLocationX(), mDatas.getLocationY() - getActionBarHeight());
        imageView.transformIn();
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ScaleType.FIT_CENTER);
        setContentView(imageView);
        FanImageLoader.create(mDatas.getThumbnail()).into(imageView);
    }





    @Override
    public void onBackPressed() {
        imageView.setOnTransformListener(new SmoothImageView.TransformListener() {
            @Override
            public void onTransformComplete(int mode) {
                if (mode == 2) {
                    finish();
                }
            }
        });
        imageView.transformOut();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public void onPhotoTap(View view, float v, float v1) {
        imageView.setOnTransformListener(new SmoothImageView.TransformListener() {
            @Override
            public void onTransformComplete(int mode) {
                if (mode == 2) {
                    finish();
                }
            }
        });
        imageView.transformOut();
    }
}
