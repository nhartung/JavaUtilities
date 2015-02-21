package nickhartung.utilities.test;

import nickhartung.utilities.ExistedTimer;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExistedTimerTest {

   @Test
   public void testProcess() {
      ExistedTimer timer = new ExistedTimer( 1000L );
      
      timer.setCondition( true );
      assertFalse( "Condition Set, process() not called.", timer.isActive() );
      
      timer.process();
      assertTrue( "Condition true. Process called.", timer.isActive() );
      
      timer.setCondition( false );
      timer.process();
      this.sleep( 999L );
      timer.process();
      assertTrue( "Time not passed, still true.", timer.isActive() );
      
      this.sleep( 1L );
      assertTrue( "Time passed, but process() not called.", timer.isActive() );
      timer.process();
      assertFalse( "Time passed and process() called.", timer.isActive() );
   }

   @Test
   public void testExistedTimerLong() {
      ExistedTimer timer = new ExistedTimer( 500L );
      assertEquals( "Timer Long Constructor", timer.getDuration(), 500L );
      
      timer = new ExistedTimer( Long.MAX_VALUE );
      assertEquals( "Timer Long Constructor Long.MAX_VALUE", timer.getDuration(), Long.MAX_VALUE );
      
      timer = new ExistedTimer( Long.MIN_VALUE );
      assertEquals( "Timer Long Constructor Long.MIN_VALUE", timer.getDuration(), Long.MIN_VALUE );
   }

   @Test
   public void testExistedTimer() {
      ExistedTimer timer = new ExistedTimer();
      assertEquals( "Timer Default Constructor", timer.getDuration(), 1000L );
   }

   @Test
   public void testReset() {
      ExistedTimer timer = new ExistedTimer( 100L );
      
      timer.setCondition( true );
      timer.process();
      assertTrue( "Condition true, process called", timer.isActive() );
      
      timer.reset();
      assertFalse( "Condition was true, but reset was called.", timer.isActive() );
      
      timer.setCondition( true );
      timer.process();
      
      this.sleep( 99L );
      timer.process();
      assertTrue( "Condition true, timeout has not occured", timer.isActive() );
      
      timer.reset();
      timer.setCondition( true );
      timer.process();
      
      this.sleep( 99L );
      assertTrue( "Condition true, timeout has not occured because reset was called between the two sleep periods", timer.isActive() );
   }

   @Test
   public void testGetSetDuration() {
      ExistedTimer timer = new ExistedTimer( 1000L );
      assertEquals( "Get/Set Duration from constructor.", timer.getDuration(), 1000L );
      
      timer.setDuration( 2000L );
      assertEquals( "Get/Set Duration 2000L.", timer.getDuration(), 2000L );
      
      timer.setDuration( Long.MAX_VALUE );
      assertEquals( "Get/Set Duration Long.MAX_VALUE", timer.getDuration(), Long.MAX_VALUE );
      
      timer.setDuration( Long.MIN_VALUE );
      assertEquals( "Get/Set Duration Long.MIN_VALUE", timer.getDuration(), Long.MIN_VALUE );
   }

   @Test
   public void testIsActive() {
      ExistedTimer timer = new ExistedTimer( 10L );
      
      timer.setCondition( false );
      timer.process();
      assertFalse( "Condition is false.", timer.isActive() );
      
      timer.setCondition( true );
      timer.process();
      assertTrue( "Condition is true.", timer.isActive() );
      
      timer.setCondition( false );
      timer.process();
      this.sleep( 9L );
      timer.process();
      assertTrue( "Condition is false, but timout has not occured.", timer.isActive() );
      
      this.sleep( 1L );
      timer.process();
      assertFalse( "Condition is false, and timout has occured.", timer.isActive() );
   }
   
   private void sleep( final long pSleepDuration ) {
      try {
         Thread.sleep( pSleepDuration );
      } catch (InterruptedException e) {
         fail( "Thread.sleep was interrupted" );
      }
   }
   
}
