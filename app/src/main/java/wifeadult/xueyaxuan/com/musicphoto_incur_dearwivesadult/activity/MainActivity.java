package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.R;

import static wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.R.id.check_butn_menu;

public class MainActivity extends Activity {
    private TextView tv_title;
    private CheckBox checkBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTranslucent(this,100);
        tv_title = (TextView) findViewById(R.id.tv_titlebar_back);
        checkBox = (CheckBox) findViewById(check_butn_menu);
    }

//    @Override
//    protected void initView() {
//
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    protected void initListener() {
//
//    }
}
