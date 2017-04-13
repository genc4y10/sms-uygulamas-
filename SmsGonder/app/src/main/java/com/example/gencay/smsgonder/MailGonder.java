package com.example.gencay.smsgonder;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailGonder extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_gonder);


        Button gonder = (Button) findViewById(R.id.button);

        final EditText mail_adres= (EditText) findViewById(R.id.etMailAdres);
        final EditText mail_konu= (EditText) findViewById(R.id.etKonu);
        final EditText mail_icerik= (EditText) findViewById(R.id.etIcerik);



        gonder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                mailGonder(mail_adres.getText().toString(),mail_icerik.getText().toString(),mail_konu.getText().toString());


            }
        });


    }

    private void mailGonder(String adres, String konu, String icerik) {

        Intent mailIntent=new Intent(Intent.ACTION_SEND);
        mailIntent.setType("message/rfc822");
        mailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{adres} );
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,konu);
        mailIntent.putExtra(Intent.EXTRA_TEXT,icerik);


        try {startActivity(mailIntent);

        }catch (ActivityNotFoundException hata){
            Toast.makeText(getApplicationContext(), "hata oluştu!"+"\n"+hata.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}
