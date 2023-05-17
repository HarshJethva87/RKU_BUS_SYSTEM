package com.example.praticeapp.ui.complain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.praticeapp.R;
import com.example.praticeapp.databinding.FragmentComplainBinding;
import com.google.android.material.textfield.TextInputEditText;


public class ComplainFragment extends Fragment {

    private FragmentComplainBinding binding;
    TextInputEditText toemail,tosub,tomsg;
    Button tosend;


    public ComplainFragment() {
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ComplainViewModel complainViewModel = new ViewModelProvider(this).get(ComplainViewModel.class);
        binding = FragmentComplainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        root = inflater.inflate(R.layout.fragment_complain,container,false);



        toemail = root.findViewById(R.id.Cemail);
        tosub = root.findViewById(R.id.Csubject);
        tomsg = root.findViewById(R.id.Cmessage);
        tosend = (Button) root.findViewById(R.id.sendemails);




        tosend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmail();
            }
        });


        return root;
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
    private void sendmail()
    {
        String recipientList = toemail.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = tosub.getText().toString();
        String message = tomsg.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        
        startActivity(Intent.createChooser(intent,"choose an email client"));


    }


}