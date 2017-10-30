package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.yasic.bubbleview.BubbleView;

import java.util.ArrayList;
import java.util.List;

import wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.R;

public class MainActivity extends Activity implements View.OnClickListener,View.OnLongClickListener{
    private TextView tv_title,tv_sure_one,tv_sure_two,tv_name_one,tv_name_two;
    private LinearLayout checkBox,ll_photoName_one,ll_photoName_two;
    private EditText et_input_one,et_input_two;
    private LinearLayout ll_ToHoldYourHand,ll_IProteetYou,title,ll_showNameOne,ll_showNameTwo,music_Controller;
    private PopupWindow popupWindow;
    private BubbleView bubbleView;
    private TextView music_start,music_last,music_stop,music_next;
    private List<Drawable> lists = new ArrayList<>();
    private DisplayMetrics dm;
    private MediaPlayer mediaPlayer;
    private float position = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTranslucent(this,100);
        addDatas();
        music_last = (TextView) findViewById(R.id.rb_butn_last);
        music_next = (TextView) findViewById(R.id.rb_butn_next);
        music_start = (TextView) findViewById(R.id.rb_butn_startORpause);
        music_stop = (TextView) findViewById(R.id.rb_butn_stop);
        music_Controller = (LinearLayout) findViewById(R.id.ll_music_controller);
        ll_showNameOne = (LinearLayout) findViewById(R.id.ll_showPhotosNameOne);
        ll_showNameTwo = (LinearLayout) findViewById(R.id.ll_showPhotosNameTwo);
        tv_name_one = (TextView) findViewById(R.id.tv_photosName_one);
        tv_name_two = (TextView) findViewById(R.id.tv_photosName_two);
        tv_sure_one = (TextView) findViewById(R.id.tv_click_sure_photosOne);
        tv_sure_two = (TextView) findViewById(R.id.tv_click_sure_photosTwo);
        ll_photoName_one = (LinearLayout) findViewById(R.id.ll_photos_one);
        ll_photoName_two = (LinearLayout) findViewById(R.id.ll_photos_two);
        et_input_one = (EditText) findViewById(R.id.edit_intput_photosOne);
        et_input_two = (EditText) findViewById(R.id.edit_intput_photosTwo);
        ll_IProteetYou = (LinearLayout) findViewById(R.id.ll_IProteetYou);
        ll_ToHoldYourHand = (LinearLayout) findViewById(R.id.ll_ToHoldYourHand);
        tv_title = (TextView) findViewById(R.id.tv_titlebar_back);
        bubbleView = (BubbleView) findViewById(R.id.bv_bubbleView);
        checkBox = (LinearLayout) findViewById(R.id.ll_butn_menu);
        title  = (LinearLayout) findViewById(R.id.ll_title);
        initListener();
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        initView();
        CountDownTimer timer = new CountDownTimer((24*60*60)*1000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                initView();
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              music_Controller.setVisibility(View.GONE);
            }
        },10000);
