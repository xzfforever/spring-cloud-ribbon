package com.xzf.spring.cloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	@Bean
	//@LoadBalanced：如果没有使用服务发现机制，不能加这个注解，否则调用不成功
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	/**
	 * 指定路由选择策略，可以配置为bean，也可以在配置文件中指定
	 * 在此处指定，是全局性的；在配置文件中可以基于服务提供方维度进行指定
	 * @return
	 */
/*	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}*/

}
