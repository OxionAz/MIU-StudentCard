package com.oxionaz.internetapp.view;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    public final ImageView userPhoto;
    public final TextView userName;
    public final TextView userGPA;
    public final EditText userNumber;

    public ViewHolder(ImageView userPhoto, TextView userName, TextView userGPA, EditText userNumber){
        this.userPhoto = userPhoto;
        this.userName = userName;
        this.userGPA = userGPA;
        this.userNumber = userNumber;
    }
}
