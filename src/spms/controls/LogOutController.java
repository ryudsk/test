package spms.controls;

import java.util.Map;

public class LogOutController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
//		model.clear();
		return "redirect:../auth/LogInForm.jsp";
	}
}