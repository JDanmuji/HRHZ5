package member.dao;

import hrhz.dto.MemberDTO;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberDAOMyBatis implements MemberDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public MemberDTO getMember(String phone) {
        System.out.println("마이바티스 이다");
        MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getMember", phone);
        System.out.println(memberDTO);
        return memberDTO;
    }

	@Override
	public void memberInsert(HashMap<String, Object> dataMap) {
		sqlSession.insert("memberSQL.memberInsert", dataMap);
	}

	@Override
	public String loginCheck(HashMap<String, Object> dataMap) {
		return sqlSession.selectOne("memberSQL.loginCheck", dataMap);
	}
}
