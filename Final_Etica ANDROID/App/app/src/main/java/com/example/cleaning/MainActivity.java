package com.example.cleaning;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.StrictMode;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView btnHappy, btnNormal, btnSad;
    private TextToSpeech mTTS;
    final Locale spanish = new Locale("es", "ES");
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(spanish);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        //mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        btnHappy = findViewById(R.id.btnHappy);
        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animacion(btnHappy);
                Ejecutar("Bueno");
                AlertaBuena();
                timer.cancel();



            }
        });
        btnNormal = findViewById(R.id.btnNormal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animacion(btnNormal);
                Ejecutar("Regular");
                AlertaRegular();
                timer.cancel();

            }
        });
        btnSad = findViewById(R.id.btnSad);
        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animacion(btnSad);
                Ejecutar("Malo");
                AlertaMala();
                timer.cancel();

            }
        });


        init();
    }

    public void Animacion(ImageView btn) {
        Animation b = AnimationUtils.loadAnimation(this, R.anim.botones);
        b.reset();
        btn.clearAnimation();
        btn.startAnimation(b);

    }

    public void AlertaBuena(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this).setMessage("¡ GRACIAS POR TU VOTO, HAZ SIDO DE MUCHA AYUDA !");

        final AlertDialog alert = dialog.create();
        alert.show();

        // Hide after some seconds
        final Handler handler  = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alert.isShowing()) {
                    alert.dismiss();
                }
            }
        };

        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 4000);
        speak("¡ GRACIAS POR TU VOTO, HAZ SIDO DE MUCHA AYUDA !");

    }

    public void AlertaRegular(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this).setMessage("¡ GRACIAS POR TU AYUDA, VAMOS A MEJORAR EL TRABAJO !");

        final AlertDialog alert = dialog.create();
        alert.show();

        // Hide after some seconds
        final Handler handler  = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alert.isShowing()) {
                    alert.dismiss();
                }
            }
        };

        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 4000);
        speak("¡ GRACIAS POR TU AYUDA, VAMOS A MEJORAR EL TRABAJO !");

    }

    public void AlertaMala(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this).setMessage("¡ HAZ SIDO ESCUCHADO, TOMAREMOS LAS MEDIDAS NECESARIAS  !");

        final AlertDialog alert = dialog.create();
        alert.show();

        // Hide after some seconds
        final Handler handler  = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alert.isShowing()) {
                    alert.dismiss();
                }
            }
        };

        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });

        handler.postDelayed(runnable, 4000);
        speak("¡ HAZ SIDO ESCUCHADO, TOMAREMOS LAS MEDIDAS NECESARIAS !");

    }

    public Connection conexionBD(){
        Connection conexion =null;
        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.31;databaseName=Cleaning;user=sa;password=1202");

            //Toast.makeText(getApplicationContext(),"Conexion Segura",Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            Log.e("ERRO", e.getMessage());

        }
        return conexion;
    }

    public void Ejecutar(String tipo){

        try{

            PreparedStatement pst = conexionBD().prepareStatement("insert into votos values ('"+tipo+"',1,sysdatetime())");
            pst.executeUpdate();

            Toast.makeText(getApplicationContext(),"Voto Registrado",Toast.LENGTH_SHORT).show();

        }catch (SQLException e){

            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }


    }

    private void speak(String text) {
        //String text = "GRACIAS POR TU VOTO, HAZ SIDO DE MUCHA AYUDA";
//        float pitch = (float) mSeekBarPitch.getProgress() / 50;
//        if (pitch < 0.1) pitch = 0.1f;
//        float speed = (float) mSeekBarSpeed.getProgress() / 50;
//        if (speed < 0.1) speed = 0.1f;
//
//        mTTS.setPitch(pitch);
//        mTTS.setSpeechRate(speed);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void init(){
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                Log.i("tag", "A Kiss every 15 seconds");
                speak("¿Cómo encontró la limpieza de este servicio?, escoja una opcion:");
            }
        },0,15000);
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
