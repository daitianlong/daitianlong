# daitianlong
daitianlong
demo项目整体架构
1，采用的redispool 连接以及连接回收
springboot redis demo
2,集成Mybatis
备注：
a:连接数据库驱动与需要数据库版本基本一致
b:连接数据库和系统时区差的原因：需要在连接数据库连接上加上：useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC
c:该项目使用mysql版本8.0.16