package com.frontend.kanishk.predicto;


 import android.graphics.PixelFormat;
 import android.os.Bundle;
 import android.app.Activity;
 import android.content.Intent;
 import android.view.Window;
 import android.widget.ImageView;
 import java.util.Random;
import android.os.Handler;
import android.graphics.PixelFormat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

 public class Splashscreen extends Activity
 {
  public void onAttatchedToWindow()
  {
   super.onAttachedToWindow();
   Window window = getWindow();
   window.setFormat(PixelFormat.RGBA_8888);
  }
  Thread splashThread;
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_splashscreen);
   StartAnimations();
  }
  private void StartAnimations()
  {
   Animation anim =AnimationUtils.loadAnimation(this,R.anim.alpha);
   anim.reset();
   LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
   l.clearAnimation();
   l.startAnimation(anim);
   Animation anim1 =AnimationUtils.loadAnimation(this,R.anim.translate);
   anim1.reset();
   LinearLayout l1=(LinearLayout) findViewById(R.id.lin_lay);
   l1.clearAnimation();
   l1.startAnimation(anim1);
   ImageView iv = (ImageView)findViewById(R.id.splash);
   iv.clearAnimation();
   iv.startAnimation(anim);
   splashThread = new Thread()
   {
    @Override
    public  void run()
    {
     try {
      int waited = 0;
      while (waited<3500)
      {
       sleep(100);
       waited+=100;
      }
      Intent intent = new Intent(Splashscreen.this,MainActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(intent);
      Splashscreen.this.finish();
     }
     catch (InterruptedException e)
     {

     }
     finally {
      Splashscreen.this.finish();
     }
    }
   };
   splashThread.start();
  }

 }
