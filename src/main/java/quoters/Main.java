package quoters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AplContext.xml");
         context.getBean(TerminaterQuoter.class).sayQuote();
    }
}
