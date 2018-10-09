package io.github.dwaffles.diceroller;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating needed objects
        Button rollButton = (Button) findViewById(R.id.rollButton); //create button object and cast
        final EditText numDiceEditText = (EditText) findViewById(R.id.numDiceEditText);
        final EditText numFaceEditText = (EditText) findViewById(R.id.numFaceEditText);
        final TextView totalOutputTextView = (TextView) findViewById(R.id.totalOutputTextView);
        final TextView individualOutputTextView = (TextView) findViewById(R.id.individualOutputView);

        individualOutputTextView.setMovementMethod(new ScrollingMovementMethod());

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numDiceEditText.getText().toString().length() > 0 && numFaceEditText.getText().toString().length() > 0){ //if statement to prevent app crash
                    int numDice = Integer.parseInt(numDiceEditText.getText().toString());
                    int numFaces = Integer.parseInt(numFaceEditText.getText().toString());
                    int result = 0;
                    ArrayList<Integer> diceRolls= new ArrayList<Integer>();

                    for(int index = 0; index < numDice; index++){
                        diceRolls.add((int)(Math.random() * (numFaces) + 1));

                        result += diceRolls.get(index);
                    }

                    totalOutputTextView.setText(Integer.toString(result));
                    totalOutputTextView.setTextColor(Color.BLACK);
                    individualOutputTextView.setText(diceRolls.toString());
                    individualOutputTextView.setTextColor(Color.BLACK);
                }
                else{
                    totalOutputTextView.setText("Enter required values");
                }
            }
        });
    }
}
