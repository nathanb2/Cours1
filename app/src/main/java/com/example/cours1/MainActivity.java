package com.example.cours1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.cours1.ResultActivity.EXTRA_RESULT;

//AppCompatActivity est une classe qui permet de gerer l'affichage d'un ecran et nous avons ainsi des evenement de creation/apparition de l'activity tels que onCreate()
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //permet d'associer un layout a une activity
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * findViewById(R.id.id_de_la_vue) permet de recuperer l'instance d'une vue (issue du layout de l'activity associe avec setContentView(R.layout.activity_main))
     */
    private void initView() {
        //findViewById(R.id.id_de_la_vue) permet de recuperer l'instance d'une vue (issue du layout de l'activity associe avec setContentView(R.layout.activity_main))
        TextView counterTv = findViewById(R.id.AM_counter_tv);
        counterTv.setText(String.valueOf(counter));
        Button plusBtn = findViewById(R.id.AM_plus_btn);
        Button minusBtn = findViewById(R.id.AM_minus_btn);

        //setOnClickListener permet d'ecouter l'evenement de click sur une vue
        plusBtn.setOnClickListener(new View.OnClickListener() {//peut aussi s'ecrire avec un lambda view -> {}
            @Override
            public void onClick(View view) {//view est la vue click
                counterTv.setText(String.valueOf(++counter));
            }
        });


        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 0) {
                    counterTv.setText(String.valueOf(--counter));
                }
            }
        });

        findViewById(R.id.AM_open_result_activity_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent permet de definir une intention, en parametre(de ou, a ou), on peut ainsi ouvrire une nouvelle activity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                //Avec putExtra on peut passer des donnees (primitive uniquement) a la 2e activity via l'intent en parametres(key, value)
                intent.putExtra(EXTRA_RESULT, counter);
                startActivity(intent);
            }
        });
    }
}