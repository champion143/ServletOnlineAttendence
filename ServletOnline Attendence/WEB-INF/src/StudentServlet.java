import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class StudentServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("hello");
		out.println("<html><head></head>");
		out.println("<body bgcolor='lightblue'>");
	    out.println("<form action='FirstPage.html' method='post'>");
		out.println("<table align='center' border='2'>");
		out.println("<tr><th>name</th><th>attendence</th></tr>");
		String sql="select SNAME , ATTENDENCE from STUDENTTABLE";
		try
		{
  		    Class.forName("oracle.jdbc.driver.OracleDriver"); 
            System.out.println("driver loaded");	 
            Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE","system","tiger");  
            System.out.println("connection established");	   
	        PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				String name=rs.getString(1);
				String att=rs.getString(2);
				out.println("<tr><th>"+name+"</th>");
				out.println("<th>"+att+"</th></tr>");
			}	
		   
		   out.println("<tr><th><input type='submit' value='close'/></th></tr>");
		   out.println("</table>");
           out.println("</form></body>");	
           out.println("</html>");		   
		}
		catch(SQLException e)
		{System.out.println(e);}
		catch(ClassNotFoundException e)
		{System.out.println(e);}
        finally
		 {
                 out.close();		
		 }		
		
	}
}