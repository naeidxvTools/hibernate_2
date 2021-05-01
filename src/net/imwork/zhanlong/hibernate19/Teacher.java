package net.imwork.zhanlong.hibernate19;

/**
 * @author Administrator
 */
public class Teacher extends Person
{
    private int salary;

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }
}
