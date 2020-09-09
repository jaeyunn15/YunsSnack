# YunsSnack (Custom Snackbar)

[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![YunsSnack](https://jitpack.io/v/jaeyunn15/YunsSnack.svg)](https://jitpack.io/#jaeyunn15/YunsSnack)

![Screenshot_1599631548](https://user-images.githubusercontent.com/55985789/92561523-548dd000-f2af-11ea-8f0c-a0e7ae935bf7.png)

###

### setting
Step 1. Add the JitPack repository to your build file. 
```gradle
allprojects {
    repositories {
      maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency.
```gradle
dependencies {
    implementation 'com.github.jaeyunn15:YunsSnack:0.1.2'
}
```

### usage

1. Init
```kotlin
val yunsSnack : YunsSnack = YunsSnack(this@MainActivity)
```

2. Set your own snackbar
```kotlin
yunsSnack.setListener(object : YunsSnackEventListener {
                override fun showedSnackBar() {
                    //event when snackbar showing
                }
                override fun stoppedSnackBar() {
                    //event when snackbar hiding
                }
            })
                .setAction("Okay!") {
                    Toast.makeText(applicationContext,"show your own action",Toast.LENGTH_SHORT).show()
                }
                .setMessage("Download Complete !!")
                .setTextColor(R.color.white)
                .setBackColor(R.color.black)
                .setDuration(3000)
                .show()
```
+ If you want to close 
```kotlin
yunsSnack.dismiss()
```

###
+ When you click "okay", you can do your own event.
<image src="https://user-images.githubusercontent.com/55985789/92561413-24dec800-f2af-11ea-9cef-28e4194cd657.png" width="230" height="400"/>
