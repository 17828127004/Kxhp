package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kxhl.R;

import java.util.ArrayList;
import java.util.List;

import bean.ProductBean;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by Administrator on 2017/4/14.
 */
public class HomeStoreAdapter extends BaseAdapter {
    LayoutInflater inflater;
    private Context context;
    private List<ProductBean.GoodsBean> goodsBeen = new ArrayList<>();

    public HomeStoreAdapter(Context context, List<ProductBean.GoodsBean> goodsBeen) {
        this.goodsBeen = goodsBeen;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return goodsBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return goodsBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        //callback.onCallBack(Integer.parseInt(goodsBeen.get(position).getId()));
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_integral, null);
            viewholder = new Viewholder();
            viewholder.imageView = (ImageView) convertView.findViewById(R.id.item_iv_find1);
            viewholder.img_dh = (TextView) convertView.findViewById(R.id.img_dh);
            viewholder.tv_jf = (TextView) convertView.findViewById(R.id.item_tv_find_about);
            viewholder.tv_name = (TextView) convertView.findViewById(R.id.item_tv_find_name1);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        Glide.with(context).load(goodsBeen.get(position).getImg())
                .bitmapTransform(new RoundedCornersTransformation(context, 60, 0, RoundedCornersTransformation.CornerType.TOP))
                .into(viewholder.imageView);
        viewholder.tv_name.setText(goodsBeen.get(position).getName());
        viewholder.tv_jf.setText("积分：" + goodsBeen.get(position).getPrice());
        viewholder.img_dh.setText("库存：" + goodsBeen.get(position).getNum());

        return convertView;
    }

    class Viewholder {
        ImageView imageView;
        TextView tv_name, tv_jf, img_dh;
    }


}
