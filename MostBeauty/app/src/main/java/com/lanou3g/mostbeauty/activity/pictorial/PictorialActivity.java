package com.lanou3g.mostbeauty.activity.pictorial;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION_CODES;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnScrollChangeListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanou3g.mostbeauty.Bean.PictorialActivityBean;
import com.lanou3g.mostbeauty.R;
import com.lanou3g.mostbeauty.activity.API;
import com.lanou3g.mostbeauty.adapter.PictorialActivityGridAdapter;
import com.lanou3g.mostbeauty.adapter.PictorialActivityListAdapter;
import com.lanou3g.mostbeauty.base.BaseActivity;
import com.lanou3g.mostbeauty.gson.NetTool;
import com.lanou3g.mostbeauty.gson.onHttpCallBack;
import com.lanou3g.mostbeauty.myview.StationGridview;
import com.lanou3g.mostbeauty.myview.SwipeBackLayout;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.lanou3g.mostbeauty.R.id.cancel_action;
import static com.lanou3g.mostbeauty.R.id.tv_city;

/**
 * Created by dllo on 16/8/31.
 */
public class PictorialActivity extends BaseActivity implements OnClickListener {
    private WebView webView;
    private TextView tvTitle, tvSmallTitle, tvName, tvAuthor, tvSmall, tvSmallOne, tvContent, tvSay, tvAll, tvTopName, tvCity, tvSayHow, tvLike;
    private ScrollView scrollView;
    private RelativeLayout relativeLayout, relativeLayoutSmall;

    private ImageView imgTitle, imgName, imgNameOne, imgTopName, imgBack, imgSay, imgShare;
    private LinearLayout linearLayout;
    private StationGridview gridView;
    private ListView listView;
    private PictorialActivityGridAdapter gridAdapter;
    private Button btnAll;
    private PictorialActivityListAdapter listAdapter;
    private String str;
    private EditText etSay;
    private String str1;

    private int id;
    private String img;
    private String tvTitleStr;
    private String tvSmallStr;


    private static PictorialActivityBean response;
    private SwipeBackLayout swipeBackLayoutTwo;


    @Override
    protected int getLayout() {
        return R.layout.activity_pictoral;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.web_view);
        tvSmallTitle = (TextView) findViewById(R.id.tv_small_title);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imgTitle = (ImageView) findViewById(R.id.img_title);
        tvAuthor = (TextView) findViewById(R.id.tv_antuor);
        tvName = (TextView) findViewById(R.id.tv_name);
        imgName = (ImageView) findViewById(R.id.img_anduor);
        tvSmall = (TextView) findViewById(R.id.tv_tiltle_small);
        tvSmallOne = (TextView) findViewById(R.id.tv_small);
        tvContent = (TextView) findViewById(R.id.tv_content);
        imgNameOne = (ImageView) findViewById(R.id.img_name_one);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        gridView = (StationGridview) findViewById(R.id.grid_view);
        listView = (ListView) findViewById(R.id.list_view);
        btnAll = (Button) findViewById(R.id.btn_all);
        tvSay = (TextView) findViewById(R.id.tv_say);
        tvAll = (TextView) findViewById(R.id.tv_all);
        tvCity = (TextView) findViewById(tv_city);
        tvTopName = (TextView) findViewById(R.id.tv_top_name);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        relativeLayoutSmall = (RelativeLayout) findViewById(R.id.relative_layout_small);
        imgTopName = (ImageView) findViewById(R.id.img_top_name);
        scrollView = (ScrollView) findViewById(R.id.scroll_View);
        tvSayHow = (TextView) findViewById(R.id.tv_say_how);
        tvLike = (TextView) findViewById(R.id.tv_like);
        imgSay = (ImageView) findViewById(R.id.img_say);
        imgBack = (ImageView) findViewById(R.id.img_back);
        etSay = (EditText) findViewById(R.id.et_say);
        imgShare = (ImageView) findViewById(R.id.image_share);


