package com.ecaresoft.cumulus.helpers;

import android.provider.BaseColumns;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class Table {

    public Table(){}
    public static abstract class TableInfo implements BaseColumns {
        public static final String db_name="cumulus_user";
        public static final String table_name="users";
        public static final String id_user = "id_user";
        public static final String user="user";
        public static final String password = "password";
    }
}
