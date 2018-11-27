package com.bh.noteon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Menu1Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater Inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return Inflater.inflate(R.layout.fragment_menu1, container,false);
    }
}