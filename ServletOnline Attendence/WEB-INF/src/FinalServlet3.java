import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FinalServlet3 extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{   
	    int i;
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String []names = request.getParameterValues("names");
		for(i=0;i<names.length;i++)
		System.out.println(names[i]);
	    System.out.println("not again");
		try
		{
		    Class.forName("oracle.jdbc.driver.OracleDriver"); 
            System.out.println("driver loaded");	 
            Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE","system","tiger");  
            System.out.println("connection established");	
            PreparedStatement ps = con.prepareStatement("update STUDENTTABLE set ATTENDENCE=ATTENDENCE+1 WHERE SNAME=?");
            System.out.println("fun lost");			
            int j=0;			
			while(j<names.length)
			{
		    ps.setString(1,names[j]);
			ps.executeUpdate();
			j++;
			}
		 //   int m=ps.executeUpdate();
          //   System.out.println(m);
		//	if(m>0)
		    response.sendRedirect("welcome.html");		
		  
		}
		
		catch(SQLException e)
		{System.out.println(e);}
		catch(ClassNotFoundException e)
		{System.out.println(e);}
		finally
		{
			pw.close();
		}
		
	}
}