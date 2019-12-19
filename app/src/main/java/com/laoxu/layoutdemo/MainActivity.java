package com.laoxu.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.laoxu.layoutdemo.entity.FlowEntity;
import com.laoxu.layoutdemo.entity.ProductEntity;
import com.laoxu.layoutdemo.widgets.FlowLayout;

import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button searchBtn;
    private FlowLayout flowLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    /**
     * 请求流式布局的数据
     */
    private void initData() {


        String url = "http://blog.zhaoliang5156.cn/baweiapi/"+ URLEncoder.encode("手机");
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("tag====", response);

                FlowEntity flowEntity = new Gson().fromJson(response,FlowEntity.class);

                List<String> tags = flowEntity.getTags();

                flowLayout.add(tags);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("tag====error", error.getMessage());

            }
        });

        requestQueue.add(stringRequest);



    }

    private void initView() {

     editText = findViewById(R.id.et_keyword);
        searchBtn = findViewById(R.id.btn_search);
        flowLayout = findViewById(R.id.flowlayout);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(editText.getText().toString())+"&count=1&page=10";
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        ProductEntity product;





                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(stringRequest);
            }
        });



    }
}
