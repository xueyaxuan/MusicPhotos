package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;


/**
 * @author wangchenchen
 * @desc    Activity的基类抽取，
 * @date 2017/6/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    //用于获取上下文
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏颜色实现，参数二位想要实现的颜色
//        StatusBarCompat.compat(this,Color.BLACK);
        ImmersionBar.with(this)
                .statusBarColor(android.R.color.white)
                .statusBarAlpha(0.0f)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .init();
        mContext = this;
        //初始化UI
        initView();
        //初始化数据以及更新UI
        initData();
        //初始化监听器
        initListener();
    }

    // 初始化ui,在Bundle里面可以获取上一个界面的数据，不要忘记setContentview
    protected abstract void initView();

    // 初始化数据
    protected abstract void initData();

    // 添加监听器
    protected abstract void initListener();

    /**跳转目标Activity
     * @param tarActivity   跳转的Activity
     * @param bundle    需要传递的数据
     */
    protected void intent2Activity(Class<? extends Activity> tarActivity, Bundle bundle) {
        Intent intent = new Intent(mContext, tarActivity);
        if (bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**不用携带参数的跳转方法
     * @param tarActivity
     */
    public void openActivity(Class<? extends Activity> tarActivity ) {
        intent2Activity(tarActivity, null);
    }

}
