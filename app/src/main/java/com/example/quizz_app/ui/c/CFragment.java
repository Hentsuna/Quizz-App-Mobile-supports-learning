package com.example.quizz_app.ui.c;

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
import androidx.lifecycle.ViewModelProvider;

import com.example.quizz_app.R;
import com.example.quizz_app.databinding.FragmentCBinding;
import com.example.quizz_app.databinding.FragmentPythonBinding;
import com.example.quizz_app.ui.Slide.ScreenSlideActivity;

public class CFragment extends Fragment {

    Button btnRandom;
    private FragmentCBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentCBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        // Lấy các button từ layout
        btnRandom = binding.getRoot().findViewById(R.id.buttonRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageCauHoi = new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(pageCauHoi);
            }
        });
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}