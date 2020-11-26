# JVM探究

## 面试问题

1.谈谈对JVM的理解？java8虚拟机和之前的变化更新

2.什么事OOM,栈溢出StackOverFlowError?怎么分析

3.JVM常用调优参数有哪些？

4.内存快照 如何抓取？怎么分析Dunp文件？

5.谈谈JVM类加载器？rt-jar ext application



1.JVM的位置

​	

2.JVM的体系结构

3.类加载器

​	作用：加载class文件

![image-20201027222242329](C:\Users\asusxy\AppData\Roaming\Typora\typora-user-images\image-20201027222242329.png)



加载器:

1:虚拟机自带的加载器

2：启动类（根）加载器

3：扩展类加载器

4：应用程序加载器

5：





4.双亲委派机制

为了安全

APP加载器-->ext加载器-->boot(最终执行)

5.沙箱安全机制

6.native

7.PC寄存区

8.方法区

9.栈

10.三种JVM，可通过 java-version命令查看，一般为Hotspot

11.堆

12.新生区

13.老年区

14.永久区

15.堆内存调优

16.GC

​	1.常用算法

17.JMM

18.总结