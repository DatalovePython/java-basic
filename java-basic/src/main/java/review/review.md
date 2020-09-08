# java特性

1.java语言中，一律采用unicode编码，每个字符无论是中文还是英文，都是占用2个字节

2.Java的class文件编码为UTF-8，而虚拟机JVM编码为UTF-16，UTF-8编码下，一个中文占3个字节，一个英文占1个字节

3.实现国际化应用常用的手段是利用ResourceBundle类，ResourceBundle能够依据local的不同，选择性的读取local对应后缀的properties文件以达到国际化化的目的。

5.Java致力于检查程序在编译和运行时的错误。
6.Java自己操纵内存减少了内存出错的可能性

12.J2EE中常用的名词
EJB容器：Enterprise java bean 容器。更具有行业领域特色。他提供给运行在其中的组件EJB各种管理功能。只要满足J2EE规范的EJB放入该容器，马上就会被容器进行高效率的管理。并且可以通过现成的接口来获得系统级别的服务。例如邮件服务、事务管理。
JNDI：（Java Naming & Directory Interface）JAVA命名目录服务。主要提供的功能是：提供一个目录系，让其它各地的应用程序在其上面留下自己的索引，从而满足快速查找和定位分布式应用程序的功能。
JMS：（Java Message Service）JAVA消息服务。主要实现各个应用程序之间的通讯。包括点对点和广播。
JTA：（Java Transaction API）JAVA事务服务。提供各种分布式事务服务。应用程序只需调用其提供的接口即可。
JAF：（Java Action FrameWork）JAVA安全认证框架。提供一些安全控制方面的框架。让开发者通过各种部署和自定义实现自己的个性安全控制策略。
RMI/IIOP:（Remote Method Invocation /internet对象请求中介协议）他们主要用于通过远程调用服务。例如，远程有一台计算机上运行一个程序，它提供股票分析服务，我们可以在本地计算机上实现对其直接调用。当然这是要通过一定的规范才能在异构的系统之间进行通信。RMI是JAVA特有的。



1. java 8 中，ThreadLocalMap 中使用开放地址法来处理散列冲突，而HaspMap中使用的是分离链表法，之所以不同，是因为在ThreadLocalMap中散列支散的十分均匀，很少出现冲突，并且ThreadLocalMap经常需要清除无用的对象，使用纯数组更加方便。
2. ThreadLocalMap通过key（ThreadLocal类型）的hashcode来计算数组存储的索引位置i。如果i位置已经存储了对象，那么就往后挪一个位置依次类推，直到找到空的位置，再将对象存放。另外，在最后还需要判断一下当前的存储的对象个数是否已经超出了阈值（threshold的值）大小，如果超出了，需要重新扩充并将所有的对象重新计算位置。
3. 
4. 

# 面向对象

18.结论：

 引用数据类型是引用传递（call by reference），基本数据类型是值传递（call by value） 

1.值传递不可以改变原变量的内容和地址；

2.引用传递不可以改变原变量的地址，但可以改变原变量的内容；

~~~java
package test;

import java.util.Arrays;

public class A{
   public static void main(String[] args){
      int[] aa = {3, 2, 1};
      System.out.println(Arrays.toString(aa)); //[3, 2, 1]
      test(aa);
      System.out.println(Arrays.toString(aa)); //[3, 2, 1]
      test2(aa);
      System.out.println(Arrays.toString(aa)); //[4, 2, 1]
   }
 
   static void test(int[] a){
      a = new int[]{1, 2, 3};   //指向了新对象
   }
 
   static void test2(int[] a){
     if(a != null && a.length > 0)
       a[0]++;              //修改原来的那个对象
   }
}
~~~



1. Java 内部类

    ![img](https://uploadfiles.nowcoder.com/images/20180701/3807435_1530425536125_D49BCBCCF82CF58C566E12F1E3130070) 



# 异常

8.Error类体系描述了Java运行系统中的内部错误以及资源耗尽的情形，Error不需要捕捉

9.异常的继承结构：基类为Throwable，Error和Exception继承Throwable，RuntimeException和IOException等继承Exception
10.非RuntimeException一般是外部错误(非Error)，其必须被 try{}catch语句块所捕获

11.HashMap键值都可以为null，且其中的元素无序，HashMap的底层是由数组加链表实现的，对于每一个key值，都需要计算哈希值，然后通过哈希值来确定顺序，并不是按照加入顺序来存放的

# 反射

# 注解

# 泛型



16.泛型仅仅是java的语法糖，它不会影响java虚拟机生成的汇编代码，在编译阶段，虚拟机就会把泛型的类型擦除，还原成没有泛型的代码，顶多编译速度稍微慢一些，执行速度是完全没有什么区别的.

# 集合

7.程序设计语言中，数组元素在内存中是一个接着一个线性存放的，通过第一个元素就能访问随后的元素，这样的数组称之为“真数组”。
  实现了真数组为Java语言健壮性的特点之一。

# IO

# 日期与时间

# 单元测试

# 正则表达式

# 加密与安全

# 多线程

13.多进程里，子进程可获得父进程的所有堆和栈的数据；而线程会与同进程的其他线程共享数据，拥有自己的栈空间。
14.线程的通信速度更快，切换更快，因为他们在同一地址空间内。

17.线程各个状态间的切换

 ![img](https://uploadfiles.nowcoder.com/images/20180709/3807435_1531103859654_3658A873352D1D5FB9EF74D9F9F1F0B5) 

 wait 和 sleep的区别：
    wait指线程处于进入等待状态，形象地说明为“等待使用CPU”，此时线程不占用任何资源，不增加时间限制。
    sleep指线程被调用时，占着CPU不工作，形象地说明为“占着CPU睡觉”，此时，系统的CPU部分资源被占用，其他线程无法进入，会增加时间限制。 

# 网络编程

1. 客户端通过new Socket() 方法创建通信的Socket 对象，服务器端通过new ServerSocket（）创建TCP连接对象，accept接纳客户端请求。

   

# XML与JSON

# JDBC编程

# 函数编程

# 设计模式

15.java里氏替换原则：子类可以扩展父类的功能，但不能改变父类原有的功能
子类在继承父类是，尽量不去重写和重载父类的方法，为了减少之后代码出错的概率
子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
子类中可以增加自己特有的方法。
当子类的方法重载父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。
当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。



# web开发

# spring开发



















  

