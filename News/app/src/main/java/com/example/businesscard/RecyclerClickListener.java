package com.example.businesscard;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerClickListener implements RecyclerView.OnItemTouchListener{
    private OnItemClickListener mListener;
    GestureDetector mGestureDetector;



    public interface OnItemClickListener {
        public void onItemClick(View view,int position);
    }

    public RecyclerClickListener(Context context, OnItemClickListener listener){
        mListener=listener;
        mGestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override public boolean onSingleTapUp(MotionEvent e){
                return true;
            }
        });
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv,MotionEvent e) {
        View childView=rv.findChildViewUnder(e.getX(),e.getY());
        if(childView!=null&&mListener!=null&&mGestureDetector.onTouchEvent(e)){
            mListener.onItemClick(childView,rv.getChildLayoutPosition(childView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
