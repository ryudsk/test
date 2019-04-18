package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class LogInController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("loginUser") == null) {
			return "/auth/LogInForm.jsp";
		}
		else {
			MemberDao memberDao = (MemberDao)model.get("memberDao");
			Member loginUser = (Member)model.get("loginUser");
			Member member = memberDao.exist(loginUser.getEmail(),loginUser.getPassword());
			if(member != null) {
				model.put("member", member);
				return "redirect:../member/list.do";
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	}
}