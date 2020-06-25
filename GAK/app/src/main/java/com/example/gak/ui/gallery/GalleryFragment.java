package com.example.gak.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gak.R;
import com.example.gak.Windows2Item;
import com.example.gak.Windows2Sliding;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

        int f;
    Intent x1,x2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        Button b1=root.findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1=new Intent(getContext(), Windows2Item.class);
                f=2;
                x1.putExtra("Flag",f);

                startActivity(x1);
            }
        });
        Button b2=root.findViewById(R.id.button3);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x2=new Intent(getContext(), Windows2Item.class);
                f=3;
                x2.putExtra("Flag",f);

                startActivity(x2);


            }
        });

        return root;
    }
}
