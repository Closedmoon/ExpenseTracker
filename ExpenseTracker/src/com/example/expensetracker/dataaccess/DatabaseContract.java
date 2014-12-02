package com.example.expensetracker.dataaccess;

import android.provider.BaseColumns;

public class DatabaseContract {
	
	/**
     * Constructor
     **/
    public DatabaseContract() {
    }

    /**
     * DataBase Schema Info
     */
    public static abstract class DBINFO {
        public static final String DBNAME = "expense_tracker.db";
        public static final int DBVERSION = 1;
    }

    /**
     * DataBase Schema Region
     */
    public static abstract class DBGROUP implements BaseColumns {
        public static final String TABLE = "groupmaster";
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String CREATED_BY = "created_by";
        public static final String CREATED_DT = "created_dt";
        public static final String MODIFIED_BY = "modified_by";
        public static final String MODIFIED_DT = "modified_dt";
        
    }
    
    public static abstract class DBCONTACTS implements BaseColumns {
    	public static final String TABLE = "contactsmaster";
    	public static final String ID = "_id";
    	public static final String NAME = "name";
    	public static final String EMAIL = "email";
    	public static final String PHONE = "phone";
    	public static final String CREATED_BY = "created_by";
        public static final String CREATED_DT = "created_dt";
        public static final String MODIFIED_BY = "modified_by";
        public static final String MODIFIED_DT = "modified_dt";
    }
    
    public static abstract class DBCATEGORY implements BaseColumns {
    	public static final String TABLE = "categorymaster";
    	public static final String ID = "_id";
    	public static final String NAME = "name";
    	public static final String CREATED_BY = "created_by";
        public static final String CREATED_DT = "created_dt";
        public static final String MODIFIED_BY = "modified_by";
        public static final String MODIFIED_DT = "modified_dt";
    }
    
    public static abstract class DBGROUPCONTACTS implements BaseColumns {
    	public static final String TABLE = "groupcontacts";
    	public static final String ID = "_id";
    	public static final String GROUPID = "groupid";
    	public static final String CONTACTID = "contactid";
    	public static final String CREATED_BY = "created_by";
        public static final String CREATED_DT = "created_dt";
        public static final String MODIFIED_BY = "modified_by";
        public static final String MODIFIED_DT = "modified_dt";
    }
    
    public static abstract class DBEXPENSE implements BaseColumns {
    	public static final String TABLE = "expensemaster";
    	public static final String ID = "_id";
    	public static final String GROUPID = "groupid";
    	public static final String EXPENSENAME = "name";
    	public static final String CATEGORYID = "categoryid";
    	public static final String AMOUNT = "amount";
    	public static final String EXPENSEDATE = "expensedate";
    	public static final String NOTES = "notes";
    	public static final String EXPENSETYPEID = "expensetypeid";
    	public static final String CREATED_BY = "created_by";
        public static final String CREATED_DT = "created_dt";
        public static final String MODIFIED_BY = "modified_by";
        public static final String MODIFIED_DT = "modified_dt";
    }
    
   public static abstract class DBEXPENSEPAID implements BaseColumns {
    	public static final String TABLE = "expensepaid";
    	public static final String ID = "_id";
    	public static final String CONTACTID = "contactid";
    	public static final String EXPENSEID = "expenseid";
    	public static final String AMOUNT = "amount";
    	public static final String CREATED_BY = "created_by";
        public static final String CREATED_DT = "created_dt";
        public static final String MODIFIED_BY = "modified_by";
        public static final String MODIFIED_DT = "modified_dt";
    }
    
   public static abstract class DBEXPENSEDISTRIBUTION implements BaseColumns {
    	public static final String TABLE = "expensedistribution";
    	public static final String ID = "_id";
    	public static final String CONTACTID = "contactid";
    	public static final String EXPENSEID = "expenseid";
    	public static final String AMOUNT = "amount";
    	public static final String DISTRIBUTIONTYPE = "distributiontype";
    	public static final String CREATED_BY = "created_by";
        public static final String CREATED_DT = "created_dt";
        public static final String MODIFIED_BY = "modified_by";
        public static final String MODIFIED_DT = "modified_dt";
    }
    


    /**
     * DataBase type
     */
    public static abstract class DBTYPE {
        public static final String BLOB                     = " BLOB";
        public static final String INTEGER                     = " INTEGER";
        public static final String INTEGER_PRIMARY_KEY         = " INTEGER PRIMARY KEY";
        public static final String NULL                     = " NULL";
        public static final String REAL                     = " REAL";
        public static final String TEXT                     = " TEXT";
        public static final String COMMA                     = ", ";
        public static final String PARENTHESIS_OPEN         = " (";
        public static final String PARENTHESIS_CLOSE         = " )";
        public static final String CREATE_TABLE             = "CREATE TABLE ";
        public static final String DROP_TABLE_IF_EXISTS     = "DROP TABLE IF EXISTS ";
    }

}
