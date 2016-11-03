package id.sch.smktelkom_mlg.learn.intent1;

import android.annotation.TargetApi;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Hasil");
        String nama = getIntent().getStringExtra(MainActivity.NAMA);
        int umur = getIntent().getByteExtra(MainActivity.UMUR, (byte) 0);
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);
        int tahunLahir = yearNow - umur;

        TextView tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil.setText(nama +" lahir pada tahun "+ tahunLahir);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBackPressed();
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void OnBackPressed() {
    }
}
