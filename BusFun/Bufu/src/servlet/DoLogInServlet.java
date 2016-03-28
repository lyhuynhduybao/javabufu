package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cores.Students;
import utils.*;

/**
 * Servlet implementation class DoLogInServlet
 */
@WebServlet(urlPatterns={"/doLogin"})
public class DoLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLogInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String rememberMe = request.getParameter("rememberMe");
			boolean remember = "Y".equals(rememberMe);

			Students user = null;
			boolean hasError = false;
			String errorString = null;
			if (userName == null || password == null
					|| userName.length() == 0 || password.length() == 0) {
				hasError = true;
				errorString = "Required username and password!";
				response.getWriter().append("Served at: ").append(request.getContextPath());
			}
			else{
				Connection conn = MyUtils.getStoredConnection(request);
				try {
					// Tìm user trong DB.
					user = DBUtils.findUser(conn, userName, password);
					
					if (user == null) {
						hasError = true;
						errorString = "User Name or password invalid";
					}
				} catch (SQLException e) {
					e.printStackTrace();
					hasError = true;
					errorString = e.getMessage();
				}
			}
			//Nếu có lỗi thì chuyển hướng trang về trang WEB-INF/views/loginView.jsp
			if (hasError) {
				user = new Students();
				user.setUserName(userName);
				user.setPassword(password);

				// Ghi các thông tin vào request trước khi forward.
				request.setAttribute("errorString", errorString);
				request.setAttribute("user", user);

				// Chuyển tiếp tới trang /WEB-INF/views/loginView.jsp
				RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/views/logInView.jsp");

				dispatcher.forward(request, response);
			}
			// Trường hợp không có lỗi.
			// Lưu thông tin người dùng vào Session.
			// Và chuyển hướng sang trang userInfo.
			else {
				
				HttpSession session = request.getSession();
				MyUtils.storeLoginedUser(session, user);
			}
			 // Nếu người dùng chọn lưu thông tin đăng nhập vào Cookie
	        if(remember)  {
	            MyUtils.storeUserCookie(response,user);
	        }
	        // Ngược lại xóa Cookie
	        else  {
	            MyUtils.deleteUserCookie(response);
	        }            
	        // Rồi chuyển hướng sang trang /userInfo.
	        response.sendRedirect(request.getContextPath() + "/userInfo");
	       /* RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");    
	        rd.forward(request,response);*/
		}

	}
