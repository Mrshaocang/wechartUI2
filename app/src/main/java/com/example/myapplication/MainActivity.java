package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout chatLayout;
    private LinearLayout contactsLayout;
    private LinearLayout discoveryLayout;
    private LinearLayout selfLayout;

    private ImageButton chatImageButton;
    private ImageButton contactsImageButton;
    private ImageButton discoveryImageButton;
    private ImageButton selfImageButton;

    private TextView chatText;
    private TextView contactsText;
    private TextView discoveryText;
    private TextView selfText;

    private Fragment chatFragment = new ChatFragment();
    private Fragment contactsFragment = new ContactsFragment();
    private Fragment discoveryFragment = new DiscoveryFragment();
    private Fragment selfFragment = new SelfFragment();

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();
        selectFragment(0);//默认首页是聊天界面
    }

    private void initFragment(){
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content,chatFragment);
        transaction.add(R.id.content,contactsFragment);
        transaction.add(R.id.content,discoveryFragment);
        transaction.add(R.id.content,selfFragment);
        transaction.commit();
    }

    private void initView(){
        chatLayout = findViewById(R.id.ChatLinear);
        contactsLayout = findViewById(R.id.ContactsLinear);
        discoveryLayout = findViewById(R.id.DiscoveryLinear);
        selfLayout = findViewById(R.id.SelfLinear);

        chatImageButton = findViewById(R.id.imageButton2);
        contactsImageButton = findViewById(R.id.imageButton3);
        discoveryImageButton = findViewById(R.id.imageButton4);
        selfImageButton = findViewById(R.id.imageButton5);

        chatText = findViewById(R.id.textView2);
        contactsText = findViewById(R.id.textView3);
        discoveryText= findViewById(R.id.textView4);
        selfText = findViewById(R.id.textView5);
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(chatFragment);
        transaction.hide(contactsFragment);
        transaction.hide(discoveryFragment);
        transaction.hide(selfFragment);
    }

    @SuppressLint("ResourceAsColor")
    private void selectFragment(int i){//i是一个选择器，用于选择显示哪个界面
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);//首先隐藏所有页面

        switch (i){
            case 0:
                transaction.show(chatFragment);
                chatImageButton.setImageResource(R.drawable.chat_pick);
                chatText.setTextColor(Color.GREEN);
                break;
            case 1:
                transaction.show(contactsFragment);
                contactsImageButton.setImageResource(R.drawable.friends_pick);
                contactsText.setTextColor(Color.GREEN);
                break;
            case 2:
                transaction.show(discoveryFragment);
                discoveryImageButton.setImageResource(R.drawable.comm_pick);
                discoveryText.setTextColor(Color.GREEN);
                break;
            case 3:
                transaction.show(selfFragment);
                selfImageButton.setImageResource(R.drawable.setting_pick);
                selfText.setTextColor(Color.GREEN);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    public void onClick(View view) {
        resetBtn();
        switch (view.getId()){
            case R.id.ChatLinear:
                selectFragment(0);
                break;
            case R.id.ContactsLinear:
                selectFragment(1);
                break;
            case R.id.DiscoveryLinear:
                selectFragment(2);
                break;
            case R.id.SelfLinear:
                selectFragment(3);
                break;
            default:
                break;
        }
    }

    @SuppressLint("ResourceAsColor")
    private void resetBtn(){
        chatImageButton.setImageResource(R.drawable.chat);
        contactsImageButton.setImageResource(R.drawable.friends);
        discoveryImageButton.setImageResource(R.drawable.comm);
        selfImageButton.setImageResource(R.drawable.setting);

        chatText.setTextColor(Color.BLACK);
        contactsText.setTextColor(Color.BLACK);
        discoveryText.setTextColor(Color.BLACK);
        selfText.setTextColor(Color.BLACK);
    }

    //仅仅对bottom的四个linearlayout监听
    private void initEvent(){
        chatLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        discoveryLayout.setOnClickListener(this);
        selfLayout.setOnClickListener(this);
    }
}