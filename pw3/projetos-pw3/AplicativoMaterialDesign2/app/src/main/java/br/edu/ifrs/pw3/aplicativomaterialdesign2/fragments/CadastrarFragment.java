package br.edu.ifrs.pw3.aplicativomaterialdesign2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.edu.ifrs.pw3.aplicativomaterialdesign2.R;


public class CadastrarFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cadastrar, container, false);
        return root;
    }
}