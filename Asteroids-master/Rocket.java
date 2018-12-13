import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Rocket extends SmoothMover
{
    //TODO (91): Declare a static integer instance constant called GUN_RELOAD_TIME initialized to 10
    private final static int GUN_RELOAD_TIME = 10;
    
    //TODO (92): Declare a static integer instance constant called WAVE_RELOAD_TIME initialized to 500
    private final static int WAVE_RELOAD_TIME = 500;

    //TODO (93): Declare an integer instance variable called reloadDelayCount
    private int reloadDelayCount;
    
    //TODO (94): Declare an integer instance variable called waveDelayCount
    private int waveDelayCount;

    /**
     * Rocket is the constructor for objects of type Rocket
     * 
     * @param None There are not parameters
     * @return Nothing is returned
     */
    public Rocket()
    {
        
        Vector startMotion = new Vector(getRotation(), 0.7);
        addToVelocity(startMotion);
        
        //TODO (95): Initialize reloadDelayCount to 10
        reloadDelayCount = 10;

        //TODO (96): Initialize waveDelayCount to 500
        waveDelayCount = 500;
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        //TODO (113): Remove the two slashes in front of this line of code
        checkWin();
        
        move();
        
              
        //TODO (25): Make a call to the method that checks if the user has pressed keys
        //Make a method call to checkKeys
        checkKeys();
        

        //TODO (77): Make a call to the method that checks if the user has collided with an asteroid
        checkCollision();

        //TODO (97): Increase reloadDelayCount and waveDelayCount by 1 each
        reloadDelayCount ++;
        
        waveDelayCount ++;
    }
    
    /**
     * checkWin checks to see if there are no more asteroids in the world,
     * which means that the game has been won
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkWin()
    {
        Space world = (Space)getWorld();
        
        if( world.getObjects(Asteroid.class).size() == 0 )
        {
            world.gameWon();
        }
    }
    
    /**
     * TODO (11): Declare a method called checkKeys that does not
     *          return anything and has not parameters
     *          
     * TODO (109): If the user presses the space key...
     * 
     *      TODO (110): Fire bullets
     *      
     * TODO (12): If the user presses the left key...
     * 
     *      TODO (13): Turn left 5 degrees
     *      
     * TODO (14): If the user presses the right key...
     * 
     *      TODO (15): Turn right 5 degrees
     *      
     * TODO (111): If the user presses the z key...
     * 
     *      TODO (112): Start a proton wave
     *      
     * TODO (24): Make a method call to ignite using Greenfoot.isKeyDown("up") as a parameter
     */
    
    /**
     * ckeckKeys checks which key has been pressed and depending on which key is presses, it 
     * instructs the scenario what to do next
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkKeys()
    {
        //If the user presses the space key...
        if(Greenfoot.isKeyDown("space"))
        {
            //Fire bullets
            fire();
        }
        
        //If the user presses the left key..
        if(Greenfoot.isKeyDown("left"))
        {
            //Turn left 5 degrees
            turn(-5);
        }
        
        //If the user presses the right key...
        if (Greenfoot. isKeyDown("right"))
        {
            //Turn right 5 degrees
            turn(5);
        }
        
        // If the user presses the z key...
        if(Greenfoot. isKeyDown("z"))
        {
            startProtonWave();
        }
        //Make a method call to ignite using Greenfoot.isKeyDown("up") as a parameter
        ignite(Greenfoot.isKeyDown("up"));
    }

    /**
     * TODO (98): Declare a method called fire that does not
     *            return anything and has no parameters
     * 
     * TODO (99): Declare a local Bullet variable called bullet that
     *            is initialized to a new Bullet object that uses
     *            getVelocity() and getRotation() as parameters
     * 
     * TODO (100): If reloadDelayCount is greater than or equal to GUN_RELOAD_TIME...
     * 
     *      TODO (101): Add the bullet object at the current X location and the current Y location
     *      
     *      TODO (102): Access the move method of bullet
     *      
     *      TODO (103): Set the reloadDelayCount equal to 0
     */
    
    /**
     * fire causes the bullets to be fired in the scenario
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void fire()
    {
        //Declare a local Bullet variable called bullet that is initialized to a new Bullet object that uses getVelocity() and getRotation() as parameters
        Bullet bullet = new Bullet(getVelocity(), getRotation());
        
        // If reloadDelayCount is greater than or equal to GUN_RELOAD_TIME...
        if(reloadDelayCount >= GUN_RELOAD_TIME)
        {
            //Add the bullet object at the current X location and the current Y location
            getWorld().addObject(bullet,getX(),getY());
            
            //Access the move method of bullet
            move();
            
            //Set the reloadDelayCount equal to 0
            reloadDelayCount = 0;
        }
    }
    /**
     * TODO (104): Declare a method called startProtonWave that does not
     *            return anything and has no parameters
     *          
     * TODO (105): Declare a local ProtonWave variable called wave that is
     *            initialized to a new ProtonWave object
     *          
     * TODO (106): If waveDelayCount is greater than or equal to WAVE_RELOAD_TIME...
     * 
     *      TODO (107): Add wave to the current X location and the current Y location
     *      
     *      TODO (108): Set the waveDelayCount equal to 0
     */
    
    /**
     * startProtonWave starts the proton wave using a ProtonWave variable called wave
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */

    private void startProtonWave()
    {
        //Declare a local ProtonWave variable called wave that is initialized to a new ProtonWave object
        ProtonWave wave = new ProtonWave();
        
        //If waveDelayCount is greater than or equal to WAVE_RELOAD_TIME...
        if(waveDelayCount >= WAVE_RELOAD_TIME)
        {
            //Add wave to the current X location and the current Y location
            getWorld().addObject(wave,getX(),getY());
            
            //Set the waveDelayCount equal to 0
            waveDelayCount = 0;
        }
    }
    
    /**
     * TODO (16): Declare a method called ignite that does not
     *            return anything and has a boolean parameter
     *            called boosterOn
     *          
     * TODO (17): Declare a local GreenfootImage variable called
     *            rocket that is initialized to a new GreenfootImage
     *            object using the rocket.png file
     *          
     * TODO (18): Declare a local GreenfootImage variable called
     *            rocketWithThrust that is initialized to a new
     *            GreenfootImage object using the rocketWithThrust.png file
     *          
     * TODO (19): If boosterOn is true...
     * 
     *      TODO (20): Set the image to rocketWithThrust
     *      
     *      TODO (21): Make a method call to addToVelocity using a new
     *                 Vector object with parameters getRotation() and 0.3
     *               
     * TODO (22): Otherwise...
     * 
     *      TODO (23): Set the image to rocket
     */
    
    /**
     * ignite causes the rocket to move forward at a faster pace
     * 
     * @param None there are no parameters
     * @return Nothing is returned
     */
    private void ignite(boolean boosterOn)
    {
        //a local GreenfootImage variable called rocket that is initialized to a new GreenfootImage object using the rocket.png file
        GreenfootImage rocket = new GreenfootImage("rocket.png");
        
        //a local GreenfootImage variable called rocketWithThrust that is initialized to a new GreenfootImage object using the rocketWithThrust.png file
        GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");
        
        //If boosterOn is true...
        if(boosterOn == true)
        {
           //Set the image to rocketWithThrust
           setImage(rocketWithThrust);
           
           //Make a method call to addToVelocity using a new Vector object with parameters getRotation() and 0.3
           addToVelocity(new Vector(getRotation(),0.3));
        }
        
        //Otherwise...
        else
        {
            //Set the image to rocket
            setImage(rocket);
        }
    }

    /**
     * TODO (70): Declare a method called checkCollision that does not
     *          return anything and has no parameters
     *          
     * TODO (71): Declare a local Space variable called space that
     *          stores a reference to the world
     *          
     * TODO (72): Declare a local Actor variable called currentAsteroid
     *          that is initialized to get one intersectinf object of
     *          class Asteroid
     *          
     * TODO (73): If currentAsteroid is not nothing...
     * 
     *      TODO (74): Add a new Explosion object at the current X location and the current Y location
     *      
     *      TODO (75): Remove this object
     *      
     *      TODO (76): Make a method call to space's game over method
     */
    /**
     * checkCollision checks whether or not there is a collision and what to do if there is
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    
    private void checkCollision()
    {
        //Declare a local Space variable called space that stores a reference to the world
        Space space = ((Space)getWorld());
        
        //Declare a local Actor variable called currentAsteroid that is initialized to get one intersectinf object of class Asteroid
        Actor currentAsteroid = getOneIntersectingObject(Asteroid.class);
        
        //If currentAsteroid is not nothing...
        if(currentAsteroid != null)
        {
            //Add a new Explosion object at the current X location and the current Y location
            getWorld().addObject(new Explosion(), getX(), getY());
            
            //Remove this object
            getWorld().removeObject(this);
            
            //Make a method call to space's game over method
            space.gameOver();
        }
    }
}