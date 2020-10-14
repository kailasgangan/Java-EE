package mypack;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class StudentDAOFileImpl implements StudentDAO
{
    public void addStudent(Student s)
    {
    	try(FileOutputStream fos=new FileOutputStream("E:\\hibernateassign3.txt");)
    	{
    	     ObjectOutputStream oos=new ObjectOutputStream(fos);
    	     oos.writeObject(s);
    	}
    	catch(Exception e)
    	{e.printStackTrace();}
    }
}
