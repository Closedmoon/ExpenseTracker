package com.example.expensetracker;

import java.util.ArrayList;

import com.example.expensetracker.entities.Contact;
import com.example.expensetracker.entities.GroupContacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddGroupActivity extends Activity {
	
	ArrayList<EditText> listControls;
	private ArrayAdapter<String> adapter;
	EditText tvGroupName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_group);
		listControls = new ArrayList<EditText>();
		
		readContactData();
		
		
	}
	
	public void readContactData() {
		adapter = new ArrayAdapter<String>
        (this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
		
		ContentResolver cr = getBaseContext()
                .getContentResolver();
         
        //Query to get contact name
         
        Cursor cur = cr
                .query(ContactsContract.Contacts.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);
        
     // If data data found in contacts 
        if (cur.getCount() > 0) {
             
            String name = "";
             
            while (cur.moveToNext()) 
            {
                 
                String id = cur
                        .getString(cur
                                .getColumnIndex(ContactsContract.Contacts._ID));
                name = cur
                        .getString(cur
                                .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                
                adapter.add(name);
                 
            }  // End while loop

        } // End Cursor value check
        cur.close();
		
		
	}
	
	
	public void AddTextControl(View v)
	{
		View linearLayout =  findViewById(R.id.llmembers);
        //LinearLayout layout = (LinearLayout) findViewById(R.id.info);


        AutoCompleteTextView newMember = new AutoCompleteTextView(getApplicationContext());
        newMember.setHint("eg .. Name");
        newMember.setInputType(InputType.TYPE_CLASS_TEXT);
        newMember.setTextColor(Color.BLACK);
        newMember.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        ((LinearLayout) linearLayout).addView(newMember);
        newMember.setAdapter(adapter);
        
        listControls.add(newMember);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_group, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			saveGroup();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void saveGroup() {
		GroupContacts group = new GroupContacts();
		ArrayList<Contact> listContacts = new ArrayList<Contact>();
		tvGroupName = (EditText) findViewById(R.id.txtGroupName);
		
		group.set_groupname(tvGroupName.getText().toString());
		
		for(EditText et: listControls) {
			if(et.getText().toString().trim() != "") {
			 Contact contact = new Contact();
			 contact.setName(et.getText().toString());
			 listContacts.add(contact);
			}
		}
		
		group.set_contactlist(listContacts);
		
	}
	
	
}
