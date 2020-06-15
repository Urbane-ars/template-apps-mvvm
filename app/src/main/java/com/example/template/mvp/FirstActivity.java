package com.example.template.mvp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.template.App;
import com.example.template.R;


import javax.inject.Inject;


public class FirstActivity extends AppCompatActivity implements ViewContract {

    @Inject
    Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((App) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }

    void init(){
        presenter.attachView(this);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addData();
            }
        });
    }

    public void updateList(String text){
        TextView textView = findViewById(R.id.dataList);
        textView.setText(text);
    }

    public String getData(){
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();
        editText.setText("");
        return text;
    }


    public void showError() {
        EditText editText = findViewById(R.id.editText);
        editText.setError(this.getString(R.string.no_data));
    }

}
