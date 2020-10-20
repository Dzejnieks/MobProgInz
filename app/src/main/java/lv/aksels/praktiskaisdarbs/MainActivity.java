package lv.aksels.praktiskaisdarbs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ndbutton = (Button) findViewById(R.id.ndButton);
        ndbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(activity2Intent);
            }
        });

        Button dialogButton = (Button) findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String[] optionsArray = new String[]{"one", "two", "three"};
                final boolean[] checkedOptionsArray = new boolean[]{
                        true, false, false
                };
                final List<String> optionList = Arrays.asList(optionsArray);
                builder.setTitle(("test"));
                builder.setMessage("msg");
                builder.setMultiChoiceItems(optionsArray, checkedOptionsArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedOptionsArray[which] = isChecked;
                        String currentItem = optionList.get(which);
                        Toast.makeText(MainActivity.this, currentItem+" "+ isChecked, Toast.LENGTH_SHORT).show();

                    }
                })
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which){

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
    public void openDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        String[] optionsArray = new String[]{"one", "two", "three"};
        final boolean[] checkedOptionsArray = new boolean[]{
                true, false, false
        };
        final List<String> optionList = Arrays.asList(optionsArray);
        builder.setTitle(("test"));
        builder.setMessage("msg");
        builder.setMultiChoiceItems(optionsArray, checkedOptionsArray, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkedOptionsArray[which] = isChecked;
                                String currentItem = optionList.get(which);
                                Toast.makeText(MainActivity.this, currentItem+" "+ isChecked, Toast.LENGTH_SHORT).show();

                            }
                        })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}