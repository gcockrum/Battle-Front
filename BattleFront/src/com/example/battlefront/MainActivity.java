package com.example.battlefront;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.battlefront.MESSAGE";
	Button quickStartButton;
	Button inviteFriendsButton;
	Button findFriendsButton;
	Button statsButton;
	Button optionsButton;
	GameBoard gb = new GameBoard();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Create handlers for all the buttons on the start screen
		quickStartButton = (Button) findViewById(R.id.quick_start);
		quickStartButton.setOnClickListener(quickStartHandler);
		inviteFriendsButton = (Button) findViewById(R.id.invite_friends);
		inviteFriendsButton.setOnClickListener(inviteFriendsHandler);
		findFriendsButton = (Button) findViewById(R.id.find_friends);
		findFriendsButton.setOnClickListener(findFriendsHandler);
		statsButton = (Button) findViewById(R.id.stats);
		statsButton.setOnClickListener(statsHandler);
		optionsButton = (Button) findViewById(R.id.options);
		optionsButton.setOnClickListener(optionsHandler);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.	
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// Click listener for the quick start button
	View.OnClickListener quickStartHandler = new View.OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, GameBoard.class);
			startActivity(intent);
		}
	};
	
	// Click listener for the invite friends button
	View.OnClickListener inviteFriendsHandler = new View.OnClickListener() {
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "I Haven't been implemented yet. I'm sorry :(", Toast.LENGTH_SHORT).show();
		}
	};
	
	
	// Click listener for the find friends button
	View.OnClickListener findFriendsHandler= new View.OnClickListener() {
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "I Haven't been implemented yet. I'm sorry :(", Toast.LENGTH_SHORT).show();
		}
	};
	
	
	// Click listener for the stats button
	View.OnClickListener statsHandler= new View.OnClickListener() {
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "I Haven't been implemented yet. I'm sorry :(", Toast.LENGTH_SHORT).show();
		}
	};

	// Click listener for the options button
	View.OnClickListener optionsHandler= new View.OnClickListener() {
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "I Haven't been implemented yet. I'm sorry :(", Toast.LENGTH_SHORT).show();
		}
	};
}
