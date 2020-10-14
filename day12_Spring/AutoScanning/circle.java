package mypack;

import org.springframework.stereotype.Component;

@Component  (value="circle")
public class circle implements shape{
	public void draw() {
		System.out.println("in circle draw method");
	}

}
