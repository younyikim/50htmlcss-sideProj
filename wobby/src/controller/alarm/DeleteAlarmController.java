package controller.alarm;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.UserManager;


public class DeleteAlarmController implements Controller{
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
	    	// �α��� ���� Ȯ��
	    	if (!UserSessionUtils.hasLogined(request.getSession())) {
	            return "redirect:/user/login/form";		// login form ��û���� redirect
	        }
	    	
	 String selectedAlarm = request.getParameter("alarmlist_no");
		
		try {
			// �𵨿� �α��� ó���� ����
			UserManager manager = UserManager.getInstance();
			manager.alarmDelete(selectedAlarm);
         
			return "redirect:/user/myPage/Alarm/list";			
		} catch (Exception e) {
			/* ������ �ȵǸ� 
			 * �ٽ� alarmlist�� fowarding�ϰ� ���� �޼����� ���
			 */
         request.setAttribute("Failed", true);
			request.setAttribute("exception", e);
         return "/user/myPage/Alarm/list.jsp";			
		}	
}
