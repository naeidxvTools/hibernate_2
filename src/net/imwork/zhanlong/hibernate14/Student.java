package net.imwork.zhanlong.hibernate14;

import java.util.Objects;

/**
 * @author Administrator
 */
public class Student
{
	private String id;
	
	private String name;
	
	private String cardId;
	
	private int age;
	
	private Team team;
	
	public String getCardId()
	{
		return cardId;
	}

	public void setCardId(String cardId)
	{
		this.cardId = cardId;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Team getTeam()
	{
		return team;
	}

	public void setTeam(Team team)
	{
		this.team = team;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return age == student.age &&
				Objects.equals(id, student.id) &&
				Objects.equals(name, student.name) &&
				Objects.equals(cardId, student.cardId) &&
				Objects.equals(team, student.team);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name, cardId, age, team);
	}
}
