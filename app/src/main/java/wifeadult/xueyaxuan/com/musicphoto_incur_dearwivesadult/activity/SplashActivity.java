package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.activity;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.widget.TextView;

import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.R;
import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.base.BaseActivity;

/**
 * Created by 薛亚轩
 * on 2017/8/13.
 * 闪屏界面
 */

public class SplashActivity extends BaseActivity {
    private TextView tv_appName,tv_date,tv_incur;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_splash);
        tv_appName = (TextView) findViewById(R.id.tv_appName);
        tv_date = (TextView) findViewById(R.id.tv_dates);
        tv_incur = (TextView) findViewById(R.id.tv_incur);
        tv_date.setText("");
        tv_incur.setText("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ObjectAnimator alpha = ObjectAnimator
                .ofFloat(tv_appName,"alpha",0f,1f);
        ObjectAnimator scaleY = ObjectAnimator
                .ofFloat(tv_appName,"scaleY",0f,1f);
        final ObjectAnimator scaleX = ObjectAnimator
                .ofFloat(tv_appName,"scaleX",0f,1f);

        final ObjectAnimator alphas = ObjectAnimator
                .ofFloat(tv_date,"alpha",0f,1f);
        final ObjectAnimator translate = ObjectAnimator
                .ofFloat(tv_date,"translationY",1000f,tv_date.getTranslationY());

        final ObjectAnimator targetAlpha = ObjectAnimator
                .ofFloat(tv_incur,"alpha",0f,1f);
        final ObjectAnimator targetTranslate = ObjectAnimator
                .ofFloat(tv_incur,"translationY",1000f,tv_incur.getTranslationY());
        AnimatorSet targets = new AnimatorSet();
        targets.play(alpha).with(scaleX);
        targets.play(scaleX).with(scaleY);
        targets.setDuration(1500);
        targets.start();

        targets.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                tv_date.setText("*********");
                AnimatorSet sets = new AnimatorSet();
                sets.play(translate).with(alphas);
                sets.setDuration(1500);
                sets.start();
                sets.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        tv_incur.setText("*****");
                        AnimatorSet set = new AnimatorSet();
                        set.play(targetTranslate).with(targetAlpha);
                        set.setDuration(1500);
                        set.start();
                        set.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        openActivity(GuideActivity.class);
                                        finish();
                                    }
                                },2000);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
