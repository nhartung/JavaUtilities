package nickhartung.utilities;

public abstract class Timer {
   
   protected static final long DEFAULT_DURATION = 1000L;
   public    static final long FOREVER          =   -1L;
   
   protected boolean mCondition;
   protected boolean mActive;
   protected boolean mPrimed;
   protected long    mTime;
   protected long    mDuration;
   
   protected Timer( final long pDuration ) {
      this.setDuration( pDuration );
      this.reset();
   }
   
   protected Timer() {
      this( DEFAULT_DURATION );
   }
   
   public abstract void process();
   
   public void reset() {
      this.mCondition = false;
      this.mActive    = false;
      this.mPrimed    = false;
      this.mTime      = 0;
   }
   
   public void setDuration( final long pDuration ) {
      this.mDuration = pDuration;
   }
   
   public void setCondition( final boolean pCondition ) {
      this.mCondition = pCondition;
   }
   
   public long getDuration() {
      return this.mDuration;
   }
   
   public boolean isActive() {
      return this.mActive;
   }
}
