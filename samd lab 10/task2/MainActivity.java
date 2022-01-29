•	package com.example.lab_10;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b;
        b=(Button) findViewById(R.id.b1);
        registerForContextMenu(b);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        menu.setHeaderTitle("Context MENU");
        menu.add("dialog");
        menu.add("op2");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if(item.getTitle()=="HEY")
        {
            //Toast.makeText(getApplicationContext(), "Dialog",         Toast.LENGTH_SHORT).show();
            customDialogue();
        }
        else if(item.getTitle()=="BYE")
                
        {
            Toast.makeText(getApplicationContext(), "BYE",
                    Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add("Show Dialog");
        menu.add("Close This");
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if(item.getTitle()=="Show Dialog")
        {
            customDialogue();
        }
        else if(item.getTitle()=="Close This")
        {
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        // TODO Auto-generated method stub
        return super.onMenuItemSelected(featureId, item);
    }
    private void customDialogue(){
        AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(R.drawable.ic_launcher);
        dialog.setMessage("Custom Dialog at your Service");
        dialog.setTitle("Custom DIALOG");
        dialog.setNegativeButton("NOPE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        dialog.setPositiveButton("YEAH", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        dialog.setNeutralButton("OKAY", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        AlertDialog ok= dialog.create();
        ok.show();
    }
}
