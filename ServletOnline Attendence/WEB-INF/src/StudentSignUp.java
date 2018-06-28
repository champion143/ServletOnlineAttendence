import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class StudentSignUp extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("sname");
		String id=request.getParameter("sid");
		String password=request.getParameter("spassword");	
		System.out.println("before sql");
		System.out.println("name="+name+"id="+id+"password="+password);
		String sql="insert into STUDENTTABLE values(?,?,?,?)";
		System.out.println("after sql");
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<form action='FirstPage.html' method='post'>");
		
		out.println("<input type='submit' value='ok'/>");
		try
		{   
  		    Class.forName("oracle.jdbc.driver.OracleDriver"); 
            System.out.println("driver loaded");	 
            Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE","system","tiger");  
            System.out.println("connection established");	   
	        PreparedStatement ps=con.prepareStatement(sql);
	        ps.setString(1,name);
			ps.setString(2,id);
			ps.setString(3,password);
			ps.setString(4,"0");
			ps.executeUpdate();
			out.println("</form></body>");
			out.println("</html>");
			out.println("you have registered successfully");
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