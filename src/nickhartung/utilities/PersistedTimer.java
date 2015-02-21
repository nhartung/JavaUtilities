package nickhartung.utilities;

public class PersistedTimer extends Timer {

   public PersistedTimer( final long pDuration ) {
      super( pDuration );
   }

   public PersistedTimer() {
      super();
   }
   
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
