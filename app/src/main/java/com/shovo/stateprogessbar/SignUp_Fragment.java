package com.shovo.stateprogessbar;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp_Fragment extends Fragment {

    View mainView;
    private EditText nameText, numberText, passText;
    private Button nextButton;


    public SignUp_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView= inflater.inflate(R.layout.fragment_sign_up, container, false);



        nameText=mainView.findViewById(R.id.nameId);
        numberText=mainView.findViewById(R.id.numberId);
        passText=mainView.findViewById(R.id.passId);
        nextButton=mainView.findViewById(R.id.nextButtnId);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!numberText.getText().toString().isEmpty()&&!numberText.getText().toString().isEmpty()&&
                        !numberText.getText().toString().isEmpty()){
                    ((MainActivity)getActivity()).nextState();


                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }

            }
        });





        return mainView;
    }


}
