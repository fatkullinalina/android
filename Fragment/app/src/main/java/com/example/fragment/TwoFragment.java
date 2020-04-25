package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TwoFragment extends Fragment  {

    public static final String TAG="TwoFragmentTAG";
    private String s="Здесь появится текст";
    @Override
    public void onStart() {
        super.onStart();
        Button button=getActivity().findViewById(R.id.show_button);
        TextView textView=getActivity().findViewById(R.id.textView3);
        textView.setText(s);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                EditText editText=getActivity().findViewById(R.id.edit);
                TextView textView=getActivity().findViewById(R.id.textView3);
                s=editText.getText().toString();
                textView.setText(s);

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        return inflater.inflate(R.layout.two_fragment,container,false);
    }

}
