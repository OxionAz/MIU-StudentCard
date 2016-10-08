package com.oxionaz.internetapp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import com.oxionaz.internetapp.R;
import com.oxionaz.internetapp.StudentCardApp;
import com.oxionaz.internetapp.view.MainActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.login_activity)
public class LoginActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    EditText student_number;

    @AfterViews
    void ready(){
        setSupportActionBar(toolbar);
        setTitle("Карточка студента");
    }

    @Click
    void login_button(){
        if (!student_number.getText().toString().isEmpty() && student_number.getText().toString().length() == 14){
            setStudentNumber(student_number.getText().toString());
            startActivity();
        } else {
            student_number.setError("Вы не ввели номер");
        }
    }

    @Click
    void login_sasha_button(){
        setStudentNumber("20131319021681");
        startActivity();
    }

    @Click
    void login_pasha_button(){
        setStudentNumber("20131319021684");
        startActivity();
    }

    @Click
    void login_vova_button(){
        setStudentNumber("20131319021683");
        startActivity();
    }

    private void setStudentNumber(String number){
        StudentCardApp.setStudentNumber(this, number);
    }

    private void startActivity(){
        startActivity(new Intent(this, MainActivity_.class));
        finish();
    }
}