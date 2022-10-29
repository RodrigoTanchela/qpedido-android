package com.qpedido.android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qpedido.android.R;

public class RegisterFragment extends Fragment {

    EditText birthField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        birthField = view.findViewById(R.id.editTextBirth);
        birthListener(view);
        return view;
    }

    @SuppressLint("SetTextI18n")
    public void birthListener(View view) {
        birthField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println();
                editable.setFilters(new InputFilter[]{
                        new InputFilter() {
                            @Override
                            public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
                                System.out.println(i);
                                System.out.println(i1);
                                return null;
                            }
                        }
                });
                if (editable.length() == 2 || editable.length() == 5) {
                    editable.append("/");
                } else if (editable.length() >= 10) {
                    editable.delete(editable.length(), editable.length());
                }
            }
        });
    }
}