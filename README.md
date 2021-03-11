# 自定义表格
#### 效果图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210311153420669.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poYW5nbGlf,size_16,color_FFFFFF,t_70#pic_center)
#### 自适应字体宽度高度，满足单多排表格

#### 主要的技术点
##### 1、其中文字部分解决了 Android 中文字换行不对齐的问题，在 SDAdaptiveTextView 中，将文字拆分，计算排列的宽度。
##### 2、表格的排列，每增加一行表格，新添加 LinearLayout ，再在其中添加文字，需要计算每行中最高的文字高度，统一该行表格的高度。


#### 使用
```
//初始化屏幕宽度
TableView.initWidth(getWindowWidth(this))
TableView.addTables(tables1,tables2...)
```
