package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kxhl.R;

import bean.MyOrderBean;
import util.RoundedImageView;
import util.TimeUtil;

/**
 * Created by Administrator on 2017/5/10.
 */

public class OrderAdapter extends BaseAdapter {
    public Context context;
    private LayoutInflater layoutInflater;
    private MyOrderBean myOrderBean = new MyOrderBean();

    public OrderAdapter(Context context, MyOrderBean myOrderBean) {
        this.context = context;
        this.myOrderBean = myOrderBean;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return myOrderBean.getOrder().size();
    }

    @Override
    public Object getItem(int position) {
        return myOrderBean.getOrder().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder = null;
        if (convertView == null) {
            viewholder = new OrderAdapter.ViewHolder();
            convertView = layoutInflater.inflate(R.layout.ordr_item_layout, null);
            viewholder.roundedImageView = (RoundedImageView) convertView.findViewById(R.id.order_img);
            viewholder.order_name = (TextView) convertView.findViewById(R.id.order_name);
            viewholder.order_price = (TextView) convertView.findViewById(R.id.order_price);
            viewholder.order_time = (TextView) convertView.findViewById(R.id.order_time);
            convertView.setTag(viewholder);

        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(myOrderBean.getOrder().get(position).getImg()).into(viewholder.roundedImageView);
        viewholder.order_name.setText(myOrderBean.getOrder().get(position).getName());
        viewholder.order_price.setText("积分：" + myOrderBean.getOrder().get(position).getPrice());
        viewholder.order_time.setText("创建时间：" + TimeUtil.getMilliToDate(myOrderBean.getOrder().get(position).getCreate_time()));
        return convertView;
    }

    class ViewHolder {
        RoundedImageView roundedImageView;
        TextView order_name, order_price, order_time;
    }


}
