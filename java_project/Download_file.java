import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Download_file
{
	private String file;
	public String getFileLocation()
	{
		return file;
	}
	public void setFileLocation(String file_name)
	{
		this.file = file_name;
	}
	public String file_download()
	{
		int length = file.length();
		String temp = "";
		String temp2 = "";
		int count = 0;
		for(int i = length-1 ; i>=0 ; i--)
		{
			if(file.charAt(i) == '.')
			{
				count++;
				if(count<2)
				{
					temp = temp + file.charAt(i);
				}
			}
		}
		int length2 = temp.length();
		for(int j = length2-1 ; j>=0 ; j--)
		{
			temp2 = temp2 + temp.charAt(j);
		}
		return temp2;
	}
}