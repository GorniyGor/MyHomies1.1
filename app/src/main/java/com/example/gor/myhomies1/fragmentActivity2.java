package com.example.gor.myhomies1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class fragmentActivity2 extends Fragment {

    private TextView name;
    private TextView surname;
    private TextView date;

    public fragmentActivity2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name = (TextView) getActivity().findViewById(R.id.Name);
        surname = (TextView) getActivity().findViewById(R.id.Surname);
        date = (TextView) getActivity().findViewById(R.id.Date);

        name.setText(getActivity().getIntent().getStringExtra("name"));
        surname.setText(getActivity().getIntent().getStringExtra("surname"));
        date.setText(getActivity().getIntent().getStringExtra("date"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_activity_main, container, false);

        Button button = (Button) v.findViewById(R.id.buttonEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonEdit:
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });


        return v;

    }

}
