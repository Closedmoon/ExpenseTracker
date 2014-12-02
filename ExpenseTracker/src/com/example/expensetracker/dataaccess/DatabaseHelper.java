package com.example.expensetracker.dataaccess;

import com.example.expensetracker.dataaccess.DatabaseContract.DBCATEGORY;
import com.example.expensetracker.dataaccess.DatabaseContract.DBCONTACTS;
import com.example.expensetracker.dataaccess.DatabaseContract.DBEXPENSE;
import com.example.expensetracker.dataaccess.DatabaseContract.DBEXPENSEDISTRIBUTION;
import com.example.expensetracker.dataaccess.DatabaseContract.DBEXPENSEPAID;
import com.example.expensetracker.dataaccess.DatabaseContract.DBGROUP;
import com.example.expensetracker.dataaccess.DatabaseContract.DBGROUPCONTACTS;
import com.example.expensetracker.dataaccess.DatabaseContract.DBINFO;
import com.example.expensetracker.dataaccess.DatabaseContract.DBTYPE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	
	 public static final String SQL_CREATE_Group = DBTYPE.CREATE_TABLE
	            + DBGROUP.TABLE + DBTYPE.PARENTHESIS_OPEN 
	            + DBGROUP._ID + DBTYPE.INTEGER_PRIMARY_KEY + DBTYPE.COMMA 
	            + DBGROUP.NAME + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBGROUP.TYPE + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_DT + DBTYPE.TEXT +  DBTYPE.COMMA  
	            + DBCONTACTS.MODIFIED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.MODIFIED_DT + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBTYPE.PARENTHESIS_CLOSE;
	 
	 public static final String SQL_CREATE_Contacts = DBTYPE.CREATE_TABLE
	            + DBCONTACTS.TABLE + DBTYPE.PARENTHESIS_OPEN 
	            + DBCONTACTS._ID + DBTYPE.INTEGER_PRIMARY_KEY + DBTYPE.COMMA 
	            + DBCONTACTS.NAME + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.EMAIL + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.PHONE + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_DT + DBTYPE.TEXT +  DBTYPE.COMMA  
	            + DBCONTACTS.MODIFIED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.MODIFIED_DT + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBTYPE.PARENTHESIS_CLOSE;
	 
	 public static final String SQL_CREATE_Category = DBTYPE.CREATE_TABLE
	            + DBCATEGORY.TABLE + DBTYPE.PARENTHESIS_OPEN 
	            + DBCATEGORY._ID + DBTYPE.INTEGER_PRIMARY_KEY + DBTYPE.COMMA 
	            + DBCATEGORY.NAME + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_DT + DBTYPE.TEXT +  DBTYPE.COMMA  
	            + DBCONTACTS.MODIFIED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.MODIFIED_DT + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBTYPE.PARENTHESIS_CLOSE;
	 
	 public static final String SQL_CREATE_GroupContacts = DBTYPE.CREATE_TABLE
	            + DBGROUPCONTACTS.TABLE + DBTYPE.PARENTHESIS_OPEN 
	            + DBGROUPCONTACTS._ID + DBTYPE.INTEGER_PRIMARY_KEY + DBTYPE.COMMA 
	            + DBGROUPCONTACTS.GROUPID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBGROUPCONTACTS.CONTACTID + DBTYPE.INTEGER +  DBTYPE.COMMA
	            + DBCONTACTS.CREATED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_DT + DBTYPE.TEXT +  DBTYPE.COMMA  
	            + DBCONTACTS.MODIFIED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.MODIFIED_DT + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBTYPE.PARENTHESIS_CLOSE;
	 
	 public static final String SQL_CREATE_Expense = DBTYPE.CREATE_TABLE
	            + DBEXPENSE.TABLE + DBTYPE.PARENTHESIS_OPEN 
	            + DBEXPENSE._ID + DBTYPE.INTEGER_PRIMARY_KEY + DBTYPE.COMMA 
	            + DBEXPENSE.CATEGORYID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBEXPENSE.GROUPID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBEXPENSE.EXPENSENAME + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBEXPENSE.EXPENSETYPEID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBEXPENSE.AMOUNT + DBTYPE.REAL +  DBTYPE.COMMA 
	            + DBEXPENSE.EXPENSEDATE + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBEXPENSE.NOTES + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_DT + DBTYPE.TEXT +  DBTYPE.COMMA  
	            + DBCONTACTS.MODIFIED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.MODIFIED_DT + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBTYPE.PARENTHESIS_CLOSE;
	 
	 public static final String SQL_CREATE_ExpensePaid = DBTYPE.CREATE_TABLE
	            + DBEXPENSEPAID.TABLE + DBTYPE.PARENTHESIS_OPEN 
	            + DBEXPENSEPAID._ID + DBTYPE.INTEGER_PRIMARY_KEY + DBTYPE.COMMA 
	            + DBEXPENSEPAID.EXPENSEID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBEXPENSEPAID.CONTACTID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBEXPENSEPAID.AMOUNT + DBTYPE.REAL +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_DT + DBTYPE.TEXT +  DBTYPE.COMMA  
	            + DBCONTACTS.MODIFIED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.MODIFIED_DT + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBTYPE.PARENTHESIS_CLOSE;
	 
	 public static final String SQL_CREATE_ExpenseDistribution = DBTYPE.CREATE_TABLE
	            + DBEXPENSEDISTRIBUTION.TABLE + DBTYPE.PARENTHESIS_OPEN 
	            + DBEXPENSEDISTRIBUTION._ID + DBTYPE.INTEGER_PRIMARY_KEY + DBTYPE.COMMA 
	            + DBEXPENSEDISTRIBUTION.EXPENSEID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBEXPENSEDISTRIBUTION.CONTACTID + DBTYPE.INTEGER +  DBTYPE.COMMA 
	            + DBEXPENSEDISTRIBUTION.DISTRIBUTIONTYPE + DBTYPE.TEXT +  DBTYPE.COMMA
	            + DBEXPENSEDISTRIBUTION.AMOUNT + DBTYPE.REAL +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.CREATED_DT + DBTYPE.TEXT +  DBTYPE.COMMA  
	            + DBCONTACTS.MODIFIED_BY + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBCONTACTS.MODIFIED_DT + DBTYPE.TEXT +  DBTYPE.COMMA 
	            + DBTYPE.PARENTHESIS_CLOSE;
	
	 
	 
	 
	
	 public DatabaseHelper(Context context) {
	        super(context, DBINFO.DBNAME, null, DBINFO.DBVERSION);
	      //  Log.d("DB VERSION = ", String.valueOf(DBINFO.DBVERSION));
	    }

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_Group);
		db.execSQL(SQL_CREATE_Category);
		db.execSQL(SQL_CREATE_Contacts);
		db.execSQL(SQL_CREATE_GroupContacts);
		db.execSQL(SQL_CREATE_Expense);
		db.execSQL(SQL_CREATE_ExpensePaid);
		db.execSQL(SQL_CREATE_ExpenseDistribution);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
