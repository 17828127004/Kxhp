package view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kxhl.R;

/**
 * Created by Administrator on 2017/5/12.
 */

public class MyDialog extends Dialog {
    private LinearLayout mLinearLayoutTopView;
    private TextView tv_msg;
    private Button button;
    private static MyDialog instance;
    private View mydialogView;
    private final static int WITH_DIALOG=700;


    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    public MyDialog(Context context) {
        super(context);
        init(context);
    }
    public static MyDialog getInstance(Context context) {
        instance = new MyDialog(context, R.style.my_dialog);
        return instance;
    }
    private void  init(Context context){
        mydialogView=View.inflate(context,R.layout.my_dialog_layout,null);
        tv_msg= (TextView) mydialogView.findViewById(R.id.textView);
        button= (Button) mydialogView.findViewById(R.id.sure);
        mLinearLayoutTopView= (LinearLayout) findViewById(R.id.lin);
        setContentView(mydialogView);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.width  = WITH_DIALOG;
        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }
    public MyDialog withTitle(CharSequence title) {
        //toggleView(mLinearLayoutTopView,title);
        tv_msg.setText(title);
        return this;
    }
    public MyDialog withButtonText(CharSequence text) {
        button.setVisibility(View.VISIBLE);
        button.setText(text);

        return this;
    }
    public MyDialog setButtonClick(View.OnClickListener click) {
        button.setOnClickListener(click);
        return this;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void show() {
        super.show();
    }
}
