import greenfoot.*;

/**
 * A rock in space.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Asteroid extends SmoothMover
{
    //TODO (26): Declare an integer instance variable called size
    /** Size of this asteroid */
    //an integer instance variable called size
    private int size;

    //TODO (27): Declare an integer instance variable called stability
    /** When the stability reaches 0 the asteroid will explode */
    //an integer instance variable called stability
    private int stability;


    /**
     * This is the default constructor for objects of type Asteroid
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public Asteroid()
    {
        this(60);
    }
    
    /**
     * Asteroid is the constructor for objects of type Asteroid.
     * It allows customization of the size of the Asteroid
     * 
     * @param size represents the size of the Asteroid
     * @return An object of type Asteroid
     */
    public Asteroid(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        
        //TODO (32): Delete this line and make a call to the setSize method instead
        setSize(size);
    }
    
    /**
     * Asteroid is the constructor for objects of type Asteroid.
     * It allows customization of the size of the Asteroid and
     * the speed and direction of the Asteroid
     * 
     * @param size represents the size of the Asteroid
     * @param velocity represents the speed and direction of the Asteroid
     * @return An object of type Asteroid
     */
    public Asteroid(int size, Vector velocity)
    {
        super(velocity);
        
        //TODO (33): Delete this line and make a call to the setSize method instead
        setSize(size);
    }
    
    /**
     * act is the method that is run on every 
     * iteration of the act cycle
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {         
        move();
    }

    /**
     * TODO (28): Declare a method called setSize that does not
     *            return anything and has an integer parameter called size
     *          
     * TODO (29): Initialize stability to the size parameter
     * 
     * TODO (30): Initialize the size instance variable to the size parameter
     * 
     * TODO (31): Scale the image of this Asteroid to a width of size and a height of size
     */
      /**
     * setSize sets the size of the asteroids as well as sets their level of stability
     * 
     * @param Has an integer parameter called size which represents the size of the asteroids
     * @return Nothing is returned
     */
    private void setSize(int size)
    {
         //Initialize stability to the size parameter
         stability = size;
         
         //Initialize the size instance variable to the size parameter
         this.size = size;
         
         //Scale the image of this Asteroid to a width of size and a height of size
         getImage().scale(size,size);
    }
    
    /**
     * TODO (51): Declare a public method called hit that does not
     *          return anything and has an integer parameter
     *          called damage.
     *          
     * TODO (52): Declare a local Space variable called space
     *            that stores a reference to the world.
     *          
     * TODO (53): Decrease stability by damage.
     * 
     * TODO (54): If the stability of the asteroid is less than or equal to 0...
     * 
     *      TODO (55): If the size of the asteroid is greater than or equal to 50...
     *      
     *          TODO (56): Use the reference to the world to count 15 points to the score
     *          
     *      TODO (57): Otherwise, if the size of the asteroid is greater than or equal to 25...
     *      
     *          TODO (58): Use the reference to the world to count 30 points to the score
     *          
     *      TODO (59): Otherwise...
     *      
     *          TODO (60): Use the reference to the world to count 50 points to the score
     *          
     *      TODO (61): Break up the asteroid into a number of pieces that is 5 or fewer
     */
    
    /**
     * hit instructs the scenario to increase the amount of damage done to the rocket as a result decreasing its score
     * 
     * @param there is an integer parameter called damage which represents how much damage is done to the rocket
     * @return Nothing is returned
     */
    public void hit(int damage)
    {
        //Declare a local Space variable called space that stores a reference to the world.
        Space space = ((Space)getWorld());
        
        //Decrease stability by damage.
        stability = stability - damage;
        
        //If the stability of the asteroid is less than or equal to 0...
        if(stability <= 0)
        {
            //If the size of the asteroid is greater than or equal to 50...
            if(size >= 50)
            {
                //Use the reference to the world to count 15 points to the score
                space.countScore(15);
            }
            
            //Otherwise, if the size of the asteroid is greater than or equal to 25...
            else if(size >= 25)
            {
                //Use the reference to the world to count 30 points to the score
                space.countScore(30);
            }
            
            //Otherwise
            else
            {
                //Use the reference to the world to count 50 points to the score
                space.countScore(50);
            }
            
            // Break up the asteroid into a number of pieces that is 5 or fewer
            breakUp(Greenfoot.getRandomNumber(6));    
        }
    }
    
    /**
     * TODO (34): Declare a method called breakUp that does not
     *            return anything and has an integer parameter
     *            called numBreakUp
     *          
     * TODO (35): Declare a local integer variable called rotation
     * 
     * TODO (36): Declare a local double variable called length
     * 
     * TODO (37): Declare a local Vector variable called speed
     * 
     * TODO (38): Declare a local Asteroid variable called debris
     * 
     * TODO (39): Play the Explosion.wav sound
     * 
     * TODO (40): If the size of the asteroid is less than or equal to 15...
     * 
     *      TODO (41): Remove this object
     *      
     * TODO (42): Otherwise...
     * 
     *      TODO (43): Initialize rotation to getVelocity().getDirection() + a random number between 0 and 45
     *      
     *      TODO (44): Initialize length to getVelocity().getLength()
     *      
     *      TODO (45): Use a loop that will run as many times as the asteroid needs to break up
     *      
     *          TODO (46): Inside the loop, initialize speed to a new Vector that uses direction plus
     *                     a random number between -100 and 100 and length times 1.2
     *                   
     *          TODO (47): Initialize debris to a new Asteroid that uses size divided by the number
     *                     of break ups as one parameter and speed as the second parameter
     *                   
     *          TODO (48): Add the debris object at the current X location and the current Y location
     *          
     *          TODO (49): Access the move method of debris
     *          
     *     TODO (50): Underneath the for loop, remove this object
     */
    
    /**
     * breakup instructs the code what to do when to asteroids colide
     * 
     * @param Has an integer parameter called numBreakUp which represents the number of pieces that the asteroid breaks into
     * @return Nothing is returned
     */
    
    private void breakUp(int numBreakUp)
    {
         //a local integer variable called rotation
         int rotation;
         
         //a local double variable called length
         double length;
         
         //a local Vector variable called speed
         Vector speed;
         
         //a local Asteroid variable called debris
         Asteroid debris;
         
         //Play the Explosion.wav sound
         Greenfoot.playSound("Explosion.wav");
         
         //If the size of the asteroid is less than or equal to 15...
         if(this.size <= 15)
         {
             //Remove this object
             getWorld().removeObject(this);
         }
         
         //Otherwise...
         else
         {
             //Initialize rotation to getVelocity().getDirection() + a random number between 0 and 45
             rotation = getVelocity().getDirection() + Greenfoot.getRandomNumber(45);
             
             //Initialize length to getVelocity().getLength()
             length = getVelocity().getLength();
             
             //Use a loop that will run as many times as the asteroid needs to break up
             for(int i = 0;i < numBreakUp; i++)
             {
                 //Inside the loop, initialize speed to a new Vector that uses direction plus a random number between -100 and 100 and length times 1.2
                 speed = new Vector(rotation + Greenfoot.getRandomNumber(201)-100, length*1.2);
                 
                 //Initialize debris to a new Asteroid that uses size divided by the number of break ups as one parameter and speed as the second parameter
                 debris = new Asteroid(size/numBreakUp, speed);
                 
                 //Add the debris object at the current X location and the current Y location
                 getWorld().addObject(debris,getX(),getY());
             }
             
             //Remove this object
             getWorld().removeObject(this);
         }
    }
}
