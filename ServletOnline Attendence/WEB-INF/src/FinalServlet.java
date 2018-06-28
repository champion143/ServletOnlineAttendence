import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FinalServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    String fid=request.getParameter("fid");
		String fpassword=request.getParameter("fpassword");
		String sql="select FID,FPASSWORD from FACULTYTABLE";
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
	    	   String id = rs.getString(1);
               String password = rs.getString(2); 
		       if(id.equals(fid) && password.equals(fpassword))
		 	   { 
		        System.out.println("password right");
		        RequestDispatcher rd=request.getRequestDispatcher("FinalServlet2");  
                rd.forward(request, response);	
			   }
	           else 
			   {
			   System.out.println("wrong password");
	     	   System.out.println("exit");	
			   response.sendRedirect("wrong.html");
			   }
			}
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