# Advanced Programmer Guide

## 项目目录

- 00-Java-Core : Java 核心内容
    - core00_basic : Java 基础知识
        - Java 修饰符
        - 语法知识
        - 基本数据类型
    - core01_oop : Java 面向对象
        - 类与对象
        - 封装
        - 继承
        - 多态
        - 抽象类
        - 接口
        - 内部类
        - final
        - static
        - this 对象
    - core02_api : 常用 API
        - Object
        - Scanner
        - String
        - Arrays
        - StringBuffer
        - StringBuilder
        - Random
        - System
        - Date
        - DateFormate
        - LocalDate
        - Calender
    - core03_collection : Java 集合
    - core04_io : Java IO 流
        - File
        - FileWriter
        - FileReader
        - OutputStream
        - InputStream
        - OutputStreamWriter
        - InputStreamReader
        - BufferedReader
        - BufferedWriter
        - BufferedInputStream
        - BufferedOutputStream
- 01-Java-8-Action: Java8 实战
- 02-Java-Concurrency: Java 并发编程
- 03-Spring-Framework: Spring 框架
- 04-Spring-Boot
- 05-Spring-Cloud
- 06-Data-Structure-Algorithm

## 面试题整理

### Java 基础知识

#### 1. Exception 和 Error
> 1. 都继承 Throwable 类，只有 Throwable 类型的实例才可以被抛出（throw）或（catch）
>
> 2. Exception 是程序正常运行中可以预料的意外情况
> 3. Error 则是会导致程序处于非正常、不可恢复状态，比如 OutOfMemoryError，StackOverflowError，NoClassDefFoundError
> 4. 可检查 Exception 在代码中必须显式的进行捕获处理，编译期会检查
> 5. 不可检查的 Exception, 比如 NullPointerException、ArrayIndexOutOfBoundsException、ClassNotFoundException

#### 2. NoClassDefFoundError 和 ClassNotFoundException

#### 3. final、finally、finalize
> 1. final

### Java 进阶知识