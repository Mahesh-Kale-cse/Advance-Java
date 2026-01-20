package Com.AOP.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = { "Com.AOP" })
@EnableAspectJAutoProxy
public class MyConfigClass {

}