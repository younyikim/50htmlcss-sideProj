package controller.message;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.User;


public class DeleteMessageController implements Controller{
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
	    	// �α��� ���� Ȯ��
	    	if (!UserSessionUtils.hasLogined(request.getSession())) {
	            return "redirect:/user/login/form";		// login form ��û���� redirect
	        }
	    	
	 int selectedMessage = request.getParameter("message_no");
		
		try {
			// �𵨿� �α��� ó���� ����
			UserManager manager = UserManager.getInstance();
			manager.deleteMessage(selectedMessage);
         
			return "redirect:/user/myPage/message/list";			
		} catch (Exception e) {
			/* ������ �ȵǸ� 
			 * �ٽ� messagelist�� fowarding�ϰ� ���� �޼����� ���
			 */
         request.setAttribute("Failed", true);
			request.setAttribute("exception", e);
         return "/user/myPage/message/list.jsp";			
		}	
	 }
}
