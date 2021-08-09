import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.User;

public class ListReceivedMessageController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form ��û���� redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		String message_no = request.getParameter("message_no");

		List<Message> MessageList = null;
    	try {
    		MessageList = manager.findScrap(message_no);	// ��ũ�� �˻�
		} catch (UserNotFoundException e) {				
	        return "/user/myPage/message/list.jsp";
		}	
    }
}


