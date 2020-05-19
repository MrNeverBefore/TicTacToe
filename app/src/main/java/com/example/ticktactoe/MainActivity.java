package com.example.ticktactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;

    //0- X
    //1-O
    int activePlayer =0;
    int[] gameState= {2, 2, 2, 2, 2, 2, 2, 2, 2};

    //state meaning
//    0-X
//    1-O
//    2- Null
    int[][] winpos={{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};

    public void tap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameRest(view);
        }
        if(gameState[tappedImage]==2) {

            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            ;
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn");
            }
            img.animate().translationYBy(1000f).setDuration((250));

        }
        for(int[] winpos: winpos)
        {
            String Winner;
            if(gameState[winpos[0]]==gameState[winpos[1]]&&
                    gameState[winpos[1]]==gameState[winpos[2]]&&
                    gameState[winpos[0]]!=2)
            {
                gameActive=false;
                if(gameState[winpos[0]]==0)
                {
                    Winner="X has WON";
                    gameActive=false;
                }
                else
                {
                    Winner="O has WON";
                    gameActive=false;
                }
                TextView status = findViewById(R.id.status);
                status.setText(Winner);
            }
        }

    }
    public void gameRest(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("Tap to Play");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
