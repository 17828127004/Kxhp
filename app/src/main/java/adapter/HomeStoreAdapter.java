package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kxhl.R;

/**
 * Created by Administrator on 2017/4/14.
 */
public class HomeStoreAdapter extends BaseAdapter{
    LayoutInflater inflater;
    public HomeStoreAdapter(Context context){
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.item_integral,null);
        return convertView;
    }
}
