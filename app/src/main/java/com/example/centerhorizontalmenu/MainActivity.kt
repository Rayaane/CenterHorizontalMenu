package com.example.centerhorizontalmenu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    private val data = ArrayList<MenuItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setList()
        main_menu.setItems(data)
        main_menu.setIndicator(R.drawable.ic_collapse)


    }


    fun setList() {

        this.data.add(MenuItemModel("tab1", R.drawable.user_female_placeholder, R.drawable.user_female_placeholder, false))
        this.data.add(MenuItemModel("tab2", R.drawable.ic_home, R.drawable.selected_home, false))
        this.data.add(MenuItemModel("tab3", R.drawable.ic_projects, R.drawable.selected_projects, false))
        this.data.add(MenuItemModel("tab4", R.drawable.ic_focus, R.drawable.selected_focus, false))
        this.data.add(MenuItemModel("tab5", R.drawable.ic_tasks, R.drawable.selected_tasks, false))
        this.data.add(MenuItemModel("tab6", R.drawable.ic_talents, R.drawable.selected_talents, false))
        this.data.add(MenuItemModel("tab7", R.drawable.ic_chat, R.drawable.selected_chat, false))

    }


}
