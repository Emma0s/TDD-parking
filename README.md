#ParkingLot
##停车场可以停车取车

Given 一个停车场有0个空位
When 一台汽车停车
Then 停车失败

Given 一个停车场有1个空位
When 一台汽车停车
Then 停车成功 返回一个凭证

Given 一个停车场有1个空位
When 2台汽车停车
Then 车1停车成功；车2停车失败  返回车1凭证

Given 一个停车场有2个空位
When 2台汽车停车
Then 车1停车成功；车2停车成功  返回2个凭证

Given 一个停车场0个凭证
When 取车
Then 取车失败 

Given 一个停车场1个凭证
When 取车
Then 取车成功 

Given 一个停车场假凭证
When 取车
Then 取车失败 

Given 一个停车场1个凭证
When 取两次车
Then 第一次成功，第二次失败

##作为一个初入职场的停车小弟，我能够将车顺序停放到多个停车场，并可以取出

Given 2个停车场，场1有1个空位，场2有0个空位
When 1台汽车停车
Then 停入场1成功 返回1个凭证

Given 2个停车场，场1有0个空位，场2有1个空位
When 1台汽车停车
Then 停入场2成功 返回1个凭证

Given 2个停车场，场1有1个空位，场2有1个空位
When 1台汽车停车
Then 停入场1成功

Given 2个停车场,场1有1个空位，场2有0个空位
When 2台汽车停车
Then 车1停车成功，车2停车失败

Given 2个停车场，1个真凭证
When 取车
Then 取车成功

Given 2个停车场，1个真凭证
When 取车2次
Then 第一次取车成功，第二次取车失败