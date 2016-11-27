package chapter8;

import static net.mindview.util.Print.*;

import java.util.Random;

class Rodent
{
    public void bark()
    {
    }
    public void show()
    {
        bark();
    }
}

class Mouse extends Rodent
{
    @Override
    public void bark()
    {
        print("吱吱");
    }
}

class Gerbil extends Rodent
{
    @Override
    public void bark()
    {
        print("嘶嘶");
    }
}

class Hamster extends Rodent
{
    @Override
    public void bark()
    {
        print("哧哧");
    }
}

public class Practice9
{

    public static void main(String[] args)
    {
        Rodent[] rodents = new Rodent[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++)
        {
            switch (random.nextInt(3))
            {
                case 0:
                    rodents[i] = new Mouse();
                    break;
                case 1:
                    rodents[i] = new Hamster();
                    break;
                case 2:
                    rodents[i] = new Gerbil();
                    break;
                default:
                    break;
            }
        }
        
        for(Rodent rodent: rodents)
        {
            rodent.show();
        }
    }
}
