package com.frontend.kanishk.predicto;
import android.app.backup.RestoreObserver;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Kanishk on 12-08-2017.
 */

public class CustomAdaptor extends PagerAdapter{
private int[] images;
    private LayoutInflater inflater;
private Context ctx;
    public CustomAdaptor(Context ctx,int[] img)
    {
        this.ctx = ctx;
        images=img;
    }

    @Override
    public int getCount() {
        return images.length ;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        inflater =(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.sample_image1,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.image_view);
        img.setImageResource(images[position]);
        container.addView(v);
        return v;
    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object)
    {
        container.invalidate();
    }

}
