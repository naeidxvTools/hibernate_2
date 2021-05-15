package net.imwork.zhanlong.hibernate12;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class Team implements Comparator<String>
{
    private String id;
    private String teamName;
    private Map<String, String> students = new HashMap<>();

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public Map<String, String> getStudents()
    {
        return students;
    }

    public void setStudents(Map<String, String> students)
    {
        this.students = students;
    }


    @Override
    public int compare(String o1, String o2)
    {
        return o1.compareTo(o2);
    }
}
