package AppProduce;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsm.produce.ProduceSevice;

public class ProduceTest {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("produce.xml");
		ProduceSevice sevice = context.getBean(ProduceSevice.class);
		for (int i = 0; i < 10; i++) {
			sevice.sendMessage("test" + i);
		}
		context.close();
	}
}
