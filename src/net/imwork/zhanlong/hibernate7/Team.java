package net.imwork.zhanlong.hibernate7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class Team
{
    private String id;
    private String teamName;
    private Map<String,String> students = new HashMap<>();

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
}
