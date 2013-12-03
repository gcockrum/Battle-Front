package com.example.battlefront;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.battlefront.MESSAGE";
	Button b1;
	GameBoard gb = new GameBoard();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.start_game);
		b1.setOnClickListener(myhandler1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.	
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
//	public void sendMessage(View view) {
//		
//		startActivity(intent);
//	}
	
	View.OnClickListener myhandler1 = new View.OnClickListener() {
	    public void onClick(View v) {
	      // it was the 1st button
	    	//System.out.println("BUTTON");
	    	Intent intent = new Intent(MainActivity.this, GameBoard.class);
	    	startActivity(intent);
	    }
	  };

}
