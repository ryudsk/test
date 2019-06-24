package spms.listeners;

//import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//import javax.sql.DataSource;

import context.ApplicationContext;
//import spms.controls.LogInController;
//import spms.controls.LogOutController;
//import spms.controls.MemberAddController;
//import spms.controls.MemberDeleteController;
//import spms.controls.MemberListController;
//import spms.controls.MemberUpdateController;
//import spms.dao.MySqlMemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
			
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			applicationContext = new ApplicationContext(propertiesPath);
			
/*			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/studydb"); //JDBC(java:comp/env)
			
			MySqlMemberDao memberDao = new MySqlMemberDao(); //Dao생성
			memberDao.setDataSource(ds); //3.DataSource 주입
			
//			sc.setAttribute("memberDao", memberDao);
			
			sc.setAttribute("/auth/login.do", new LogInController().setMemberDao(memberDao));
			sc.setAttribute("/auth/loginout.do", new LogOutController());
			sc.setAttribute("/member/list.do", new MemberListController().setMemberDao(memberDao));
			sc.setAttribute("/member/add.do", new MemberAddController().setMemberDao(memberDao));
			sc.setAttribute("/member/update.do", new MemberUpdateController().setMemberDao(memberDao));
			sc.setAttribute("/member/delete.do", new MemberDeleteController().setMemberDao(memberDao));
*/			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//4.DataSource사용-톰캣서버에서 자동해제하기 때문(context.xml)
	}
	
}
