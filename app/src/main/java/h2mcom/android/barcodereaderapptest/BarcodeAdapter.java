package h2mcom.android.barcodereaderapptest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BarcodeAdapter extends ArrayAdapter<BarcodShow> {
    public BarcodeAdapter(@NonNull Context context, @NonNull ArrayList<BarcodShow> lists) {
        super( context, 0, lists );
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final BarcodShow currentBarcode = getItem(position);

        final TextView barcodetext = (TextView) listItemView.findViewById(R.id.Barcode_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        barcodetext.setText(currentBarcode.getBarcode());




        return listItemView;
    }
}
