package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.R;
import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.utils.AnimationUtils;

/**
 * 作者： xueyaxuan
 * 时间： 2017/10/26
 * 功能描述:相册一界面功能实现
 */

public class ToHoldYourHandActivity extends Activity implements View.OnClickListener{
    private TextView mShowMsg;
    private View msgBackground;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold_you_hand);
        mShowMsg = (TextView) findViewById(R.id.tv_showMessage);
        msgBackground = findViewById(R.id.msg_background);
        initFirstAnimation();
        initListenner();
    }

    private void initFirstAnimation() {
        AnimationUtils.isReturn = true;
        ObjectAnimator scaleX = AnimationUtils.scaleAnimationFunction(mShowMsg,"X",1,2,3000);
        ObjectAnimator scaleY = AnimationUtils.scaleAnimationFunction(mShowMsg,"Y",1,2,3000);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX,scaleY);
        set.setDuration(3000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(msgBackground.getVisibility() == View.GONE){
                    msgBackground.setVisibility(View.VISIBLE);
                    mShowMsg.setTextColor(Color.parseColor("#000000"));
                }
                CountDownTimer timer = new CountDownTimer(4000,1000){

                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        AnimationUtils.isReturn = true;
                        ObjectAnimator msg = AnimationUtils.alphaAnimationFunction(mShowMsg,1,0,3000);
                        ObjectAnimator back = AnimationUtils.alphaAnimationFunction(msgBackground,1,0,3000);
                        AnimatorSet set = new AnimatorSet();
                        set.playTogether(msg,back);
                        set.setDuration(3000);
                        set.start();
                    }
                };
                timer.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    /**
     * 注册点击事件
     */
    private void initListenner() {
    }

    @Override
    public void onClick(View v) {


    }


}
