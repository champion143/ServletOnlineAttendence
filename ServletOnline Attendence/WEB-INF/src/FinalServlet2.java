import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FinalServlet2 extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>LoginServlet</title></head>");
        pw.println("<body bgcolor='lightgreen'>");
        pw.println("<form action='FinalServlet3' method='post'><table border='2'>");
	
		String sql="select SNAME from STUDENTTABLE";
		
		try
		{
		    Class.forName("oracle.jdbc.driver.OracleDriver"); 
            System.out.println("driver loaded");	 
            Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE","system","tiger");  
            System.out.println("connection established");	
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(sql);
			while(rs.next())
			{
		    	String s=rs.getString(1);
		        pw.println("<input type='checkbox' name='names' value='"+s+"'/>"+s+"</br>");
			}
			
			pw.println("</br></br><input type='submit' value='submit'/>");
			pw.println("</body>");
			pw.println("</html>");
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