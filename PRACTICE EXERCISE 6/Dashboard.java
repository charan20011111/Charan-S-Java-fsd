package com.Dashboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = null;
        Cookie[] cookies = null;
        boolean found = false;
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        cookies = request.getCookies();
        if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().contentEquals("userid") && cookie.getValue() != null) {
                    out.println("UserId read from cookie:" + cookie.getValue() + "<br>");
                    found = true;
                }
             }
        }
        if (!found) {
            out.println("No UserId was found in cookie.<br>");
        }
        out.println("</body></html>");

    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
