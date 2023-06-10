package com.example;


public class App 
{
    public static void main( String[] args )
    {
        int n = 100; // Set the value of n as desired
        Database db = new Database(n);
        if(db.check_table_exist("primes") == false){
            db.createTable();
        }
        db.fill_table();
    }
}

