package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberUpdateController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		MemberDao memberDao = (MemberDao)model.get("memberDao");
		
		if(model.get("member") == null) {
			model.put("updateUser", memberDao.selectOne(Integer.parseInt((String)model.get("no"))));
			return "/member/MemberUpdateForm.jsp";
		}else {
			memberDao.update((Member)model.get("member"));
			return "redirect:list.do";
		}
	}

}
