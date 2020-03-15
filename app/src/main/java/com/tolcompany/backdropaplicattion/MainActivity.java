package com.tolcompany.backdropaplicattion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior bottomSheetBehavior;
    CoordinatorLayout layout;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.txtPrueba);

        //bottom layout
        layout = findViewById(R.id.bottomLayout);
        //le asignamos el comportamiento que tiene ese layout
        bottomSheetBehavior = BottomSheetBehavior.from(layout);
        //boton
        btn = findViewById(R.id.btnPrueba);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar(bottomSheetBehavior.getState())){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    textView.setText("CERRADO");
                }else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    textView.setText("ABIERTO");
                }
            }
        });
    }

    private boolean validar(int state) {
        boolean valor=false;

        if(state==BottomSheetBehavior.STATE_EXPANDED){
            valor=true;
        }else{
            valor=false;
        }
       return valor;
    }
}
