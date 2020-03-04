package com.shovo.stateprogessbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.kofigyan.stateprogressbar.components.StateItem;
import com.kofigyan.stateprogressbar.listeners.OnStateItemClickListener;

public class MainActivity extends AppCompatActivity {



    private Button nextButton;
    private StateProgressBar stateProgressBar;
    private FrameLayout frameLayout;
    private SignUp_Fragment signUp_fragment;
    private Confirm_Fragment confirm_fragment;




//    String [] ststeTitle ={"Signup","Photo","validation","Confirm"};
    String [] ststeTitle ={"Signup","Confirm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton=findViewById(R.id.nextButtnId);
        frameLayout=findViewById(R.id.framlayoutId);
        stateProgressBar =findViewById(R.id.stateProgressBarId);



        signUp_fragment=new SignUp_Fragment();
        confirm_fragment =new Confirm_Fragment();

        setfFragment(signUp_fragment);


        stateProgressBar.setStateDescriptionData(ststeTitle);

        stateProgressBar.setCurrentStateDescriptionColor(Color.parseColor("#808080"));



//        stateProgressBar.setOnStateItemClickListener(new OnStateItemClickListener() {
//            @Override
//            public void onStateItemClick(StateProgressBar stateProgressBar, StateItem stateItem, int stateNumber, boolean isCurrentState) {
//                Toast.makeText(MainActivity.this, "Selected"+ stateNumber, Toast.LENGTH_SHORT).show();
//
//
//         nextState();
//
//
//            }
//        });


    }





    public void nextState(){

        switch (stateProgressBar.getCurrentStateNumber()){
            case 1:
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                setfFragment(confirm_fragment);
                break;

        }
    }
    public void setfFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framlayoutId,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.appbar_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case  R.id.shareId:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
                default: return false;
        }


        
    }
}
