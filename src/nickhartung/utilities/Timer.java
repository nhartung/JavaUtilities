package nickhartung.utilities;

/**
 * 
 * @author Nick Hartung
 * 
 * Base Class used to implement all Timers.
 * This <tt>Timer</tt> class constantly reads its internal "condition" variable and sets the 
 * "active" variable according to the type of <tt>Timer</tt> being implemented. The 
 * {@link Timer#process() process} function should be called every frame, and the Timer condition 
 * should be updated every time it changes. 
 */
public abstract class Timer {
   
   /** 
    * The default duration used when no duration is provided to the 
    * {@link Timer#Timer() constructor}
    */
   protected static final long DEFAULT_DURATION = 1000L;
   /**
    * Constant used for duration when the user wants to specify an infinite time period.
    */
   public    static final long FOREVER          =   -1L;
   
   protected boolean mCondition;
   protected boolean mActive;
   protected boolean mPrimed;
   protected long    mTime;
   protected long    mDuration;
   
   /**
    * Default constructor that uses {@link Timer#DEFAULT_DURATION DEFAULT_DURATION} as the default
    * duration.
    */
   protected Timer() {
      this( DEFAULT_DURATION );
   }
   
   /**
    * Constructor that sets the initial duration to <tt>pDuration</tt>
    * 
    * @param pDuration duration to use for this timer.
    */
   protected Timer( final long pDuration ) {
      this.setDuration( pDuration );
      this.reset();
   }
   
   /**
    * Set the "active" state according to the type of <tt>Timer</tt>. This function should be called 
    * every application frame.
    */
   public abstract void process();
   
   /**
    * Resets the <tt>Timer</tt> to condition it was in when it was first created. (The duration 
    * remains the same)
    */
   public void reset() {
      this.mCondition = false;
      this.mActive    = false;
      this.mPrimed    = false;
      this.mTime      = 0;
   }
   
   /**
    * @param pDuration The duration to set the <tt>Timer</tt> to.
    */
   public void setDuration( final long pDuration ) {
      this.mDuration = pDuration;
   }
   
   /**
    * @param pCondition The condition to be used for the <tt>Timer</tt>
    */
   public void setCondition( final boolean pCondition ) {
      this.mCondition = pCondition;
   }
   
   /**
    * @return The current duration of the <tt>Timer</tt>
    */
   public long getDuration() {
      return this.mDuration;
   }
   
   /**
    * @return <code>true</code> if the necessary conditions have been set to enable the timer,
    * <code>false</code> otherwise.
    */
   public boolean isActive() {
      return this.mActive;
   }
}
