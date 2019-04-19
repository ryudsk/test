package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.vo.Member;

public class LogInController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Member loginUser = (Member)model.get("loginUser");
		MemberDao memberDao = (MemberDao)model.get("memberDao");
		
//		if(model.get("loginUser") == null) { //맵에서 객체 여부 체크가 아
		if(loginUser.getEmail() == null) { //
			return "/auth/LogInForm.jsp";
		}
		else {
//			Member loginUser = (Member)model.get("loginUser");
			Member member = memberDao.exist(loginUser.getEmail(),loginUser.getPassword());
			
			if(member != null) {
//				model.put("member", member);
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", member);
				return "redirect:../member/list.do";
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	}
}