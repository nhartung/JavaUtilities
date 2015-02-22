package nickhartung.utilities;

/**
 * 
 * @author Nick Hartung
 * @see Timer
 * 
 * A <tt>PersistedTimer</tt>'s {@link Timer#isActive() isActive} method returns true if its internal
 * condition has been <code>true</code> for at least the last "duration". It is used to check if a
 * certain condition has been active for a certain amount of time.
 */
public class PersistedTimer extends Timer {

   /**
    * @see Timer 
    */
   public PersistedTimer( final long pDuration ) {
      super( pDuration );
   }

   /**
    * @see Timer 
    */
   public PersistedTimer() {
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
         if( !this.mPrimed ) {
            this.mPrimed = true;
            this.mTime   = System.currentTimeMillis();
         } else if( timeout ) {
            this.mActive = true;
         }
      } else {
         this.reset();
      }
   }

}
