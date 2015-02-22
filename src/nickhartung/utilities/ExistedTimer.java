package nickhartung.utilities;

/**
 * 
 * @author Nick Hartung
 * @see Timer
 * 
 * An <tt>ExistedTimer</tt>'s {@link Timer#isActive() isActive} method returns true if its internal
 * condition has been <code>true</code> at any point in the last "duration". It is used to see if a
 * certain condition has ever been active in a certain time period.
 */
public class ExistedTimer extends Timer {

   /**
    * @see Timer 
    */
   public ExistedTimer( final long pDuration ) {
      super( pDuration );
   }

   /**
    * @see Timer 
    */
   public ExistedTimer() {
      super();
   }
   
   /**
    * @see Timer 
    */
   @Override
   public void process() {
      final boolean timeout =    System.currentTimeMillis() - this.mTime >= this.mDuration
                              && this.mDuration != FOREVER;
      
      if( this.mCondition ) {
         this.mPrimed = false;
         this.mActive = true;
      } else if( !this.mPrimed ) {
         this.mPrimed = true;
         this.mTime = System.currentTimeMillis();
      } else if( timeout ) {
         this.mActive = false;
      }
   }
}
