package com.ljh.foodclub.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.utils.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.toptas.fancyshowcase.FancyShowCaseView;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

/**
 * Description:
 * Date on 2018/8/1
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class ShapeActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.iv_code)
    ImageView ivCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        ButterKnife.bind(this);
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "124");

        sequence.setConfig(config);

        sequence.addSequenceItem(btn1,
                "This is button one", "GOT IT");

        sequence.addSequenceItem(btn2,
                "This is button two", "GOT IT");


        sequence.start();
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Bitmap bitmap = CodeUtils.getInstance().createBitmap();
                ivCode.setImageBitmap(bitmap);
                btn1.setText(CodeUtils.getInstance().getCode());
//                new FancyShowCaseView.Builder(ShapeActivity.this)
//                        .focusOn(btn1)
//                        .title("Focus on View")
//                        .build()
//                        .show();
                break;
            case R.id.btn2:
                new FancyShowCaseView.Builder(ShapeActivity.this)
                        .focusOn(btn2)
                        .title("Focus on View")
                        .build()
                        .show();
                break;
        }
    }
}
