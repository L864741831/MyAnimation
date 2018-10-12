在Android动画中，总共有两种类型的动画View Animation(视图动画)和Property Animator(属性动画)

    View Animation(视图动画)包括Tween Animation（补间动画）和Frame Animation(逐帧动画)；

    逐帧动画主要是用来实现动画的，而补间动画才能实现控件的渐入渐出、移动、旋转和缩放的

    Property Animator(属性动画)包括ValueAnimator和ObjectAnimation

1、引入时间不同：View Animation是API Level 1就引入的。Property Animation是API Level 11引入的，即Android 3.0才开始有Property Animation相关的API。 

2、所在包名不同：View Animation在包android.view.animation中。而Property Animation API在包 android.animation中。 

3、动画类的命名不同：View Animation中动画类取名都叫XXXXAnimation,而在Property Animator中动画类的取名则叫XXXXAnimator