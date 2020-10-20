package lv.aksels.praktiskaisdarbs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String[] optionsArray = new String[]{"one", "two", "three"};
        final boolean[] checkedOptionsArray = new boolean[]{
                true, false, false
        };
        final List<String> optionList = Arrays.asList(optionsArray);
        builder.setTitle(("test"))
                .setMessage("msg")
                .setMultiChoiceItems(optionsArray, checkedOptionsArray,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                            checkedOptionsArray[which] = isChecked;
                            String currentItem = optionList.get(which);
                        Toast.makeText(getActivity(), currentItem+" "+ isChecked, Toast.LENGTH_SHORT).show();

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                });
        return builder.create();
    }

}
