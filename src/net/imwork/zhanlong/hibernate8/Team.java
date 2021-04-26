package net.imwork.zhanlong.hibernate8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class Team
{
    private String id;
    private String teamName;
    private Map students = new HashMap<>();

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

    public Map getStudents()
    {
        return students;
    }

    public void setStudents(Map students)
    {
        this.students = students;
    }
}
