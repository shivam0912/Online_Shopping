package com.example.onlineshopping.ui.help;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.onlineshopping.R;
import com.example.onlineshopping.help;


public class HelpFragment extends Fragment {
    private HelpViewModel helpViewModel;

    public View onCreate(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        helpViewModel =  ViewModelProviders.of(this).get(HelpViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_help, container, false);
        final TextView textView = root.findViewById(R.id.text_help);
       helpViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}
