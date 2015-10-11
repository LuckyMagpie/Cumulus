package com.ecaresoft.cumulus.helpers.database;

import android.provider.BaseColumns;

/**
 * Created by juanortizjr on 9/10/15.
 */
public class Table {
    public static final String db_name = "cumulus_db";

    public static abstract class Users implements BaseColumns {
        public static final String table_name = "users";
        public static final String user_id = "user_id";
        public static final String username = "username";
        public static final String password = "password";
        public static final String active = "active";
        public static final String curp = "curp";
    }

    public static abstract class Sections implements BaseColumns {
        public static final String table_name = "section";
        public static final String user_id = "user_id";
        public static final String section_id = "section_id";
        public static final String content = "content";
    }
}
