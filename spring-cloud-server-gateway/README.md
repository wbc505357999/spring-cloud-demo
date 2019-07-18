# 使用Nacos实现动态路由
### 查看所有的路由：http://localhost:8080/actuator/gateway/routes
 示例JSON配置
```json
{
	"filters": [],
	"id": "jd_route",
	"order": 0,
	"predicates": [{
		"args": {
			"pattern": "/jd"
		},
		"name": "Path"
	}],
	"uri": "http://www.jd.com"
}
```
```json
[
    {
        "filters": [],
        "id": "blog",
        "order": 0,
        "predicates": [
            {
                "args": {
                    "pattern": "/z"
                },
                "name": "Path"
            }
        ],
        "uri": "https://blog.csdn.net/zhangchangbin123"
    },
    {
        "filters": [],
        "id": "blog1",
        "order": 0,
        "predicates": [
            {
                "args": {
                    "pattern": "/c"
                },
                "name": "Path"
            }
        ],
        "uri": "https://blog.csdn.net/zhangchangbin123"
    }
]
```
