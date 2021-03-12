# 自定义表格
#### 效果图：

<img src="https://img-blog.csdnimg.cn/20210311153420669.jpg"  height="700" width="330">

#### 自适应字体宽度高度，满足单多排表格

#### 主要的技术点
##### 1、其中文字部分解决了 Android 中文字换行不对齐的问题，在 AutoSplitTextView 中，将文字拆分，计算排列的宽度。
##### 2、表格的排列，每增加一行表格，新添加 LinearLayout ，再在其中添加文字，需要计算每行中最高的文字高度，统一该行表格的高度。


#### 使用
```
//初始化屏幕宽度
TableView.initWidth(getWindowWidth(this))
TableView.addTables(tables1,tables2...)
```
