package com.example.unpigeon.user;

import android.os.Bundle;

import com.example.unpigeon.R;
import com.example.unpigeon.user.login.LoginFragment;
import com.example.unpigeon.user.login.LoginPresenter;
import com.example.unpigeon.user.register.RegisterFragment;
import com.example.unpigeon.user.register.RegisterPresenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class UserActivity extends AppCompatActivity {
    private String TAG = "moanbigking";
    private LoginPresenter mLoginPresenter;
    private RegisterPresenter mRegisterPresenter;
    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setLoginFragment();
        loadPresenter();
    }

    private void setLoginFragment() {
        mLoginFragment = new LoginFragment();
        mRegisterFragment = new RegisterFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack("user-stack");
        transaction.replace(R.id.user_activity_frame_layout, mLoginFragment);
        transaction.commit();
    }

    private void loadPresenter() {
        mLoginPresenter = new LoginPresenter(mLoginFragment);
        mRegisterPresenter = new RegisterPresenter(mRegisterFragment);
        mLoginFragment.setPresenter(mLoginPresenter);
        mRegisterFragment.setPresenter(mRegisterPresenter);
    }

    public void setRegisterFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack("user-stack");
        transaction.replace(R.id.user_activity_frame_layout, mRegisterFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

