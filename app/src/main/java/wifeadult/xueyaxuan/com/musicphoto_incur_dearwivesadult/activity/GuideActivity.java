package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.R;
import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.adapter.GuideAdapter;
import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.utils.SPUtils;
import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.utils.UserInfo;

/**
 * Created by 薛亚轩
 * on 2017/8/13.
 */

public class GuideActivity extends Activity implements View.OnClickListener{
    private ViewPager vpGuide;
    private ImageView ivDots1;
    private ImageView ivDots2;
    private ImageView ivDots3;
    private List<ImageView> imageDots;
    private List<View> imagesViews;
    private TextView tvStartLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        vpGuide = (ViewPager) findViewById(R.id.vp_guide);
        ivDots1 = (ImageView) findViewById(R.id.iv_gray_dots1);
        ivDots2 = (ImageView) findViewById(R.id.iv_gray_dots2);
        ivDots3 = (ImageView) findViewById(R.id.iv_gray_dots3);
        tvStartLogin = (TextView) findViewById(R.id.tv_start_login);//登录按钮
        //小圆点的集合
        imageDots = new ArrayList<>();
        imageDots.add(ivDots1);
        imageDots.add(ivDots2);
        imageDots.add(ivDots3);

        initListener();

        //资源文件
        imagesViews = getImageViews();
        vpGuide.setAdapter(new GuideAdapter(imagesViews));

        selectDots(0);
    }


    private void initListener() {
        vpGuide.addOnPageChangeListener(new PagetSelectListener());
        tvStartLogin.setOnClickListener(this);
    }

    /**
     * 添加所需要的文件,并且返回这个数组
     */
    private List<View> getImageViews() {
        List<View> imagesViews = new ArrayList<>();
        LayoutInflater lf = getLayoutInflater().from(this);
        imagesViews.add(lf.inflate(R.layout.layout_indicator_two, null));
        imagesViews.add(lf.inflate(R.layout.layout_indicator_one, null));
        imagesViews.add(lf.inflate(R.layout.layout_indicator_three, null));
        return imagesViews;
    }

    @Override
    public void onClick(View v) {
        /*点击开始体验后，下次打开程序将不再显示引导页*/
        SPUtils.getSharedPreferencesUtil(this).setValue(UserInfo.IS_FRIST_USE,false);
        //进入到登录页
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 滑动监听
     */
    class PagetSelectListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            selectDots(position);
            if (position == 2){
                tvStartLogin.setVisibility(View.VISIBLE);
            }else {
                tvStartLogin.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**设置选中的小圆点
     * @param position
     */
    private void selectDots(int position) {
        for (int i=0; i<imageDots.size(); i++){
            if (i == position){
                imageDots.get(i).setImageResource(R.drawable.orange_dot);
            }else {
                imageDots.get(i).setImageResource(R.drawable.select_dot);
            }
        }
    }

}

