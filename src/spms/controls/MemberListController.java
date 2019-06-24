package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.MySqlMemberDao;

@Component(value="/member/list.do")
public class MemberListController implements Controller {
	
	//의존객체 주입(DI) 인스턴스 변수와 셋터 메소드
	//
	MySqlMemberDao memberDao;
	public MemberListController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
//		MemberDao memberDao = (MemberDao)model.get("memberDao");
		model.put("members",memberDao.selectList());
		return "/member/MemberList.jsp";
	}
}