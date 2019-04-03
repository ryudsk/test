package spms.listeners;

import javax.naming.InitialContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import spms.dao.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
			
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/studydb"); //JDBC(java:comp/env)
			
			MemberDao memberDao = new MemberDao(); //Dao생성
			memberDao.setDataSource(ds); //3.DataSource 주입
			
			sc.setAttribute("memberDao", memberDao);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//4.DataSource사용-톰캣서버에서 자동해제하기 때문(context.xml)
	}
}
