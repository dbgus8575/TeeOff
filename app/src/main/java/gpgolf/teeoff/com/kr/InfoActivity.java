package gpgolf.teeoff.com.kr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by T on 2015-12-04.
 */
public class InfoActivity extends AppCompatActivity{

    ArrayAdapter<CharSequence> agespin;
    boolean mInitSpinner;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);

        Spinner spin = (Spinner)findViewById(R.id.age_spinner);
        spin.setPrompt("나이를 선택하세요");

        agespin = ArrayAdapter.createFromResource(this, R.array.ageselect,
                                                    android.R.layout.simple_spinner_item);
        agespin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(agespin);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mInitSpinner == false) {
                    mInitSpinner = true;
                    return;
                }
                Toast.makeText(InfoActivity.this, agespin.getItem(position) + "를 선택 하셨습니다.",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
