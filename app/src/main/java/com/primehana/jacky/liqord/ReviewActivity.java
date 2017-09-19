package com.primehana.jacky.liqord;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Item> data;
    int selectedPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5fc050")));
        bar.setLogo(R.drawable.actionbar);
        bar.setDisplayShowTitleEnabled(false);

        lv = (ListView) findViewById(R.id.listView);

        data = new ArrayList<Item>();
        data.add(new Item(3, "GREY GOOSE LE CITRON", "116", "221", "750ML", 89.97));
        data.add(new Item(1, "JIM BEAM", "0549", "221", "750ML", 16.49));

        ItemAdapter adapter = new ItemAdapter(this, data);
        lv.setAdapter(adapter);

        registerForContextMenu(lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_review, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.inputmore_logout) {
            Dialog dlg = onCreateDialog();
            dlg.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.inputmore_logout)
            .setItems(R.array.inputmore_logout, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0) {
                        Intent intent = new Intent(ReviewActivity.this, VendorActivity.class);
                        startActivity(intent);
                    } else if (which == 1) {
                        Intent intent = new Intent(ReviewActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });
        return builder.create();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.quantity:
                Intent intent = new Intent(ReviewActivity.this, QuantityActivity.class);
                intent.putExtra("quantity", ((Item)(((ItemAdapter)(lv.getAdapter())).getItem(info.position))).m_quantity);
                intent.putExtra("name", ((Item)(((ItemAdapter)(lv.getAdapter())).getItem(info.position))).str_name);
                selectedPos = info.position;
                startActivityForResult(intent, 0);
                break;
            case R.id.delete:
                ItemAdapter adapter = (ItemAdapter) lv.getAdapter();
                data.remove(info.position);
                adapter.notifyDataSetChanged();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                int quantity = intent.getIntExtra("quantity", 0);
                ItemAdapter adapter = (ItemAdapter) lv.getAdapter();
                data.get(selectedPos).m_quantity = quantity;
                adapter.notifyDataSetChanged();
            }
        }
    }

}
