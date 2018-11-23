package h2mcom.android.barcodereaderapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        FullScanFragment fullScanFragment = new FullScanFragment();


        String getbarcode = getIntent().getStringExtra( "QR code" );

        ArrayList<BarcodShow> lists =new ArrayList<>(  );

        lists.add( new BarcodShow( getbarcode ) );

        ListView listView =(ListView)findViewById( R.id.list_view );
        final BarcodeAdapter adapter = new BarcodeAdapter( this,lists );
        listView.setAdapter( adapter );
    }
}
