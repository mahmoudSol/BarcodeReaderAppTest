package h2mcom.android.barcodereaderapptest;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {


    private Button scanbutton;
    private Button entrebutton;
    private Class<?> mClss;
    private static final int ZXING_CAMERA_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
      scanbutton = (Button)findViewById( R.id.scanbarcode );
      entrebutton = (Button)findViewById( R.id.entrebarcode );


      scanbutton.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              launchActivity( FullScanActivity.class );

          }
      } );
      entrebutton.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              AlertDialog.Builder alertDialog = new AlertDialog.Builder( MainActivity.this );
              alertDialog.setTitle( "Entre Barcode" );
              final EditText input = new EditText(MainActivity.this);
              LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                      LinearLayout.LayoutParams.MATCH_PARENT,
                      LinearLayout.LayoutParams.MATCH_PARENT);
              input.setLayoutParams(lp);
              alertDialog.setView(input);
              alertDialog.setPositiveButton( "Entre", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      String entrebarcode = input.getText().toString();

                      if (entrebarcode != null){
                          Intent intent = new Intent( MainActivity.this,Main2Activity.class );
                          intent.putExtra( "QR code","Manual entred Barcode" +entrebarcode );
                          startActivity( intent );
                      } else Toast.makeText( getApplicationContext(),"Please insert the Barcode",Toast.LENGTH_SHORT ).show();

                  }
              } );
              alertDialog.show();
          }
      } );



    }

    public void launchActivity(Class<?> clss) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            mClss = clss;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        } else {
            Intent intent = new Intent(this, clss);
            startActivity(intent);
        }
    }
}
