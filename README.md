>*a OCR tool for chinese documents.一个中文文档OCR工具.*

### 初衷
我是一职业培训机构[荆州青年教育平台](https://jzyouth.com)的老师，经常整理、打印各科目历年真题、预测题的试卷，但试卷只有纸质文件，没有电子版，所以做个小工具将试卷识别出来，整理为电子版，有需要的可以试试。

### 环境
Java要求:JDK7及以上；

### 原理
1.
使用百度AI的OCR接口，将指定文件、指定目录的图片文件上传，并将结果解析出来，保存为同名的TXT文本文件
2. 普通中文文档的识别率非常高，而且速度很快，比微软的Office lens正确率和速度快不少。
3. 百度OCR接口调用有次数限制，普通文字识别是50000次/天，需求大的同学请自行修改代码的API
   key，修改文件为：OCRAction.java。
4. 仅少量使用，可在release中下载DocOCR.jar，在命令行中使用。

### 使用方法
* 下载DocOCR.jar，在bash或命令行中进入该目录
* 识别单个文件:`java -jar -f filename`,`-f`识别单个图片文件

![SingleImg](https://github.com/hrmzone/DocOCR/blob/master/screenshot/1.png "识别单个图片文件")
*****

* 批量识别多个文件:`java -jar -d filepath`,`-d`识别目录下的全部图片

![MultiImg](https://github.com/hrmzone/DocOCR/blob/master/screenshot/3.png "批量识别多个图片文件")
*****

* 识别效果

![result](https://github.com/hrmzone/DocOCR/blob/master/screenshot/2.png "识别效果")
*****

* 错误提示

![error](https://github.com/hrmzone/DocOCR/blob/master/screenshot/4.png "错误提示")
*****

### 做个广告
>[荆州青年教育平台](https://jzyouth.com)，一所具备人社局许可的职业培训机构，专注于职业资格培训(人力资源管理师、中小学教师资格证)以及学历提升（成人教育、网络教育、自考），欢迎咨询，QQ:78049500 
