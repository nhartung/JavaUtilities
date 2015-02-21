package nickhartung.utilities;

public class ExistedTimer extends Timer {

   public ExistedTimer( final long pDuration ) {
      super( pDuration );
   }

   public ExistedTimer() {
      super();
   }
   
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
