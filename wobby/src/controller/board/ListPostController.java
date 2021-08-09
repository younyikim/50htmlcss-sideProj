package controller.board;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.CommunityManager;
import service.dto.PostDTO;

public class ListPostController implements Controller {
    @SuppressWarnings("unchecked")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        CommunityManager commManager = CommunityManager.getInstance();
        List<PostDTO> postList = (List<PostDTO>) request.getAttribute("postList");
        List<PostDTO> popularPostList = null;
        
        if (postList == null) { //null일경우, 즉 검색 / 매칭이 아닐경우
            int boardId = Integer.parseInt(request.getParameter("boardId"));
            System.out.println("boardId : " + boardId);
            postList = commManager.findPostList(boardId);
            popularPostList = commManager.findPopularPostList(boardId);
            request.setAttribute("popularPostList", popularPostList);
            
            // commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
            request.setAttribute("postList", postList); 

            return "/board/boardList.jsp?boardId=" + boardId ;   
        }

		request.setAttribute("postList", postList);	
		String keyword = request.getParameter("keyword");
		return "/board/boardList.jsp?search=" + keyword ;     
    } 
}
