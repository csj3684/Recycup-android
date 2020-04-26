package com.recycup.recycup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MypageActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView nameTextView;
    TextView pointTextView;
    Button chargePointButton;
    ProgressBar statisticsBar;
    TextView takeOutCupNumber;
    TextView returnCupNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        toolbar = findViewById(R.id.mypageToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        pointTextView = (TextView) findViewById(R.id.pointTextView);
        chargePointButton = (Button) findViewById(R.id.chargePointButton);
        statisticsBar = (ProgressBar) findViewById(R.id.statisticsBar);
        takeOutCupNumber = (TextView) findViewById(R.id.takeOutCupNumber);
        returnCupNumber = (TextView) findViewById(R.id.returnCupNumber);

        statisticsBar.setProgress(50);

        chargePointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChargePointActivity.class);
                startActivityForResult(intent, 2001);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2001 && resultCode ==1){
            //다시 값 가져와서 보여주기
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
