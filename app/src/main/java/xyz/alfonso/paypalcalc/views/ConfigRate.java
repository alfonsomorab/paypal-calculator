package xyz.alfonso.paypalcalc.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xyz.alfonso.paypalcalc.R;
import xyz.alfonso.paypalcalc.utils.StoreInternalFiles;

public class ConfigRate extends AppCompatActivity {

    EditText editText_bs;
    EditText editText_cop;
    Button btn;

    private String BS = "bs_tax";
    private String COP = "cop_tax";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_rate);

        btn = findViewById(R.id.btn);
        editText_bs = findViewById(R.id.editText_bs);
        editText_cop = findViewById(R.id.editText_cop);

        Double bs = StoreInternalFiles.getDouble(this, BS);
        Double cop = StoreInternalFiles.getDouble(this, COP);

        editText_bs.setText(bs.toString());
        editText_cop.setText(cop.toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoreInternalFiles.saveDouble(ConfigRate.this, Double.valueOf(editText_bs.getText().toString()), BS);
                StoreInternalFiles.saveDouble(ConfigRate.this, Double.valueOf(editText_cop.getText().toString()), COP);

                Toast.makeText(ConfigRate.this, "Datos guardados con éxito", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(ConfigRate.this, Main.class));
                finish();
            }
        });
    }
}
