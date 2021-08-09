package controller.message;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.User;

public class ListSentMessageController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form ��û���� redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		String message_no = request.getParameter("message_no");

		List<Message> sentMessageList = null;
    	try {
    		MessageList = manager.findScrap(message_no);	
		} catch (UserNotFoundException e) {				
	        return "/user/myPage/message/SentMessagelist.jsp";
		}	
    }
}


