package com.twu.elemento.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.twu.elemento.model.Member;

public interface MemberMapper {
    String MQL_GET_MEMBER_BY_NAME = "select id, name, office from member where name = #{name}";
    String MQL_GET_MEMBER_BY_ID = "select id, name, office from member where id = #{id}";
    String MQL_INSERT_MEMBER = "insert into member(name, office) values(#{name}, #{office})";

    @Select(MQL_GET_MEMBER_BY_NAME)
    Member getByName(String name);

    @Insert(MQL_INSERT_MEMBER)
    @Options(useGeneratedKeys = true)
    void insert(Member member);

    @Select(MQL_GET_MEMBER_BY_ID)
    Member getById(Integer id);
}
