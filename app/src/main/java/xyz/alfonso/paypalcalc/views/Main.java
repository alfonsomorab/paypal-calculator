package xyz.alfonso.paypalcalc.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import xyz.alfonso.paypalcalc.R;
import xyz.alfonso.paypalcalc.utils.StoreInternalFiles;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView text_receive;
    TextView text_receive_amount;
    TextView text_receive_commission;
    TextView text_borrow;
    TextView text_borrow_amount;
    TextView text_borrow_commission;

    TextView text_receive_bs;
    TextView text_receive_cop;
    TextView text_borrow_bs;
    TextView text_borrow_cop;

    EditText editText_amount;

    Double bstax;
    Double coptax;

    NumberFormat format;

    private String BS = "bs_tax";
    private String COP = "cop_tax";

    private static double COMMISSION = 0.054;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        format = NumberFormat.getCurrencyInstance(Locale.GERMAN);

        text_borrow = findViewById(R.id.text_borrow);
        text_borrow_amount = findViewById(R.id.text_borrow_amount);
        text_borrow_commission = findViewById(R.id.text_borrow_commission);
        text_receive = findViewById(R.id.text_receive);
        text_receive_amount = findViewById(R.id.text_receive_amount);
        text_receive_commission = findViewById(R.id.text_receive_commission);
        text_receive_bs = findViewById(R.id.text_receive_bs);
        text_receive_cop = findViewById(R.id.text_receive_cop);
        text_borrow_bs = findViewById(R.id.text_borrow_bs);
        text_borrow_cop = findViewById(R.id.text_borrow_cop);

        editText_amount = findViewById(R.id.editText_amount);


        editText_amount.addTextChangedListener(new Main.MyTextWatcher(editText_amount));

        bstax = StoreInternalFiles.getDouble(this, BS);
        coptax = StoreInternalFiles.getDouble(this, COP);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(this, ConfigRate.class));

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {

            switch (view.getId()){
                case R.id.editText_amount:
                    generateCalc();
                    break;

            }

        }
    }

    private void generateCalc() {
        String samount = editText_amount.getText().toString().trim();
        samount = samount.compareTo("") != 0 ? samount : "0.00";
        Double amount = Double.valueOf(samount);

        //----- Receive
        Double receive = (amount - (amount * COMMISSION)) - 0.3;
        Double receive_commission = amount - receive;

        Double receive_bs = receive * bstax;
        Double receive_cop = receive * coptax;


        //----- Borrow
        Double borrow = (amount + 0.3)/(1 - COMMISSION);
        Double borrow_commission = borrow - amount;

        Double borrow_bs = borrow * bstax;
        Double borrow_cop = borrow * coptax;

        //----- Refresh view

        this.text_receive.setText(String.format(Locale.US,"%.2f",receive));
        this.text_receive_amount.setText(new StringBuilder().append("Si se envían $").append(String.format(Locale.US,"%.2f",amount)));
        this.text_receive_commission.setText(new StringBuilder().append("Comisión $").append(String.format(Locale.US, "%.2f", receive_commission)));
        this.text_receive_bs.setText(format.format(receive_bs));
        this.text_receive_cop.setText(format.format(receive_cop));


        this.text_borrow.setText(String.format(Locale.US,"%.2f", borrow));
        this.text_borrow_amount.setText(new StringBuilder().append("Para recibir $").append(String.format(Locale.US,"%.2f", amount)));
        this.text_borrow_commission.setText(new StringBuilder().append("Comisión $").append(String.format(Locale.US,"%.2f", borrow_commission)));
        this.text_borrow_bs.setText(format.format(borrow_bs));
        this.text_borrow_cop.setText(format.format(borrow_cop));

    }
}
