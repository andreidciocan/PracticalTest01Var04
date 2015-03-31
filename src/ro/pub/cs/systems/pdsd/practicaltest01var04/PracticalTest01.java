package ro.pub.cs.systems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class PracticalTest01 extends Activity {

	private int total = 0;
	private int wrong = 0;
	private int correct = 0;
	
	
	private class ButtonListener implements Button.OnClickListener {

		@Override
		public void onClick(View v) {	
			EditText t = (EditText) findViewById(R.id.edit_text);
			String text = t.getText().toString();
			String new_text = "";
			if (text.length() > 0) {
				new_text = text + ", ";
			}
			switch (v.getId()) {
			case R.id.do2_button:
				new_text = new_text + "Do\'";
				break;
			case R.id.sol_button:
				new_text = new_text + "Sol";
				break;
			case R.id.mi_button:
				new_text = new_text + "Mi";
				break;
			case R.id.do_button:
				new_text = new_text + "Do";
				break;
			case R.id.navigate_to_sec_activity : 
				Intent intent = new Intent("activ2");
		        intent.putExtra("notes", text);
		        startActivityForResult(intent, 1);
			} 
			t.setText(new_text);
		}
			
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01);
	
		Button b1 = (Button) findViewById(R.id.do2_button);
		Button b2 = (Button) findViewById(R.id.sol_button);
		Button b3 = (Button) findViewById(R.id.mi_button);
		Button b4 = (Button) findViewById(R.id.do_button);
		Button b5 = (Button) findViewById(R.id.navigate_to_sec_activity);
		
		b1.setOnClickListener(new ButtonListener());
		b2.setOnClickListener(new ButtonListener());
		b3.setOnClickListener(new ButtonListener());
		b4.setOnClickListener(new ButtonListener());
		b5.setOnClickListener(new ButtonListener());
		
		EditText t = (EditText) findViewById(R.id.edit_text);
		t.setOnClickListener(null);
		
		if (savedInstanceState != null) {
			total = Integer.parseInt(savedInstanceState.getString("total"));
			wrong = Integer.parseInt(savedInstanceState.getString("wrong"));
			correct = Integer.parseInt(savedInstanceState.getString("correct"));
		}
		
		System.out.println("Total number of tries : " + String.valueOf(total));
		System.out.println("Total number of correct trie" + String.valueOf(correct));
		System.out.println("Total number of wrong tries : " + String.valueOf(wrong));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onSaveInstanceState (Bundle saveInstance) {
		saveInstance.putString("total", String.valueOf(total));
		saveInstance.putString("correct", String.valueOf(correct));
		saveInstance.putString("wrong", String.valueOf(wrong));
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	  String result = " OK !!! "; 
	  if (resultCode < 0) { 
		  result = " not ok .. ";
	  }
	  Toast.makeText(this, "The activity returned with result " + result, Toast.LENGTH_LONG).show();
	  EditText t = (EditText) findViewById(R.id.edit_text);
	  t.setText("");
	  total ++;
	  if (resultCode == 0) {
		  correct ++;
	  } else {
		  wrong ++;
	  }
	}
}
