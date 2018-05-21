package com.example.khushboo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button one,two,three,four,five,six,seven,eight,nine,decimal,clear,equal,zero,add,sub,mul,div,clearall;
    private TextView result,control;
    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char EQUAL='=';
    private double var1 = Double.NaN,var2;
    private char operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "0");
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "1");
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "2");
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "3");
            }
        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "4");
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "5");
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "6");
            }
        });


        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "7");
            }
        });


        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "8");
            }
        });


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "9");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                int flag=1;


                String check_dec[]= control.getText().toString().split("");
                for(int i=0;i<check_dec.length;i++)
                {

                    if(check_dec[i].equals("."))
                    {

                         flag=0;
                    }
                }

                if(flag==1)
                {

                    if (control.getText().toString()!= "")
                        control.setText(control.getText().toString()+".");
                    else
                        control.setText("0.");
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                compute();
                operation=ADDITION;
                if (!Double.isNaN(var1))
                result.setText(String.valueOf(var1) + "+");
                control.setText(null);

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                compute();
                operation=SUBTRACTION;
                if (!Double.isNaN(var1))
                result.setText(String.valueOf(var1) + "-");
                control.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                compute();
                operation=MULTIPLICATION;
                if (!Double.isNaN(var1))
                result.setText(String.valueOf(var1) + "*");
                control.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                compute();
                operation=DIVISION;
                if (!Double.isNaN(var1))
                result.setText(String.valueOf(var1) + "/");
                control.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                compute();
                operation=EQUAL;
                if (!Double.isNaN(var1))
                result.setText(String.valueOf(var1));
                System.out.println("var1 in equal = " + var1 + " var2 is == " + var2);
                control.setText(null);
                System.out.println("var1 in equal = " + var1 + " var2 is == " + var2);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(control.getText().length()>0) {
                     CharSequence name = control.getText().toString();
                     control.setText(name.subSequence(0, name.length() - 1));
                 }

            }
        });

        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(null);
                result.setText(null);
                var1=Double.NaN; var2=Double.NaN;
            }
        });

    }

    public void setup()
    {
        zero= (Button) findViewById(R.id.button0);
        one= (Button) findViewById(R.id.button1);
        two= (Button) findViewById(R.id.button2);
        three= (Button) findViewById(R.id.button3);
        four= (Button) findViewById(R.id.button4);
        five= (Button) findViewById(R.id.button5);
        six= (Button) findViewById(R.id.button6);
        seven= (Button) findViewById(R.id.button7);
        eight= (Button) findViewById(R.id.button8);
        nine= (Button) findViewById(R.id.button9);
        add= (Button) findViewById(R.id.button_add);
        div= (Button) findViewById(R.id.button_div);
        mul= (Button) findViewById(R.id.button_mul);
        sub= (Button) findViewById(R.id.button_sub);
        clear= (Button) findViewById(R.id.button_clear);
        decimal= (Button) findViewById(R.id.button_point);
        equal= (Button) findViewById(R.id.button_equal);
        clearall= (Button) findViewById(R.id.button_clearall);

        control= (TextView) findViewById(R.id.tvControl);
        result= (TextView) findViewById(R.id.tvResult);
    }

    public void compute()
    {
        //System.out.println("IN compute function : " +
          //      "    var1 =" + var1 + " var2 = " + var2 + "operation =" + operation  );
        if(!Double.isNaN(var1))
        {
            //System.out.println("control.gettext().totsring has =" + control.getText() );

             if(control.getText() != "") {
              //   System.out.println( "coming in of if");
                 var2 = Double.parseDouble(control.getText().toString());
             }
                //System.out.println( "coming out of if");
            switch (operation)
            {

                case ADDITION: var1 = var1+var2; break;
                case SUBTRACTION: var1 = var1-var2; break;
                case MULTIPLICATION: var1 = var1*var2; break;
                case DIVISION: var1 = var1/var2; break;
                case EQUAL: System.out.println("coming to equal and breaking "); break;
            }

        }
        else
        {
           // System.out.println("coming here hahahahhahaha");
            //System.out.println("before :: var1 = " + var1  + " and var2 = " + var2);
           // System.out.println("var 1 ===" + var1);
            System.out.println("coming here 1");
            if(!control.getText().toString().equals("") )
            {
                System.out.println("coming here 2");
                Double x=Double.parseDouble(control.getText().toString());
                System.out.println("x==" + x);
                if(!Double.isNaN(x))
                var1 = Double.parseDouble(control.getText().toString());
            }
           // System.out.println("var 1 ===" + var1);
            //System.out.println("after :: var1 = " + var1  + " and var2 = " + var2);
        }

       // System.out.println("exiting");
    }
}