        tvAll.setOnClickListener(this);
        btnAll.setOnClickListener(this);
        imgBack.setOnClickListener(this);
        imgSay.setOnClickListener(this);
        etSay.setOnClickListener(this);
        relativeLayoutSmall.setOnClickListener(this);
        imgShare.setOnClickListener(this);
        swipeBackLayoutTwo = (SwipeBackLayout) findViewById(R.id.swipe_layout_two);

        ScrollFinishActivity();


    }


    @TargetApi(VERSION_CODES.M)
    @Override
    protected void initData() {
        gridAdapter = new PictorialActivityGridAdapter(this);
        listAdapter = new PictorialActivityListAdapter(this);
        Intent intent = getIntent();
        str = intent.getStringExtra("id");
        int id = Integer.parseInt(str);
        String img = intent.getStringExtra("img");
        Glide.with(this).load(img).into(imgTitle);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(API.PICTORIAL_ACTIVITY_WEBVIEW + id + API.PICTORIAL_ACTIVITY_WEBVIEW_TWO);
        relativeLayoutSmall.getBackground().setAlpha(220);
        scrollChangeTitle();

        getNetRequest(id);


    }
    // TODO: 16/9/7 实现侧滑退出Activity 的监听

    private void ScrollFinishActivity() {
        swipeBackLayoutTwo.setCallBack(new SwipeBackLayout.CallBack() {
            @Override
            public void onFinish() {
                finish();
            }
        });
    }

    // TODO: 16/9/7 监听ScrollView的滚动 实现标题栏隐藏与显示
    @TargetApi(VERSION_CODES.M)
    private void scrollChangeTitle() {
        scrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > oldScrollY && scrollY - oldScrollY > 40) {
                    if (scrollY > 0 && oldScrollY == 0) {
                        Log.d("PictorialActivity", "88888888");
                        relativeLayout.setVisibility(View.VISIBLE);
                        Animation animation = AnimationUtils.loadAnimation(PictorialActivity.this, R.anim.enter_title);
                        relativeLayout.startAnimation(animation);
                    } else {
                        Log.d("PictorialActivity", "999999999");
                        relativeLayout.setVisibility(View.GONE);


                    }
                } else if (oldScrollY > scrollY && oldScrollY - scrollY > 40) {
                    Log.d("PictorialActivity", "101010101010");
                    relativeLayout.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(PictorialActivity.this, R.anim.exit_title);
                    relativeLayout.startAnimation(animation);
                }

            }
        });
    }

    // TODO: 16/9/2 获取网络数据
    private void getNetRequest(int id) {
        NetTool.getInstance().startRequest(API.PICTORIAL_ACTIVITY_ONE + id + API.PICTORIAL_ACTIVITY_TWO,
                PictorialActivityBean.class, new onHttpCallBack<PictorialActivityBean>() {
                    @Override
                    public void onSuccess(PictorialActivityBean response) {

                        PictorialActivity.response = response;
                        // TODO: 16/9/3 最上面的解析数据

                        tvTitle.setText(response.getData().getTitle());
                        tvSmallTitle.setText(response.getData().getSub_title());
                        tvName.setText(response.getData().getAuthor().getUsername());
                        tvAuthor.setText(response.getData().getAuthor().getSign());
                        int id1 = response.getData().getAuthor().getId();
                        str1 = Integer.toString(id1);
                        Log.d("PictorialActivity", "12345671234567"+id1);
                        Glide.with(PictorialActivity.this).load(response.getData().getAuthor().getAvatar_url()).bitmapTransform(new CropCircleTransformation(PictorialActivity.this)).into(imgName);

                        if (response.getData().getDesigners().size() != 0) {
                            linearLayout.setVisibility(View.VISIBLE);
                            relativeLayoutSmall.setVisibility(View.VISIBLE);

                            tvSmall.setText(response.getData().getDesigners().get(0).getName());
                            tvSmallOne.setText(response.getData().getDesigners().get(0).getLabel());
                            Glide.with(PictorialActivity.this).load(response.getData().getDesigners().get(0)
                                    .getAvatar_url()).bitmapTransform(new CropCircleTransformation(PictorialActivity.this)).into(imgNameOne);
                            tvContent.setText(response.getData().getDesigners().get(0).getDescription());

                            tvCity.setText(response.getData().getDesigners().get(0).getCity());
                            tvTopName.setText(response.getData().getDesigners().get(0).getName());
                            Glide.with(PictorialActivity.this).load(response.getData().getDesigners().get(0)
                                    .getAvatar_url()).bitmapTransform(new CropCircleTransformation(PictorialActivity.this)).into(imgTopName);

                        } else {
                            linearLayout.setVisibility(View.GONE);
                            relativeLayoutSmall.setVisibility(View.GONE);

                        }
                        if (response.getData().getRefer_products() == null) {
                            gridView.setVisibility(View.GONE);
                        } else {
                            if (response.getData().getRefer_products().size() < 10) {
                                btnAll.setVisibility(View.GONE);
                            } else {
                                btnAll.setVisibility(View.VISIBLE);
                            }
                            gridView.setVisibility(View.VISIBLE);
                            gridAdapter.setBean(response);
                            gridView.setAdapter(gridAdapter);
                        }

                        if (response.getData().getComments().size() != 0) {
                            int id = response.getData().getFavor_user_num();
                            tvLike.setText(response.getData().getLike_user_num() + "");
                            tvSay.setVisibility(View.VISIBLE);
                            tvAll.setVisibility(View.VISIBLE);
                            tvSay.setText("评论(" + id + ")");
                            tvSayHow.setText(id + "");
                            listAdapter.setBean(response);
                            listView.setAdapter(listAdapter);
                            setListViewHeightBasedOnChildren(listView);

                        }else {
                            tvAll.setVisibility(View.GONE);
                            tvSay.setVisibility(View.GONE);
                        }

                        int id = response.getData().getFavor_user_num();
                        tvLike.setText(response.getData().getLike_user_num()+"");
                        tvSay.setText("评论(" + id + ")");
                        tvSayHow.setText(id+"");
                        listAdapter.setBean(response);
                        listView.setAdapter(listAdapter);
                        setListViewHeightBasedOnChildren(listView);




                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("PictorialActivity", "aaaaaaaaaaaammmmm");
                    }
                });
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all:
                Intent intent = new Intent(this, PictorialCommentActivity.class);
                intent.putExtra("id", str);
                startActivity(intent);
                break;
            case R.id.btn_all:
                break;
            case R.id.img_back:
                finish();
                break;
            case R.id.img_say:
                Intent intentImg = new Intent(this, PictorialCommentActivity.class);
                intentImg.putExtra("id", str);
                startActivity(intentImg);
                break;
            case R.id.et_say:
                Intent intentEt = new Intent(this, PictorialCommentActivity.class);
                intentEt.putExtra("id", str);
                startActivity(intentEt);
                break;
            case R.id.relative_layout_small:

                Intent intentAuthor = new Intent(this, PictorialAuthorActivity.class);
                intentAuthor.putExtra("idAuthor", str1);

                intentAuthor.putExtra("id", str);

                intentAuthor.putExtra("img", img);
                intentAuthor.putExtra("tvTitle", tvTitleStr);
                intentAuthor.putExtra("tvSmall", tvSmallStr);



                startActivity(intentAuthor);
                break;
            case R.id.image_share:
                showShare();
                break;

        }

    }
    private void showShare() {
        ShareSDK.initSDK(PictorialActivity.this);

        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("最美有物");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(API.PICTORIAL_FRAGMENT);
// text是分享文本，所有平台都需要这个字段
        oks.setText("最美应用,想要专业设计师为你打造绝无仅有的造型么?来最美有物,让你体验极致视觉冲击");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(API.PICTORIAL_FRAGMENT);
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("最美应用,让你体验极致视觉体验");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(API.PICTORIAL_FRAGMENT);

// 启动分享GUI
        oks.show(PictorialActivity.this);



    }
}
