2.	package com.samd.gridview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        ImageAdapter adapter = new ImageAdapter(this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
//                registerForContextMenu(findViewById(adapter.mThumbIds[position]));
                ImageView imageView = (ImageView) findViewById(adapter.mThumbIds[position]);
                registerForContextMenu(v);

//                Context context = getApplicationContext();
//                CharSequence text = adapter.mThumbs[position];
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        menu.setHeaderTitle("Context MENU");

        menu.add("Insert");
        menu.add("Update");
        menu.add("Delete");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getTitle() == "Home") {
            customDialogue();
        } else if (item.getTitle() == "Insert") {
            Toast.makeText(getApplicationContext(), "OP2",
                    Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "Delete") {
            Toast.makeText(getApplicationContext(), "OP3",
                    Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getTitle() == "Show Dialog") {
            customDialogue();
        } else if (item.getTitle() == "Close This") {
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        // TODO Auto-generated method stub
        return super.onMenuItemSelected(featureId, item);
    }

    private void customDialogue() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.drawable.ic_launcher_background);
        dialog.setMessage("Custom Dialog at your Service");
        dialog.setTitle("Custom DIALOG");
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("YEah", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        dialog.setNeutralButton("Middle", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        AlertDialog ok = dialog.create();
        ok.show();
    }
}

