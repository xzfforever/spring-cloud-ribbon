##Spring Cloud Ribbon
<li>Ribbon知识点<br/>
1、ribbon核心组件：<br/>
>1.1 Rule:从服务列表中如何获取一个有效的服务。
<pre>
RandomRule:随机规则
RoundRobinRule：轮询规则
WeightedResponseTimeRule：根据响应时间权重规则，响应时间越长权重越小
AvailabilityFilteringRule：可用性规则，如果服务不可用以一定的算法设置其状态（"circuit tripped"、"circuit closed"）。
</pre>
>1.2 Ping：判断服务是否可用<br/>
>1.3 ServerList：服务列表
<pre>
静态服务列表：BaseLoadBalancer.setServersList()
可配置的服务列表：<client-name>.ribbon.listOfServers
通过服务发现机制获取的服务列表:Eureka
</pre>

<li>Ribbon与Eureka结合使用架构图
![](https://raw.githubusercontent.com/xzfforever/images/master/ribbon/ribbon-eureka.jpg)







