[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Side--Menu.Android-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1388)
Side Menu
==============
Side menu with some categories to choose. 
Made in <a href="http://yalantis.com/"> Yalantis</a>.<br>
Check this <a href="https://dribbble.com/shots/1689922-Side-Menu-Animation?list=searches&tag=yalantis&offset=0">project on dribbble</a>.<br>
Check this <a href="https://www.behance.net/gallery/20411445/Mobile-Animations-Interactions ">project on Behance</a>.

God bless Ukraine!

<img src="https://d13yacurqjgara.cloudfront.net/users/125056/screenshots/1689922/events-menu_1-1-6.gif" />

Sample
======
<a href="https://github.com/Yalantis/Side-Menu.Android/releases/tag/1.0"> Sample & .aar file </a>
Note
====

depends on <a href="https://github.com/ozodrukh">Ozodrukh's</a> animation util for CircularReveal animation for 2.3+ version

Using
======
First of all you have to upload animation submodule with `git submodule update --init` command <br>
<br>
Or you can add gradle dependency with command:<br>
```groovy
	dependencies {
	    compile 'com.yalantis:sidemenu:1.0'`
	}
``` 
.<br>
and command:<br>
```groovy
	repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}
	dependencies {
	    compile 'com.github.ozodrukh:CircularReveal:(latest-release)@aar'
	}

```
<br> for CircularReveal module


After you have to create special overlay layout to show in behind current `Circular Reveal` animated view.
And to add all items to menu you have to add all of them into  `LinearLayout`

```xml
<android.support.v4.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <io.codetail.widget.RevealFrameLayout
        android:id="@+id/conteiner_frame"
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <LinearLayout
            android:id="@+id/content_overlay"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"/>
        <LinearLayout
            android:id="@+id/content_frame"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"/>

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:minHeight="?attr/actionBarSize"
            android:background="?attr/colorPrimary"/>

    </io.codetail.widget.RevealFrameLayout>

    <ScrollView
        android:id="@+id/scrollView"
        android:scrollbarThumbVertical="@android:color/transparent"
        android:layout_width="80dp"
        android:layout_height="match_parent"
        android:layout_gravity="start|bottom">

        <LinearLayout
            android:id="@+id/left_drawer"
            android:orientation="vertical"
            android:layout_width="80dp"
            android:layout_height="wrap_content"
            android:divider="@android:color/transparent"
            android:dividerHeight="0dp"
            android:background="@android:color/transparent">
            <!-- Layout of Drawer -->
        </LinearLayout>
    </ScrollView>
</android.support.v4.widget.DrawerLayout>
```

```java

	ViewAnimator viewAnimator = new ViewAnimator<>(ActionBarActivity.this,
									new ArrayList<Resourceble>(),
									(LinearLayout) findViewById(R.id.left_drawer), 
									contentFragment, drawerLayout);
	//to open menu you have to override ActionBarDrawerToggle method 
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if (slideOffset > 0.6 && viewAnimator.getLinearLayout().getChildCount() == 0)
                    viewAnimator.showMenuContent();
            }
			public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                viewAnimator.getLinearLayout().removeAllViews();
                viewAnimator.getLinearLayout().invalidate();
            }

```
All menu items should implement  `Resourceble`  interface to get menu item name and drawable res 
And all fragments should implement  `ScreenShotable` to get screenshot of a fragment

## License

    Copyright 2015, Yalantis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
