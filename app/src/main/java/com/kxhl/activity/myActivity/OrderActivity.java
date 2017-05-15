package com.kxhl.activity.myActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.kxhl.R;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;

import adapter.OrderAdapter;
import bean.MyOrderBean;
import util.Config;
import util.GsonUtils;
import util.KxhlRestClient;
import util.SaveData;
import util.UrlLIst;

public class OrderActivity extends Activity implements View.OnClickListener {
    private TextView tv_title;
    private String userId;
    private XRefreshView xRefreshView;
    private OrderAdapter orderAdapter;
    private ListView listView;
    private ImageView img_bac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Config.setTranslucent(this);
        init();
    }

    @Override
    protected void onResume() {
        getData();
        super.onResume();
    }

    private void init() {
        tv_title = (TextView) findViewById(R.id.titlepg_between_tv);
        tv_title.setText("我的兑换");
        listView = (ListView) findViewById(R.id.ord_list);
        xRefreshView = (XRefreshView) findViewById(R.id.order_ref);
        img_bac = (ImageView) findViewById(R.id.titlepg_left_iv);
        img_bac.setImageResource(R.drawable.happy_mine_back);
        img_bac.setOnClickListener(this);
    }

    private void getData() {
        userId = (String) SaveData.get(OrderActivity.this, Config.USERID, "");
        RequestParams requestParams = new RequestParams();
        requestParams.put("id", userId);
        KxhlRestClient.post(UrlLIst.MY_ORDER, requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                if (statusCode == 200) {
                    MyOrderBean orderBean = GsonUtils.JsonClazz(response.toString(), MyOrderBean.class);
                    orderAdapter = new OrderAdapter(OrderActivity.this, orderBean);
                    listView.setAdapter(orderAdapter);
                    xRefreshView.setPullRefreshEnable(false);
                    xRefreshView.setPullLoadEnable(false);
                } else {
                    Toast.makeText(OrderActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(OrderActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.titlepg_left_iv:
                this.finish();
                break;
        }
    }
}
