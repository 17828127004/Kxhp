package com.kxhl.activity.myActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.kxhl.R;
import com.kxhl.activity.LoginActivity;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import util.Config;
import util.KxhlRestClient;
import util.SaveData;
import util.UrlLIst;
import view.LoadingDialog;
import view.MyDialog;

import static com.kxhl.R.drawable.happy_mine_back;

public class CommodityDetialActivity extends Activity implements View.OnClickListener {
    private String comdId;
    private Button button;
    private TextView tv_title, tv_dh;
    private WebView wv_store;
    private ProgressBar pb;
    private String webUrl;
    // private NiftyDialogBuilder dialogBuilder;
    private String uid;
    private ImageView img_back;
    private LoadingDialog loadingDialog;
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_detial);
        //dialogBuilder = NiftyDialogBuilder.getInstance(this);
        myDialog = MyDialog.getInstance(this);
        Config.setTranslucent(this);
        Bundle bundle = this.getIntent().getExtras();
        uid = (String) SaveData.get(CommodityDetialActivity.this, Config.USERID, "");
        comdId = bundle.getString("comdId");
        webUrl = bundle.getString("webUrl");
        wv_store = (WebView) findViewById(R.id.wv_store);
        pb = (ProgressBar) findViewById(R.id.pb_store);
        tv_title = (TextView) findViewById(R.id.titlepg_between_tv);
        tv_dh = (TextView) findViewById(R.id.titlepg_right_tv);
        tv_title.setText("商品详情");
//        tv_dh.setText("兑换");
        tv_dh.setGravity(Gravity.CENTER);
        tv_dh.setOnClickListener(this);
        button = (Button) findViewById(R.id.comd_dh);
        button.setOnClickListener(this);
        img_back = (ImageView) findViewById(R.id.titlepg_left_iv);
        img_back.setImageResource(R.drawable.happy_mine_back);
        img_back.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        initView();
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    private void initView() {
        loadingDialog = new LoadingDialog(CommodityDetialActivity.this);
        WebSettings webSettings = wv_store.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);// 设置支持缩放
        webSettings.setSupportZoom(false);// 不支持缩放
        webSettings.setUseWideViewPort(false);// 将图片调整到适合webview大小
        webSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        wv_store.loadUrl(webUrl);
        wv_store.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    pb.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == pb.getVisibility()) {
                        pb.setVisibility(View.VISIBLE);
                    }
                    pb.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        wv_store.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comd_dh:
                if (!uid.equals("")) {
                    buyProduct();
//                    dialogBuilder.withTitle("hahah")
//                            .withTitleColor("#FFFFFF")
//                            .withDividerColor("#11000000")
//                            .withMessage("点击确定进行兑换.")
//                            .withMessageColor("#000000")
//                            .withDialogColor("#ffffffff")
//                            .withDuration(700)
//                            .withEffect(Effectstype.Newspager)
//                            .withButton1Text("Cancel")
//                            .withButton2Text("Ok")
//                            .isCancelableOnTouchOutside(true)
//
//                            .setButton2Click(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    //buyProduct();
//                                    dialogBuilder.dismiss();
//                                    wv_store.reload();
//                                }
//                            })
//                            .show();
                } else {
                    Intent intent = new Intent(CommodityDetialActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.titlepg_left_iv:
                if (myDialog != null) {
                    myDialog.dismiss();
                }
                if (loadingDialog != null)
                    loadingDialog.dismiss();
                this.finish();
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myDialog != null) {
            myDialog.dismiss();
        }
        if (loadingDialog != null)
            loadingDialog.dismiss();
        this.finish();
    }

    private void buyProduct() {
        loadingDialog.show();
        RequestParams params = new RequestParams();
        params.put("gid", comdId);
        params.put("uid", uid);
        KxhlRestClient.post(UrlLIst.PRODUCT_BUY, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                if (statusCode == 200) {
                    loadingDialog.dismiss();
                    //Toast.makeText(CommodityDetialActivity.this, "兑换成功", Toast.LENGTH_SHORT).show();
                    myDialog.withTitle("兑换成功").setButtonClick(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            myDialog.dismiss();
                        }
                    }).show();
                } else {
                    Toast.makeText(CommodityDetialActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                }
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                loadingDialog.dismiss();
                Toast.makeText(CommodityDetialActivity.this, "兑换失败", Toast.LENGTH_SHORT).show();
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }

}
