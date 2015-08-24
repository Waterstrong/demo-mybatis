package com.twu.elemento.mapper;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.twu.elemento.model.Member;
import com.twu.elemento.util.DBUtil;

public class MemberMapperTest {

    private MemberMapper memberMapper;
    private SqlSession sqlSession;

    @Before
    public void setUp() {
        sqlSession = DBUtil.getSqlSessionFactory().openSession();
        memberMapper = sqlSession.getMapper(MemberMapper.class);
    }

    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void shouldInsertMemberAndGetMemberByName() {
        Member member = new Member("sqlin", "Chengdu, China");

        memberMapper.insert(member);
        Member fetchedMember = memberMapper.getByName(member.getName());

        assertEquals(member, fetchedMember);
    }

    @Test
    public void shouldInsertMemberAndGetMemberById() {
        Member member = new Member("Water", "Xi'an, China");

        memberMapper.insert(member);
        Member fetchedMember = memberMapper.getById(member.getId());

        assertEquals(member, fetchedMember);
    }

    @Test(expected = PersistenceException.class)
    public void shouldNotInsertMemberOfDuplicateName() {
        Member member = new Member("same", "Wuhan, China");
        Member otherMember = new Member("same", "Beijing, China");

        memberMapper.insert(member);
        memberMapper.insert(otherMember);
    }
}
