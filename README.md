# Algorithm(《算法》第四版)
这个项目保存我学习《算法》的练习代码和笔记。关于本书的更多资源可见[本书网站](https://algs4.cs.princeton.edu/home/)。

## 环境配置
《算法》提供了一个包含许多输入输出方法的[工具库](https://introcs.cs.princeton.edu/java/stdlib/)，可以减轻读者实现算法的负担，将精力放在算法的理解上。  

**配置步骤**：
1. 下载本书提供的工具库[algs4.jar](https://algs4.cs.princeton.edu/code/algs4.jar)
2. 安装[maven](https://maven.apache.org/)并配置环境变量。
3. 将工具库导入本地maven仓库:  
```mvn install:install-file -Dfile=<algs4.jar路径> -DgroupId=<edu.princeton.cs> -DartifactId=algs4 -Dversion=1.0.4 -Dpackaging=jar```
4. 新建maven项目并设置pom.xml添加依赖：  
```
<dependencies>
    <dependency>
      <groupId>edu.princeton.cs</groupId>
      <artifactId>algs4</artifactId>
      <version>1.0.4</version>
    </dependency>
  </dependencies>
```

## 目录
### ChapterⅠ: Fundamentals
+ [Basic Programming Model](src/main/java/chapter1/section1/)
+ [Data Abstraction](src/main/java/chapter1/section2/)
+ [Bags, Queues, and Stacks](src/main/java/chapter1/section3/)
+ [Analysis of Algorithm](src/main/java/chapter1/section4/)
+ [Case Study: Union-Find](src/main/java/chapter1/section5/)
### ChapterⅡ: Sorting
### ChapterⅢ: Searching
### ChapterⅣ: Graphs
### ChapterⅤ: Strings

