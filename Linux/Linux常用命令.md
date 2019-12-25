# 常用命令

## 1.网络相关

* 查询端口是否被占用：netstat -anp | grep 端口号

  只有看见tcp + 端口号 + LISTEN（状态）才表示被占用

* 查看当前已经使用的所有端口的情况：netstat -nultp

## 2. 文件解压

### .tar 文件

~~~tex
# 仅打包，并非压缩
tar -xvf FileName.tar         # 解包
tar -cvf FileName.tar DirName # 将DirName和其下所有文件（夹）打包
~~~

### .gz 文件

~~~tex
# .gz
gunzip FileName.gz  # 解压1
gzip -d FileName.gz # 解压2
gzip FileName       # 压缩，只能压缩文件
~~~

### .tar.gz文件、 .tgz文件

~~~tex
# .tar.gz 和 .tgz
tar -zxvf FileName.tar.gz               # 解压
tar -zcvf FileName.tar.gz DirName       # 将DirName和其下所有文件（夹）压缩
tar -C DesDirName -zxvf FileName.tar.gz # 解压到目标路径
~~~

### .zip 文件

~~~tex
# 感觉.zip占用空间比.tar.gz大
unzip FileName.zip          # 解压
zip FileName.zip DirName    # 将DirName本身压缩
zip -r FileName.zip DirName # 压缩，递归处理，将指定目录下的所有文件和子目录一并压缩
~~~

### .rar 文件

~~~tex
# mac和linux并没有自带rar，需要去下载
rar x FileName.rar      # 解压
rar a FileName.rar DirName # 压缩
~~~

## 3. 定时任务

[链接1](https://www.jianshu.com/p/d6d8d9f7f60c)：

## 4. 自动删除 n 天前的日志文件

[链接1：](https://www.jb51.net/article/148580.htm)