//        musicStartMethod();
    }

    /**
     * 自定义音乐播放方法
     */
    private void musicStartMethod() {
       if(mediaPlayer == null){
           mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.yatou_wangtongyu);
           mediaPlayer.start();
       }else{
           mediaPlayer.start();
       }
    }

    /**
     * 音乐停止播放方法
     */
    private void musicPauseMethod(){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    /**
     * 自定义音乐停止播放
     */
    private void musicStopMethod(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    /**
     * 初始化动画特效
     */
    private void initView(){
        bubbleView.setDrawableList(lists);//添加数据
        bubbleView.setRiseDuration(1000*5);//上升动画持续事件
        bubbleView.setBottomPadding(0);//开始位置相对底部的距离
        bubbleView.setAnimationDelay(0);//两个上升动画的间隔时间
        bubbleView.setMaxHeartNum(5);//屏幕最大显示数量
        bubbleView.setMinHeartNum(5);//屏幕最小显示数量
        bubbleView.setOriginsOffset(200);//随机初始位置的间隔
        bubbleView.setScaleAnimation(10,1);//放大、缩小的倍数
        bubbleView.setItemViewWH(20,20);//单个视图的宽高
        bubbleView.startAnimation(dm.widthPixels,dm.heightPixels);//开始动画  屏幕的宽高
    }

    /**
     * 集合填充数据
     */
    private void addDatas() {
        lists.add(getDrawable(R.drawable.icon_star_one));
        lists.add(getDrawable(R.drawable.icon_star_two));
        lists.add(getDrawable(R.drawable.icon_star_three));
        lists.add(getDrawable(R.drawable.icon_star_four));
        lists.add(getDrawable(R.drawable.icon_star_five));
        lists.add(getDrawable(R.drawable.icon_star_six));
        lists.add(getDrawable(R.drawable.icon_star_seven));
        lists.add(getDrawable(R.drawable.icon_star_eight));
        lists.add(getDrawable(R.drawable.icon_star_two_one));
        lists.add(getDrawable(R.drawable.icon_star_two_two));
        lists.add(getDrawable(R.drawable.icon_star_two_three));
        lists.add(getDrawable(R.drawable.icon_star_two_four));
        lists.add(getDrawable(R.drawable.icon_star_two_five));
        lists.add(getDrawable(R.drawable.icon_star_two_six));
        lists.add(getDrawable(R.drawable.icon_star_two_seven));
        lists.add(getDrawable(R.drawable.icon_star_two_eight));
        lists.add(getDrawable(R.drawable.icon_star_three_one));
        lists.add(getDrawable(R.drawable.icon_star_three_two));
        lists.add(getDrawable(R.drawable.icon_star_three_three));
        lists.add(getDrawable(R.drawable.icon_star_three_four));
        lists.add(getDrawable(R.drawable.icon_star_three_six));
        lists.add(getDrawable(R.drawable.icon_star_three_seven));
        lists.add(getDrawable(R.drawable.icon_star_three_eight));
        lists.add(getDrawable(R.drawable.icon_star_three_five));
    }

    /**
     * 初始化点击事件
     */
    private void initListener() {
        checkBox.setOnClickListener(this);
        ll_ToHoldYourHand.setOnClickListener(this);
        ll_IProteetYou.setOnClickListener(this);
        ll_showNameOne.setOnLongClickListener(this);
        ll_showNameTwo.setOnLongClickListener(this);
        tv_sure_one.setOnClickListener(this);
        tv_sure_two.setOnClickListener(this);
        et_input_two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!et_input_two.getText().toString().equals("")){
                    tv_sure_two.setText("确定");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_input_one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!et_input_one.getText().toString().equals("")){
                    tv_sure_one.setText("确定");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        music_next.setOnClickListener(this);
        music_last.setOnClickListener(this);
        music_start.setOnClickListener(this);
        music_stop.setOnClickListener(this);
        bubbleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        position = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        if(event.getY() > position && (event.getY() - position) > 200.0){
                           music_Controller.setVisibility(View.GONE);
                        }else if(event.getY() < position && (position - event.getY()) > 200.0){
                            music_Controller.setVisibility(View.VISIBLE);
                        }
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_IProteetYou:
                Intent intent1 = new Intent(this,IProteetYouActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_ToHoldYourHand:
                Intent intent2 = new Intent(this,ToHoldYourHandActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_butn_menu:
                if(ll_showNameOne.getVisibility() != View.VISIBLE && ll_photoName_one.getVisibility() == View.VISIBLE){
                    if(!et_input_one.getText().toString().equals("")){
                        ll_showNameOne.setVisibility(View.VISIBLE);
                        tv_name_one.setText(et_input_one.getText().toString());
                        et_input_one.setText("");
                        ll_photoName_one.setVisibility(View.GONE);
                    }else{
                        ll_photoName_one.setVisibility(View.GONE);
                        ll_showNameOne.setVisibility(View.VISIBLE);
                    }
                }else if(ll_showNameTwo.getVisibility() != View.VISIBLE && ll_photoName_two.getVisibility() == View.VISIBLE){
                    if(!et_input_two.getText().toString().equals("")){
                        ll_showNameTwo.setVisibility(View.VISIBLE);
                        tv_name_two.setText(et_input_two.getText().toString());
                        et_input_two.setText("");
                        ll_photoName_two.setVisibility(View.GONE);
                    }else{
                        ll_photoName_two.setVisibility(View.GONE);
                        ll_showNameTwo.setVisibility(View.VISIBLE);
                    }
                }
                categroy();
                break;
            case R.id.tv_click_sure_photosOne:
                if(tv_sure_one.getText().equals("取消")){
                    ll_showNameOne.setVisibility(View.VISIBLE);
                    ll_photoName_one.setVisibility(View.GONE);
                }else if(tv_sure_one.getText().toString().equals("确定")){
                    if(!et_input_one.getText().toString().equals("")){
                        ll_showNameOne.setVisibility(View.VISIBLE);
                        tv_name_one.setText(et_input_one.getText().toString());
                        et_input_one.setText("");
                        ll_photoName_one.setVisibility(View.GONE);
                    }
                }
                break;
            case R.id.tv_click_sure_photosTwo:
                if(tv_sure_two.getText().equals("取消")){
                    ll_showNameTwo.setVisibility(View.VISIBLE);
                    ll_photoName_two.setVisibility(View.GONE);
                }else if(tv_sure_two.getText().toString().equals("确定")){
                    if(!et_input_two.getText().toString().equals("")){
                        ll_showNameTwo.setVisibility(View.VISIBLE);
                        tv_name_two.setText(et_input_two.getText().toString());
                        et_input_two.setText("");
                        ll_photoName_two.setVisibility(View.GONE);
                    }
                }
                break;
            case R.id.rb_butn_startORpause:
                if(mediaPlayer == null || !mediaPlayer.isPlaying()){
                    music_start.setBackground(getDrawable(R.drawable.icon_music_pause));
                    musicStartMethod();
                }else if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    music_start.setBackground(getDrawable(R.drawable.icon_music_start));
                    musicPauseMethod();
                }
                break;
            case R.id.rb_butn_next:

                break;
            case R.id.rb_butn_last:

                break;
            case R.id.rb_butn_stop:
                if(mediaPlayer != null){
                    musicStopMethod();
                    music_start.setBackground(getDrawable(R.drawable.icon_music_start));
                }else{
                    Toast.makeText(MainActivity.this,"当前无歌曲播放!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 用于选择列表项的选择区域
     */
    private void categroy() {
        View view = View.inflate(this, R.layout.popup_item_layout, null);
        TextView cumulative = (TextView) view.findViewById(R.id.tv_item_myInvoice);
        TextView newAdd = (TextView) view.findViewById(R.id.tv_item_Invoice);
        cumulative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        newAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow = new PopupWindow(view, title.getWidth()/2-100, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        popupWindow.showAsDropDown(checkBox);
        if (popupWindow.isShowing()) {
            checkBox.setBackground(getDrawable(R.drawable.icon_butn_close));
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                checkBox.setBackground(getDrawable(R.drawable.icon_butn_open));
            }
        });
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.ll_showPhotosNameOne:
                if(ll_showNameOne.getVisibility() == View.VISIBLE && ll_photoName_one.getVisibility() == View.GONE){
                    ll_showNameOne.setVisibility(View.GONE);
                    ll_photoName_one.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_showPhotosNameTwo:
                if(ll_showNameTwo.getVisibility() == View.VISIBLE && ll_photoName_two.getVisibility() == View.GONE){
                    ll_showNameTwo.setVisibility(View.GONE);
                    ll_photoName_two.setVisibility(View.VISIBLE);
                }
                break;
        }
        return false;
    }
}
