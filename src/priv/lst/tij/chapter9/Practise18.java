package priv.lst.tij.chapter9;

import java.util.Random;

interface Game
{
    void display();
}

interface factory
{
    Game getGame();
}

class ThrowCoin implements Game
{
    public void display()
    {
        Random random = new Random();
        if (random.nextInt(2) == 0)
        {
            System.out.println("正面");
        }
        else
        {
            System.out.println("反面");
        }
    }
}

class ThrowDice implements Game
{
    public void display()
    {
        Random random = new Random();
            System.out.println(random.nextInt(6)+1);
    }
}

class CoinFactory implements factory
{
    public Game getGame()
    {
        return new ThrowCoin();
    }
}

class DiceFactory implements factory
{
    public Game getGame()
    {
        return new ThrowDice();
    }
}

public class Practise18
{
    public static void playGame(Game game)
    {
        for(int i = 0; i < 10; i++)
            game.display();
    }
    
    public static void main(String [] args)
    {
        playGame(new ThrowCoin());
        playGame(new ThrowDice());
    }
}
