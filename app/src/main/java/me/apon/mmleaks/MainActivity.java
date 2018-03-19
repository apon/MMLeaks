package me.apon.mmleaks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.apon.mmleaks.longtask.LTActivityOne;
import me.apon.mmleaks.longtask.LTActivityFour;
import me.apon.mmleaks.longtask.LTActivityThree;
import me.apon.mmleaks.longtask.LTActivityTwo;
import me.apon.mmleaks.staticvariables.SVActivityFour;
import me.apon.mmleaks.staticvariables.SVActivityOne;
import me.apon.mmleaks.staticvariables.SVActivityThree;
import me.apon.mmleaks.staticvariables.SVActivityTwo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.sv_one:
                intent = new Intent(getApplicationContext(), SVActivityOne.class);
                startActivity(intent);
                break;
            case R.id.sv_two:
                intent = new Intent(getApplicationContext(), SVActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.sv_three:
                intent = new Intent(getApplicationContext(), SVActivityThree.class);
                startActivity(intent);
                break;
            case R.id.sv_four:
                intent = new Intent(getApplicationContext(), SVActivityFour.class);
                startActivity(intent);
                break;
            case R.id.lt_one:
                intent = new Intent(getApplicationContext(), LTActivityOne.class);
                startActivity(intent);
                break;
            case R.id.lt_two:
                intent = new Intent(getApplicationContext(), LTActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.lt_three:
                intent = new Intent(getApplicationContext(), LTActivityThree.class);
                startActivity(intent);
                break;
            case R.id.lt_four:
                intent = new Intent(getApplicationContext(), LTActivityFour.class);
                startActivity(intent);
                break;
        }
    }
}
