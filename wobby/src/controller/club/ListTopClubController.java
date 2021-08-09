package controller.club;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.CommunityManager;
import service.dto.ClubDTO;

public class ListTopClubController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        CommunityManager commManager = CommunityManager.getInstance();
        List<ClubDTO> clubList = null;   
        
        String category = request.getParameter("category");
        clubList = commManager.findClubListbyCategory(category);
        
		// commList ��ü�� request�� �����Ͽ� Ŀ�´�Ƽ ����Ʈ ȭ������ �̵�(forwarding)
		request.setAttribute("clubList", clubList);				
		return "/community/club.jsp";        
    }
}
