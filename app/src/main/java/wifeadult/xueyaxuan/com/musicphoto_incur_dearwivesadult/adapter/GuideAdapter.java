package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 *
 */

/*   引导页的Adapter  */
public class GuideAdapter extends PagerAdapter {

    List<View> imagesViews;

    public GuideAdapter(List<View> imagesViews) {
        this.imagesViews = imagesViews;
    }


    @Override
    public int getCount() {
        return imagesViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        container.removeView(imagesViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imagesViews.get(position));
        return imagesViews.get(position);
    }
}
