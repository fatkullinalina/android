package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{

    private TwoFragment twoFragment;
    private OneFragment oneFragment;
    private ThreeFragment threeFragment;
    private FragmentManager fragmentManager;
    private Button buttonAdd;
    private Button buttonDelete;
    private Button buttonReplace;
    private Switch aSwitch;
    private LinearLayout linearLayout;

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twoFragment=new TwoFragment();
        threeFragment=new ThreeFragment();
        buttonAdd=findViewById(R.id.add_button);
        buttonDelete=findViewById(R.id.delete_button);
        buttonReplace=findViewById(R.id.replace_button);
        linearLayout=findViewById(R.id.container2);
        aSwitch=findViewById(R.id.switch1);

        fragmentManager=getSupportFragmentManager();
        if(savedInstanceState==null) {

            initfragment();
        }

    }
    public void initfragment(){

        oneFragment=new OneFragment();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container2,oneFragment);
        fragmentTransaction.commit();

    }
    public void onClickFragment(View view){
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (view.getId()){
            case(R.id.add_button):
                if(fragmentManager.findFragmentByTag(TwoFragment.TAG)==null) {
                    fragmentTransaction.add(R.id.container, twoFragment, TwoFragment.TAG);
                    TextView textViewmm=findViewById(R.id.textView6);
                    textViewmm.setText(" ");

                }
                break;
            case(R.id.delete_button):
                if(fragmentManager.findFragmentByTag(TwoFragment.TAG)!=null) {
                    fragmentTransaction.remove(twoFragment);

                }
                if(fragmentManager.findFragmentByTag(ThreeFragment.TAG)!=null) {
                    fragmentTransaction.remove(threeFragment);

                }

                break;
            case(R.id.replace_button):
                if(fragmentManager.findFragmentByTag(TwoFragment.TAG)!=null) {
                    fragmentTransaction.replace(R.id.container,threeFragment,ThreeFragment.TAG);
                }
                if(fragmentManager.findFragmentByTag(ThreeFragment.TAG)!=null) {
                    fragmentTransaction.replace(R.id.container,twoFragment,TwoFragment.TAG);
                }
                break;
        }
        if(aSwitch.isChecked()) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
