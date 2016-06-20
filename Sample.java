import java.sql.*;
import java.io.*;
import java.util.*;
public class Sample
{
 
    public static void main(String[] args) 
    {
 
        Connection con = null;
        int ch;
        int k=0;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "jaya";
        String driverName = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        Scanner sc=new Scanner(System.in);
        ResultSet rs;
        try 
        {
            Class.forName(driverName).newInstance();
            con = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = con.createStatement();
            
            do
            {
            	System.out.println("***MENU***");
            	System.out.println("1.Show Table");
            	System.out.println("2.Create View");
            	System.out.println("3.Insert into view");
            	System.out.println("4.Delete from view");
            	System.out.println("5.Update view");
            	System.out.println("6.Drop view");
            	System.out.println("7.show View Data");
            	System.out.println("8.Create complex view");
            	System.out.println("9.Create Index");
            	System.out.println("10.Drop Index");
            	System.out.println("11.Exit");
            	System.out.println("Enter your choice");
            	ch=Integer.parseInt(sc.next());
            	
            	switch(ch)
            	{
            		case 1:
            				System.out.println("***Displaying data from 										Table***");
            				rs=st.executeQuery("select * from 												Departments");
            				System.out.println("Dept_id\tDept_Name");
            				while(rs.next())
            				{
            					int s1=rs.getInt(1);
            					String s2=rs.getString(2);
            					System.out.println(s1+"\t"+s2);
            				}
            				break;
            		case 2:
            				System.out.println("***Creating the 												view***");
            				st.executeUpdate("create view dept1 as 									select * from Departments");
            				System.out.println("view is created!!!!!");
            				break;
            		
            		case 3:
            				System.out.println("***Insert into 													view***");
            				st.executeUpdate("insert into dept1 							values(7,'chemical'),(8,'production')");
            				System.out.println("Inserted Successfully");
            				break;
            			
            		case 4:
            				System.out.println("***Delete from 												view***");
            				st.executeUpdate("delete from dept1 where 									dept_id=7");
            				System.out.println("Deleted Successfully");
            				break;
            		
            		case 5:
            				System.out.println("***Update view***");
            				st.executeUpdate("update dept1 set 								dept_name='Instrumentation' where 												dept_id=8");
            				System.out.println("Updated Successfully");
            				break;
            			
            		case 6:
            				System.out.println("***Drop view***");
            				st.executeUpdate("drop view dept1");
            				System.out.println("view dropped 											Successfully");
            				break;
            			
            		case 7:
            				System.out.println("***Displaying data from 									View***");
            				rs=st.executeQuery("select * from dept1");
            				System.out.println("Dept_id\tDept_Name");
            				while(rs.next())
            				{
            					int s1=rs.getInt(1);
            					String s2=rs.getString(2);
            					System.out.println(s1+"\t"+s2);
            				}
            				break;
            		
            		case 8:
        					System.out.println("***Creating the complex 								view***");
        					st.executeUpdate("create view dept2 as 									select dept_id from Departments where 									dept_id=(select dept_id from Professors 									where prof_name='AAA')");
        					System.out.println("view is created!!!!!");
        					rs=st.executeQuery("select * from dept2");
            				System.out.println("Dept_id");
            				while(rs.next())
            				{
            					int s1=rs.getInt(1);
            					System.out.println(s1);
            				}
        					break;
            				
            		case 9:
            				System.out.println("***Creating Index***");
            				st.executeUpdate("create index indd on 							Departments(dept_id)");
            				System.out.println("Index created 									Successfully");
            				break;
            			
            		case 10:
            		
            				System.out.println("***Drop view***");
            				st.executeUpdate("alter table Departments 								drop index indd");
            				System.out.println("index dropped 											Successfully");
            	 			break;
            			
            		case 11:
            				System.exit(0);
            				break;
            			
            			
            	}
            	System.out.println("If you want to continue press 1");
            	k=Integer.parseInt(sc.next());
            	
            	
            }while(k==1);

            
            con.close();
            
            
        } 
       
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}


OUTPUT

***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
1
***Displaying data from Table***
Dept_id	Dept_Name
1	computer
2	IT
3	Electronics
4	Mech
5	Civil
6	Electrical
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
2
***Creating the view***
view is created!!!!!
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
3
***Insert into view***
Inserted Successfully
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
5
***Update view***
Updated Successfully
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
7
***Displaying data from View***
Dept_id	Dept_Name
1	computer
2	IT
3	Electronics
4	Mech
5	Civil
6	Electrical
7	chemical
8	Instrumentation
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
4
***Delete from view***
Deleted Successfully
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
7
***Displaying data from View***
Dept_id	Dept_Name
1	computer
2	IT
3	Electronics
4	Mech
5	Civil
6	Electrical
8	Instrumentation
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
6
***Drop view***
view dropped Successfully
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
8
***Creating the complex view***
view is created!!!!!
Dept_id
1
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
9
***Creating Index***
Index created Successfully
If you want to continue press 1
1
***MENU***
1.Show Table
2.Create View
3.Insert into view
4.Delete from view
5.Update view
6.Drop view
7.show View Data
8.Create complex view
9.Create Index
10.Drop Index
11.Exit
Enter your choice
10
***Drop view***
index dropped Successfully
If you want to continue press 1

0
