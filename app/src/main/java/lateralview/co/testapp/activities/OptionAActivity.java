package lateralview.co.testapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;

import net.lateralview.simplerestclienthandler.RestClientManager;
import net.lateralview.simplerestclienthandler.base.RequestCallbacks;
import net.lateralview.simplerestclienthandler.base.RequestHandler;

import lateralview.co.testapp.R;
import lateralview.co.testapp.common.Constants;
import lateralview.co.testapp.model.Entry;


/**
 * Created by Joaquin on 3/7/15.
 */
public class OptionAActivity extends AppCompatActivity {

    private TextView mTitleTv;
    private TextView mBodyTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_a);
        initializeControls();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    private void initializeControls(){
        mBodyTv = (TextView) findViewById(R.id.activity_option_a_title_tv);
        mTitleTv = (TextView) findViewById(R.id.activity_option_a_body_tv);
    }

    @Override
    protected void onResume() {
        getEntryInfo();
        super.onResume();
    }

    private void getEntryInfo(){
        RestClientManager.getInstance().makeJsonRequest(
                Request.Method.GET,
                Constants.GET_USER_INFORMATION,
                new RequestHandler<>(new RequestCallbacks<Entry, Object>()
        {
            @Override
            public void onRequestSuccess(Entry response)
            {
                mTitleTv.setText(response.getmTitle());
                mBodyTv.setText(response.getmBody());
            }

            @Override
            public void onRequestError(Object error)
            {
                Object e = error;
                Log.e("Option A","");

            }

        }));
    }

}
