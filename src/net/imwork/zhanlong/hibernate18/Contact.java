package net.imwork.zhanlong.hibernate18;

import java.util.Objects;

/**
 * @author Administrator
 */
public class Contact
{
    private String student_id;

    private String method;
    private String address;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(student_id, contact.student_id) &&
                Objects.equals(method, contact.method) &&
                Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(student_id, method, address);
    }

    public String getStudent_id()
    {
        return student_id;
    }

    public void setStudent_id(String student_id)
    {
        this.student_id = student_id;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
