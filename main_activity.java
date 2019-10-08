package e.asus.tictac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive=true;
    //0 - X
    //1 - 0
    int activeplayer=0;
    int []gameState={2,2,2,2,2,2,2,2,2};
    //2 - NULL
    int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
   public void playertap(View view)
   {
       ImageView img= (ImageView)view;
       int tappedimage =Integer.parseInt(img.getTag().toString());
       if(!gameactive)
       {
           reset(view);
       }
       if(gameState[tappedimage]==2) {
           gameState[tappedimage] = activeplayer;
           img.setTranslationY(-1000f);
           if (activeplayer == 0) {
               img.setImageResource(R.drawable.x);
               activeplayer = 1;
               TextView status = findViewById(R.id.status);
               status.setText("0's turn :Tap to Play");
           } else {
               img.setImageResource(R.drawable.o);
               activeplayer = 0;
               TextView status = findViewById(R.id.status);
               status.setText("X's turn :Tap to Play");
           }
           img.animate().translationYBy(1000f).setDuration(300);
       }
       for(int [] winpositions :winPositions)
       {
           if(gameState[winpositions[0]]==gameState[winpositions[1]] && gameState[winpositions[1]]==gameState[winpositions[2]] && gameState[winpositions[0]]!=2)
           {
               String winstr;
               gameactive=false;
               if (gameState[winpositions[0]]==0)
               {
                   winstr="X has won!!";
               }
               else
               {
                   winstr="0 has won!!";
               }
               TextView status = findViewById(R.id.status);
               status.setText(winstr);

           }
       }
   }
    public void reset(View view)
    {
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
