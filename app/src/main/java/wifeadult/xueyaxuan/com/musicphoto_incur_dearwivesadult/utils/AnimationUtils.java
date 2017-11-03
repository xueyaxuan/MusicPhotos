package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.utils;

import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 作者： xueyaxuan
 * 时间： 2017/11/3
 * 功能描述: 属性动画工具类
 */

public class AnimationUtils {
    public static boolean isReturn = false;
    //放大缩小-属性动画
    /**
     *  @param view 要实现动画的视图
     * @param axle  X轴或者Y轴
     * @param startNum 开始值
     * @param animationTime  动画持续时间
     */
    public static ObjectAnimator scaleAnimationFunction(View view, String axle, int startNum, int animationTime){
        ObjectAnimator scale = ObjectAnimator.ofFloat(view,"scale"+axle,startNum);
        scale.setDuration(animationTime);
        if(!isReturn){
            scale.start();
        }else{
            return scale;
        }
        return scale;
    }

    /**
     *  @param view 要实现动画的视图
     * @param axle  X轴或者Y轴
     * @param startNum 开始值
     * @param endNum    结束值
     * @param animationTime  动画持续时间
     */
    public static ObjectAnimator scaleAnimationFunction(View view, String axle, int startNum, int endNum, int animationTime){
        ObjectAnimator scale = ObjectAnimator.ofFloat(view,"scale"+axle,startNum,endNum);
        scale.setDuration(animationTime);
        if(!isReturn){
            scale.start();
        }else{
            return scale;
        }
        return scale;
    }

    /**
     *  @param view 要实现动画的视图
     * @param axle  X轴或者Y轴
     * @param startNum 开始值
     * @param centerNum 中间值
     * @param endNum    结束值
     * @param animationTime  动画持续时间
     */
    public static ObjectAnimator scaleAnimationFunction(View view, String axle, int startNum, int centerNum, int endNum, int animationTime){
        ObjectAnimator scale = ObjectAnimator.ofFloat(view,"scale"+axle,startNum,centerNum,endNum);
        scale.setDuration(animationTime);
        if(!isReturn){
            scale.start();
        }else{
            return scale;
        }
        return scale;
    }

    //渐变-属性动画
    /**
     *  @param view 要实现动画的视图
     * @param startNum 开始值
     * @param animationTime 动画持续时间
     */
    public static ObjectAnimator alphaAnimationFunction(View view, int startNum, int animationTime){
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view,"alpha",startNum);
        alpha.setDuration(animationTime);
        if(!isReturn){
            alpha.start();
        }else{
            return alpha;
        }
        return alpha;
    }

    /**
     *  @param view 要实现动画的视图
     * @param startNum 开始值
     * @param endNum 结束值
     * @param animationTime 动画持续时间
     */
    public static ObjectAnimator alphaAnimationFunction(View view, int startNum, int endNum, int animationTime){
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view,"alpha",startNum,endNum);
        alpha.setDuration(animationTime);
        if(!isReturn){
            alpha.start();
        }else{
            return alpha;
        }
        return alpha;
    }

    /**
     *  @param view 要实现动画的视图
     * @param startNum 开始值
     * @param centerNum 中间值
     * @param endNum 结束值
     * @param animationTime  动画持续时间
     */
    public static ObjectAnimator alphaAnimationFunction(View view, int startNum, int centerNum, int endNum, int animationTime){
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view,"alpha",startNum,centerNum,endNum);
        alpha.setDuration(animationTime);
        if(!isReturn){
            alpha.start();
        }else{
            return alpha;
        }
        return alpha;
    }

    //旋转-属性动画
    /**
     *  @param view 要实现动画的视图
     * @param startNum 开始角度值
     * @param animationTime 动画持续时间
     */
    public static ObjectAnimator rotationAnimationFunction(View view, int startNum, int animationTime){
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view,"rotation",startNum);
        rotate.setDuration(animationTime);
        if(!isReturn){
            rotate.start();
        }else{
            return rotate;
        }
        return rotate;
    }

    /**
     *  @param view 要实现动画的视图
     * @param startNum 开始角度值
     * @param endNum 结束角度值
     * @param animationTime 动画持续时间
     */
    public static ObjectAnimator rotationAnimationFunction(View view, int startNum, int endNum, int animationTime){
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view,"rotation",startNum,endNum);
        rotate.setDuration(animationTime);
        if(!isReturn){
            rotate.start();
        }else{
            return rotate;
        }
        return rotate;
    }

    /**
     *  @param view 要实现动画的视图
     * @param startNum 开始角度值
     * @param centerNum 中间角度值
     * @param endNum 结束角度值
     * @param animationTime 动画持续时间
     */
    public static ObjectAnimator rotationAnimationFunction(View view, int startNum, int centerNum, int endNum, int animationTime){
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view,"rotation",startNum,centerNum,endNum);
        rotate.setDuration(animationTime);
        if(!isReturn){
            rotate.start();
        }else{
            return rotate;
        }
        return rotate;
    }

    //平移-属性动画
    /**
     *  @param view 要实现动画的视图
     * @param axle 动画作用的轴方向
     * @param viewTranslationX 视图的X轴位置
     * @param startNum 开始的值
     * @param animationTime 动画持续时间
     */
    public static ObjectAnimator translationAnimationFunction(View view, String axle, float viewTranslationX, int startNum, int animationTime){
        ObjectAnimator translate = ObjectAnimator.ofFloat(view,"translation"+axle,viewTranslationX,startNum);
        translate.setDuration(animationTime);
        if(!isReturn){
            translate.start();
        }else{
            return translate;
        }
        return translate;
    }

    /**
     *  @param view 要实现动画的视图
     * @param axle 动画作用的轴方向
     * @param viewTranslationX 视图的X轴位置
     * @param startNum 开始值
     * @param endNum 结束值
     * @param animationTime 动画持续时间
     */
    public static ObjectAnimator translationAnimationFunction(View view, String axle, float viewTranslationX, int startNum, int endNum, int animationTime){
        ObjectAnimator translate = ObjectAnimator.ofFloat(view,"translation"+axle,viewTranslationX,startNum,endNum);
        translate.setDuration(animationTime);
        if(!isReturn){
            translate.start();
        }else{
            return translate;
        }
        return translate;
    }
}
