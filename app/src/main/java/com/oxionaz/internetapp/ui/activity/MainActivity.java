package com.oxionaz.internetapp.ui.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.oxionaz.internetapp.R;
import com.oxionaz.internetapp.StudentCardApp;
import com.oxionaz.internetapp.model.DataManager;
import com.oxionaz.internetapp.util.CheckInternetConnection;
import com.oxionaz.internetapp.view.LoginActivity_;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.util.List;

@EActivity(R.layout.main_activity)
@OptionsMenu(R.menu.menu_scrolling)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.main_content)
    CoordinatorLayout coordinatorLayout;

    @ViewById
    ImageView photo;

    @ViewById
    TextView user_name, user_ball;

    private String userNumber;

    @AfterViews
    void ready(){
        setSupportActionBar(toolbar);
        setTitle("Инфа о студенте");
        userNumber = StudentCardApp.getStudentNumber(this);
    }

    @Click
    void fab(){
        updateData();
    }

    @OptionsItem
    void action_settings(){
        startActivity(new Intent(this, LoginActivity_.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateData();
    }

    private void updateData(){
        if (CheckInternetConnection.isNetworkConneted(this)) {
           getUserData(userNumber);
        }
        else Snackbar.make(coordinatorLayout, "Отсутствует интернет подключение 20131319021681", Snackbar.LENGTH_SHORT).show();
    }

    @Background
    void getUserData(String number) {
        String[] photo = null;
        try {
            photo = DataManager.getStudentInfo(number);
        } catch (IOException e){
            e.printStackTrace();
        }
        setUserInfo(photo);
        Snackbar.make(coordinatorLayout, "Данные загружены " + photo[1], Snackbar.LENGTH_SHORT).show();
    }

//    class UpdateName extends AsyncTask<String, Void, String>{
//
//        @Override
//        protected String doInBackground(String... params) {
//            String content = null;
//            try {
//                content = DataManager.getStudentInfo(userNumber);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return content;
//        }
//
//        @Override
//        protected void onPostExecute(String content) {
//            setUserInfo(content);
//            Snackbar.make(coordinatorLayout, "Данные загружены " + content, Snackbar.LENGTH_SHORT).show();
//        }
//    }

    @UiThread
    void setUserInfo(String[] data){
        Picasso.with(this).load(data[0]).into(photo);
        user_name.setText(data[1]);
        user_ball.setText("Средний балл: "+data[2]);
    }
}