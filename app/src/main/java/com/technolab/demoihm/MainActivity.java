package com.technolab.demoihm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String images;
    private static SecureRandom random = new SecureRandom();

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    Button bs;
    TextView resultat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        bs=findViewById(R.id.bson);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnwswer();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnwswer();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnwswer();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnwswer();
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mp3 = Uri.parse("android.resource://"
                        + getPackageName() + "/raw/son1");
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(MainActivity.this, mp3);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch (Exception e){

                }

            }
        });

        this.getNextQuestion();

    }
    private void checkAnwswer(){
        getNextQuestion();
    }
    private void generateImage(){
        char im1 = images.charAt(0);
        char im2 = images.charAt(1);
        char im3 = images.charAt(2);
        char im4 = images.charAt(3);

        b1.setImageResource(getImageRessourceById(im1));
        b2.setImageResource(getImageRessourceById(im2));
        b3.setImageResource(getImageRessourceById(im3));
        b4.setImageResource(getImageRessourceById(im4));
    }
    private int getImageRessourceById(char i){
        switch (i){
            case '1':
                return R.drawable.img1;
            case '2':
                return R.drawable.img2;
            case '3':
                return R.drawable.img3;
            case '4':
                return R.drawable.img4;
            case '5':
                return R.drawable.img5;
            case '6':
                return R.drawable.img6;
            case '7':
                return R.drawable.img7;
            default:
                return R.drawable.img1;
        }
    }
    private void getNextQuestion(){
        images=generateRandomString(4);
        this.generateImage();
    }
    public static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();
        String numbers="1234567";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(numbers.length());
            char rndChar = numbers.charAt(rndCharAt);
            sb.append(rndChar);
            numbers=numbers.replace(String.valueOf(rndChar),"");
        }

        return sb.toString();

    }
}
