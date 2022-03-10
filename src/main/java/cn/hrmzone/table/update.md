# 表格图片识别
> 距离第一次发布有很久时间了，最近的图片里有一些是分数一分一段线图片，原来的通用识别无法完成任务：输出只有一列数据。今天重新新增加了一个小功能：识别图片中的表格，然后输出为excel表格。

## 变化
1. 项目改为maven，自动引入依赖，无需手动下载和导入依赖的jar包（手动导入jar包太麻烦了）
2. 新增一个cn.hrmzone.table包，新增功能在此包下实现，代码的两个java类文件均在这里。
3. 原DocOcr功能没有变，也没有重新输出jar包

## 思路
1. TableOcr类：解析图片表格内容；
   1. 使用百度OCR表格同步识别接口，这个接口默认在百度里没有选中，需要在百度AI平台上打开，一般需要2个小时左右才能开通使用；
   2. 接口返回的是json格式内容，需要自己解析，json内容比较过，可以在网上找一个json格式化的工具查看，然后逐步解析；
   3. json解析，就是一个不断在jsonobject和jsonarray不断解析的过程；
   4. json的内容包含了内容的坐标和row、col内容，根据row和col进行表格填充。
2. ExcelUtil类：将解析内容填充至Excel文件；
   1. 使用Apache 的POI进行Excel操作
   2. poi进行操作单元格时，是先创建行，然后在行内进行单元格内容填充，但是json返回数据单个内容，因此需要先获取相应的row，然后再操作（如果没有对应行，则创建一个）。
3. FileNamePraser类：将图片文件名解析出路径和文件名（不含扩展名），用于给excel命名。
4. TableTest类：用例测试类



## 效果图

百度AI的识别结果还是不错的，就是靠近表格边框的“1”无法准确识别

表格图片

![解析前图片](https://github.com/hrmzone/DocOCR/raw/master/imgs/0001.jpg)



解析后Excel内容

![解析后excel](https://github.com/hrmzone/DocOCR/raw/master/screenshot/5.jpg)