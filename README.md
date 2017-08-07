![](images/icon.png)

HenCoder 绘制 4 练习项目
===

### 这是什么？

这不是一个独立使用的项目，它是 [HenCoder Android 开发进阶：UI 1-4 绘制的辅助](http://hencoder.com/ui-1-4) 的配套练习项目。

### 怎么用？

项目是一个可以直接运行的 Android App 项目，项目运行后，在手机上打开是这样的：

![](images/preview.png)

工程下有一个 `/practice` 目录：

![](images/project_practice.png)

你要做的是就是，在 `/practice` 下的每一个 `PracticeXxxView.java` 文件中写代码，绘制出和页面上半部分相同的效果。例如写 `Practice01ClipRectView.java` 以绘制出经过平移的图形。就像这样：

![](images/preview_after.png)

> 当然，没必要做得和示例一毛一样。这是一个练习，而不是一个超级模仿秀，关键是把技能掌握。

如果做不出来，可以参考 `/sample` 目录下的代码：

![](images/project_sample.png)

练习做完，绘制第四期（绘制的辅助）的内容也就掌握得差不多了。

### 作业效果

首先完成了所有的作业，但是对原视频中提出的 canvas 的绘制顺序是倒叙的这一点提出了质疑，所以添加了一个新的 sample 和 practice 。我的本意是对 bitmap 向右平移之后再旋转，按照视频中的做法，代码如下

```java
Point point1 = new Point(200, 200);
canvas.save();
canvas.rotate(90, point1.x + bitmap.getWidth()/2, point1.y + bitmap.getHeight()/2);
canvas.translate(200, 0);
canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
canvas.restore();
```

所以我在 sample 中使用了上述的写法。而在 practice 中使用了如下的写法

```java
Point point1 = new Point(200, 200);
canvas.save();
canvas.translate(200, 0);
canvas.rotate(90, point1.x + bitmap.getWidth()/2, point1.y + bitmap.getHeight()/2);
canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
canvas.restore();
```

结果如下图

![rotate-and-translate](images/rotate-and-translate.jpg)

可以看到 practice 中的写法得到了正确的结果。按照我的理解，首先对 canvas 平移了之后，坐标系会跟着平移，然后进行画图，旋转是没毛病的。如果先旋转的话，坐标系会顺时针旋转90度，对 bitmap 进行 x 轴的平移的时候，给人的视觉感受就会是向下移动了。