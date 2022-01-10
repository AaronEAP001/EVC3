package com.example.evc3;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFrame extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loging_inicio,container,false);
        final TextInputLayout textInputLayout = view.findViewById(R.id.login_number_input);
        final TextInputEditText textInputEditText = view.findViewById(R.id.login_number_edit);
        MaterialButton loginButton = view.findViewById(R.id.btnstar_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isNumberValid(textInputEditText.getText())){
                    textInputLayout.setError(getString(R.string.login_error));
                }else{
                    textInputLayout.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new HomeFrame(),false);
                }
            }
        });

        textInputEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(isNumberValid(textInputEditText.getText())){
                    textInputLayout.setError(null);
                }
                return false;
            }
        });

        return view;
    }

    private boolean isNumberValid(@Nullable Editable number){ return number != null && number.length() == 9; }

}







