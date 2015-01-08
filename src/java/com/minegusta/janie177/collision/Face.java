package com.minegusta.janie177.collision;

public enum Face {
    UP,DOWN,LEFT,RIGHT,IDLE;
    
    private Face()
    {
        
    }
    
    public Face getOpposite()
    {
        Face opposite;
        switch (this)
        {
            case UP: opposite =  DOWN;
                break;
            case DOWN: opposite =  UP;
                break;
            case LEFT: opposite =  RIGHT;
                break;
            case RIGHT: opposite =  LEFT;
                break;
            default: opposite =  UP;
        }
        return opposite;
    }
}
