				RabbitMQ
RabbitMQ起步
	RabbitMQ是一个开源的消息代理和队列服务器
	用来通过普通协议在完全不同的应用之间共享数据
	RabbitMQ是使用Erlang语言来编写的
	并且RabbitMQ是基于AMQP(统一消息服务的应用层标准高级消息队列协议)协议的
	开源、性能优秀，稳定性保障
	与SpringAMQP完美的整合、API丰富
	集群模式丰富，表达式配置，HA模式，镜像队列模型
	保证数据不丢失的前提做到高可靠性、可用性
	AMQP全称：Advanced Message Queuing Protocol
	AMQP翻译：高级消息队列协议

	RabbitMQ核心概念
	Server：又称Broker，接受客户端的连接，实现AMQP实体服务
	Connection：连接，应用程序与Broker的网络连接
	Channel：网络信道
		几乎所有的操作都在Channel中进行
		Channel是进行消息读写的通道
		客户端可建立多个Channel
		每个Channel代表一个会话任务
	Message：消息
		服务器和应用程序之间传送的数据，由Properties和Body组成
		Properties可以对消息进行修饰，比如消息的优先级、延迟等高级特性
		Body则就是消息体内容
	Virtual host：虚拟机
		用于进行逻辑隔离，最上层的消息路由
		一个Virtual host里面可以有若干个Exchange和Queue
		同一个Virtual host里面不能有相同名称的Exchange或Queue	
	Exchange：交换机，接收消息，根据路由键转发消息到绑定的队列
	Binding：Exchange和Queue之间的虚拟连接，binding中可以包含routing key
	Routing key：一个路由规则，虚拟机可用它来确定如何路由一个特定消息
	Queue：也称为Message Queue，消息队列，保存消息并将它们转发给消费者
RabbitMQ使用
	# RabbitMQ连接配置
	spring.rabbitmq.addresses=192.168.0.105:5672
	spring.rabbitmq.username=guest
	spring.rabbitmq.password=guest
	spring.rabbitmq.virtual-host=/
	spring.rabbitmq.connection-timeout=15000
	# RabbitMQ消费配置
	# 基本并发：5
	spring.rabbitmq.listener.simple.concurrency=5
	# 最大并发：10
	spring.rabbitmq.listener.simple.max-concurrency=10
	# 签收模式：手动签收
	spring.rabbitmq.listener.simple.acknowledge-mode=manual
	# 限流策略：同一时间只有1条消息发送过来消费
	spring.rabbitmq.listener.simple.prefetch=1

	# Server配置
	server.servlet.context-path=/
	server.port=8082

	spring.http.encoding.charset=UTF-8
	spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
	spring.jackson.time-zone=GMT+8
	spring.jackson.default-property-inclusion=NON_NULL
	
