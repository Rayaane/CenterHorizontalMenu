package com.example.centerhorizontalmenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * Created by Rayaane Abdessmad on 03/09/19.
 */
public class MainMenu extends RelativeLayout implements  MenuItemSelected {




    private RecyclerView rv_list;
    private ImageView indicator;
    private ArrayList<MenuItemModel> data = new ArrayList<>();
    private Context context;



    public MainMenu(Context context) {
        super(context);
        initView(context,null,0,0);
    }

    public MainMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs,0,0);
    }

    public MainMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs,defStyleAttr,0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MainMenu(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context,attrs,defStyleAttr,defStyleRes);
    }

    public void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        this.context=context;
        @SuppressLint({"Recycle", "CustomViewStyleable"}) TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MainMenuStyle, defStyleAttr, 0);


        View view = inflate(getContext(), R.layout.main_menu_view, null);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(view, lp);


        Boolean focusCenter = typedArray.getBoolean(R.styleable.MainMenuStyle_focus,true);
        int indicatorRes = typedArray.getResourceId(R.styleable.MainMenuStyle_indicator , 0);
        rv_list = this.findViewById(R.id.rv_horizontal_picker);
        indicator = this.findViewById(R.id.indicator);
        setMenuList(focusCenter);
        if(indicatorRes!=0)
        indicator.setImageResource(indicatorRes);



    }


    public void setItems(ArrayList<MenuItemModel> data_list) {

        data.addAll(data_list);

    }

    public void setIndicator(int indicatorDrawble) {

        indicator.setImageResource(indicatorDrawble);

    }

    public void setMenuList(Boolean focusCenter) {

        int padding =  ScreenUtils.Companion.getScreenWidth(context)/2 - ScreenUtils.Companion.dpToPx(context, 40);
        rv_list.setPadding(padding, 0, padding, 0);
        MenuLayoutManager sliderLayoutManager = new MenuLayoutManager(context,this ,focusCenter);
        rv_list.setLayoutManager(sliderLayoutManager);
        MenuAdapter sliderAdapter = new MenuAdapter(data,this );
        rv_list.setAdapter(sliderAdapter);

    }






    @Override
    public void menuItemSelected(@Nullable View view) {

        rv_list.smoothScrollToPosition(rv_list.getChildLayoutPosition(view));
        rv_list.getAdapter().notifyDataSetChanged();


    }

    @Override
    public void menuItemSelected(int layoutPosition) {
        for (int i=0;i<data.size();i++) {
            data.get(i).setSelected(false);
        }
        data.get(layoutPosition).setSelected(true);
        rv_list.getAdapter().notifyDataSetChanged();

    }





}
