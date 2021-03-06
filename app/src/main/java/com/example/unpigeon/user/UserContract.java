package com.example.unpigeon.user;

public interface UserContract {
    interface LoginPresenter {
        void performLogin();
    }

    interface LoginView {
        String getUsername();
        String getPassword();
        String getCheckNumber();
        void toast(String content);
        void onLoginDefeat();
        void onLoginSuccess();
    }

    interface RegisterPresenter {
        void performRegister();
    }

    interface RegisterView {
        String getUsername();
        String getPassword();
        String getCheckNumber();
        void toast(String content);
        void onRegisterSuccess();
        void onRegisterDefeat();
    }
}
