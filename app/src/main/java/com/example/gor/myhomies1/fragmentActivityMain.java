package com.example.gor.myhomies1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class fragmentActivityMain extends Fragment {

    private EditText name;
    private EditText surname;
    private TextView date;
    //FOR dateDialog
    int myYear, myMonth, myDay;

    public fragmentActivityMain() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name = (EditText) getActivity().findViewById(R.id.editName);
        surname = (EditText) getActivity().findViewById(R.id.editSurname);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_activity_main, container, false);

        //Realize date-data-----------------------------------------------------

        final Calendar cal = Calendar.getInstance();
        myYear = cal.get(Calendar.YEAR);
        myMonth = cal.get(Calendar.MONTH);
        myDay = cal.get(Calendar.DAY_OF_MONTH);

        date = (TextView) getActivity().findViewById(R.id.editDate);

        date.setOnClickListener(new View.OnClickListener() {

            DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    myYear = year;
                    myMonth = month;
                    myDay = dayOfMonth;
                    date.setText(myDay + "/" + myMonth + "/" + myYear);
                }
            };
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), callBack, myYear, myMonth, myDay).show();
            }
        });
        //----------------------------------------------------------------

        Button button = (Button) v.findViewById(R.id.buttonSave);
        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonSave:
                        Intent intent = new Intent(getActivity(), Activity2.class);
                        intent.putExtra("name", name.getText().toString());
                        intent.putExtra("surname", surname.getText().toString());
                        intent.putExtra("date", date.getText().toString());
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });

        //Check for fields----------------------------------------------------

        if(name.getText().length() > 0 &&
                surname.getText().length() > 0 && date.getText().length() > 0) button.setEnabled(true);

        //----------------------------------------------------------------------


        return v;
    }





}
