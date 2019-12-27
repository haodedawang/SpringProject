# easydfs

#### 项目介绍
easydfs是基于minio作为文件存储，它只是在MinioClient上封装的一层Web应用作为文件服务器， 并且它(minio)支持分布式 ， 分布式配置可以查看这里：https://docs.minio.io

#### 软件架构
JDK8
Minio
SpringBoot


#### 安装教程
1. git clone easydfs  
2. mvn clean install -Dmaven.test.skip=true
3. 执行script/easydfs-start.bat （这个脚本为：Windows平台， Linux平台自己研究）

#### 使用说明

1. 打开postman访问 http://127.0.0.1:8001/easydfs/file/upload
   1.1 它有2个参数： 1. bucket 文件夹名称  2. file 文件。 上传成功返回： 后台自定义的文件名称
2. 下载接口： http://127.0.0.1:8001/easydfs/file/download/文件夹名称/返回的文件名