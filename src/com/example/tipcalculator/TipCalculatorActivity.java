package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout.LayoutParams;
import android.text.InputFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {
	EditText etAmount;
	TextView tvTip;
	InputMethodManager imm;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		etAmount = (EditText) findViewById(R.id.etAmount);
		tvTip = (TextView) findViewById(R.id.tvTip);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void onTipClick(View view) {
		
		int intID = view.getId();
		Double amount, Tip;
	      Button button = (Button) findViewById(intID);
	      String message = button.getText().toString();
	      int l= message.length();
	      
	      DecimalFormat dc = new DecimalFormat("0.00");
	      Double tipPercentage = Double.parseDouble(message.substring(0, l-1));
	      if (!etAmount.getText().toString().equals("") ){
	        amount = Double.parseDouble(etAmount.getText().toString());
	        Tip = (amount * tipPercentage)/100;
		      Tip = Math.round(Tip * 100.0)/100.0;
		      dc.format(Tip);
		      
	      } else {
	    	  
	    	  Tip =0.00;
	      }
	     
	      tvTip.setText("Tip is: $" + dc.format(Tip));
		
	}
	
	public void showTheKeyboard(EditText editText){
		 if(editText.requestFocus()){
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
		 }
    }

}
