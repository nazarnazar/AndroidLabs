package com.example.nazar.lab1;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Nazar on 03-May-18.
 */
public class InputFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private MyColors[] _myColors;
    private int _pickedColorIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        _myColors = new MyColors[3];
        _myColors[0] = new MyColors("Soft Red", "#ff4040");
        _myColors[1] = new MyColors("Soft While", "#ffffC0");
        _myColors[2] = new MyColors("Soft Yellow", "#ffff40");
        _pickedColorIndex = 0;

        final EditText editText = (EditText) view.findViewById(R.id.editText2);
        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar2);

        final Button colorButton = (Button)view.findViewById(R.id.button3);
        colorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _pickedColorIndex++;
                        if (_pickedColorIndex > 2)
                            _pickedColorIndex = 0;
                        colorButton.setBackgroundColor(Color.parseColor(_myColors[_pickedColorIndex].GetColor()));
                    }
                }
        );

        Button submitButton = (Button)view.findViewById(R.id.button4);
        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message = "Message: " + editText.getText().toString() + "\nColor: " +
                                _myColors[_pickedColorIndex].GetName() + "\nPrice: " +
                                seekBar.getProgress() + "$";
                        mListener.onFragmentInteraction(message);
                    }
                }
        );

        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " should implement OnFragmentInteractionListener");
        }
    }
}
