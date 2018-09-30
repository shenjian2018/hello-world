								javax.ws.rs Webservice
1.路径
@javax.ws.rs.Path
标识要请求的资源类或资源方法的uri路径。
@Path("{species}")这种带大括号的表示方法，表示下一层路径会被参数化，配合@PathParam("species")使用可以赋值给函数的参数。	
	
2.从报文数据到方法参数
@javax.ws.rs.PathParam
将uri中指定的路径参数绑定到资源方法参数，资源类的字段，或资源类的bean属性。	

@javax.ws.rs.QueryParam
将http请求的Query参数赋值给函数的参数

@javax.ws.rs.FormParam
将http请求的Form表单中的参数赋值给函数的参数。

@avax.ws.rs.Context

用于获取环境信息。

3.http方法
@javax.ws.rs.GET
表示此方法响应一个HTTP GET请求。
@javax.ws.rs.POST
表示此方法响应一个HTTP POST请求。
@javax.ws.rs.PUT
通常用来更新数据。
@javax.ws.rs.DELETE
通常用来删除数据。

4.返回数据类型
@javax.ws.rs.Produces
设置Http返回报文，报文体的内容类型。
取值为 javax.ws.rs.core.MediaType.XXX。常用的有：

MediaType.APPLICATION_JSON
##发送到Client 格式字符串
MediaType.TEXT_PLAIN			