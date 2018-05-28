package com.example.nazar.lab1;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Nazar on 03-May-18.
 */
public class OutputFragment extends Fragment {

    private TextView textView;

    private final static String FILE_NAME = "orders.txt";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_output, container, false);

        textView = (TextView) view.findViewById(R.id.textView);

        Button saveButton = (Button)view.findViewById(R.id.button);
        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String data = textView.getText().toString();
                        if (data != "") {
                            FileOutputStream fos = null;
                            try {
                                fos = getActivity().getApplicationContext().openFileOutput(FILE_NAME, Context.MODE_APPEND);
                                data = "\n" + data + "\n";
                                fos.write(data.getBytes());
                                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
                            }
                            catch(IOException ex) {
                                Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            finally{
                                try{
                                    if(fos!=null)
                                        fos.close();
                                }
                                catch(IOException ex){
                                    Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
        );

        Button loadButton = (Button)view.findViewById(R.id.button2);
        loadButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), DataActivity.class);
                        startActivity(intent);
                    }
                }
        );

        return view;
    }

    public void setText(String data) {
        textView.setText(data);
    }
}
