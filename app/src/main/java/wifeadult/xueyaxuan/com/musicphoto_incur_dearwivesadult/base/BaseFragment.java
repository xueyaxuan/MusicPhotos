package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;


/**
 * @author wangchenchen
 * @desc   Fragment基类的抽取
 * @date 2017/6/9.
 */

public abstract class BaseFragment extends Fragment {
    //用于获取上下文对象
    protected Activity mContext;
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       // this.mContext = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       this.mContext =  getActivity();
       this.mContext =  getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImmersionBar.with(this)
                .statusBarColor(android.R.color.white)
                .statusBarAlpha(0.0f)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .init();
        View rootView = initView(inflater);
        return rootView;
    }

    /**初始化布局的方法
     * @return
     */
    protected abstract View initView(LayoutInflater inflater);


    /**Activity创建成功时调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化布局
        //initData();
        //初始化监听器
        initListener();
    }


  //** 指示Fragment是否是第一次显示 *//*
    private boolean isFirstShow = true;

    //** 当Fragment的可见性发改变的时候系统会调用这个方法 *//*
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser && isFirstShow) {
            // 如果Fragment是可见的，而且是第一次显示，则调用initData加载网络数据
            isFirstShow = false;	// 预防加载多次

            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    initData();
                }
            };

            // 延迟20毫秒再执行runnable中的run方法，是为了让onCreateView方法先执行完
            new Handler().postDelayed(runnable, 20);
        }
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听器
     */
    protected abstract void initListener();


    /**跳转目标Activity
     * @param tarActivity   跳转的Activity
     * @param bundle    需要传递的数据
     */
    protected void intent2Activity(Class<? extends Activity> tarActivity,Bundle bundle) {
        Intent intent = new Intent(getActivity(), tarActivity);
        if (bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**跳转目标Activity
     * @param tarActivity   跳转的Activity
     */
    protected void openActivity(Class<? extends Activity> tarActivity) {
        intent2Activity(tarActivity, null);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
