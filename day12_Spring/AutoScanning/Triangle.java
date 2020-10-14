package mypack;

import org.springframework.stereotype.Component;

@Component (value="Triangle")
public class Triangle implements shape{
	public void draw() {
		System.out.println("in Triangles draw method");
	}

}
