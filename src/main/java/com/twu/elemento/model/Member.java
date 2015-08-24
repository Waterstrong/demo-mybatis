package com.twu.elemento.model;

public class Member {

    private Integer id;
    private String name;
    private String office;

    public Member() {
    }

    public Member(String name, String office) {
        this.name = name;
        this.office = office;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOffice() {
        return office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != null ? !id.equals(member.id) : member.id != null) return false;
        if (name != null ? !name.equals(member.name) : member.name != null) return false;
        return !(office != null ? !office.equals(member.office) : member.office != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        return result;
    }
}
