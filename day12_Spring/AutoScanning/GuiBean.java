package mypack;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component (value="Bean")
public class GuiBean {
	@Autowired
	@Qualifier("Triangle")
private shape shp;
public  void execute() {
	shp.draw();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory b=new ClassPathXmlApplicationContext("beancfg.xml");
		GuiBean g=(GuiBean)b.getBean("Bean");
		g.execute();
	}
}
