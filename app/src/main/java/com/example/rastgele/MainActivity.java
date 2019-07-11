package com.example.rastgele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random rdn = new Random();
    private ImageView imageViewDice1;
    private ImageView imageViewDice2;
    private ImageButton imageButtonRol;
    private ImageButton linkButton;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewDice1 = findViewById(R.id.image_view1_dice);
        imageViewDice2 = findViewById(R.id.image_view2_dice);
        imageButtonRol = findViewById(R.id.imageButton_rol);
        linkButton = findViewById(R.id.github);

        Toast.makeText(getApplicationContext(), "Zarları atmak için butona tıklayınız !", Toast.LENGTH_LONG).show();

        imageButtonRol.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });

        linkButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Uri link = Uri.parse("https://www.github.com/mutlueren/");
                Intent intent = new Intent(Intent.ACTION_VIEW,link);
                startActivity(intent);
            }
        });
    }

    private void rollDice(){
        //random generated number for dice
        int randomNumber1 = rdn.nextInt(6)+1;
        int randomNumber2 = rdn.nextInt(6)+1;

        switch (randomNumber1){
            case 1:
                imageViewDice1.setImageResource(R.drawable.dice1);
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.roll_sound);
                mediaPlayer.start();
                break;
            case 2:
                imageViewDice1.setImageResource(R.drawable.dice2);
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.roll_sound);
                mediaPlayer.start();
                break;
            case 3:
                imageViewDice1.setImageResource(R.drawable.dice3);
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.roll_sound);
                mediaPlayer.start();
                break;
            case 4:
                imageViewDice1.setImageResource(R.drawable.dice4);
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.roll_sound);
                mediaPlayer.start();
            case 5:
                imageViewDice1.setImageResource(R.drawable.dice5);
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.roll_sound);
                mediaPlayer.start();
                break;
            case 6:
                imageViewDice1.setImageResource(R.drawable.dice6);
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.roll_sound);
                mediaPlayer.start();
                break;
            default:
                break;
        }
        switch (randomNumber2){
            case 1:
                imageViewDice2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDice2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDice2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDice2.setImageResource(R.drawable.dice4);
            case 5:
                imageViewDice2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDice2.setImageResource(R.drawable.dice6);
                break;
            default:
                break;
        }

        if(randomNumber1 == 6 && randomNumber2 == 6){
            Toast.makeText(getApplicationContext(), "DÜŞEŞ!", Toast.LENGTH_LONG).show();
        }
    }

}
