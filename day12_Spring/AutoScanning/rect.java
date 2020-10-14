package mypack;

import org.springframework.stereotype.Component;

@Component  (value="rect")
public class rect implements shape{
	public void draw() {
		System.out.println("in rect draw method");
	}

}
