package com.Ajio;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dbconnection {
	
	public static void mani(String[] args) throws IOException, ClassNotFoundException, SQLException {
		 
		//jdbc-Java Database connection
		       Class.forName("com.microsoft.sqlserver");
		       String connectionString="ksmhwkb:9090//abcd;username=username;password=pass;trustedconnection=true";
		       Connection connection=DriverManager.getConnection(connectionString);
		       Statement statement=connection.createStatement();
		       ResultSet set=statement.executeQuery("select * tableName");
		       String s=set.getString(0);
		       
		
			}}

